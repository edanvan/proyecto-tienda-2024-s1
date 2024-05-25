package tienda;

import java.util.Scanner;

public class ProductoVenta {
    public static void main(String[] args) {

        Player player = new Player(1000);


        Product apple = new Product("Manzana", 2.5);
        Product aspirin = new Product("Aspirina", 5.0);
        Product notebook = new Product("Cuaderno", 3.0);


        Scanner scanner = new Scanner(System.in);

        boolean continueShopping = true;

        while (continueShopping) {
            System.out.println("Saldo actual: " + player.getBalance() + " dólares");
            System.out.println("Seleccione una opción: [C] Comprar, [V] Vender, [N] Salir");
            String option = scanner.nextLine().toUpperCase();

            switch (option) {
                case "C":
                    System.out.println("Seleccione el producto para comprar: [1] Manzana, [2] Aspirina, [3] Cuaderno");
                    int buyOption = scanner.nextInt();
                    System.out.println("Ingrese la cantidad:");
                    int buyQuantity = scanner.nextInt();
                    scanner.nextLine(); 

                    if (buyOption == 1) {
                        player.buy(apple, buyQuantity);
                    } else if (buyOption == 2) {
                        player.buy(aspirin, buyQuantity);
                    } else if (buyOption == 3) {
                        player.buy(notebook, buyQuantity);
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                case "V":
                    System.out.println("Seleccione el producto para vender: [1] Manzana, [2] Aspirina, [3] Cuaderno");
                    int sellOption = scanner.nextInt();
                    System.out.println("Ingrese la cantidad:");
                    int sellQuantity = scanner.nextInt();
                    scanner.nextLine(); 

                    if (sellOption == 1) {
                        player.sell(apple, sellQuantity);
                    } else if (sellOption == 2) {
                        player.sell(aspirin, sellQuantity);
                    } else if (sellOption == 3) {
                        player.sell(notebook, sellQuantity);
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                case "N":
                    continueShopping = false;
                    System.out.println("Gracias por visitar la tienda. Saldo final: " + player.getBalance() + " dólares");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}

class Player {
    private double balance;
    private final double MAX_BALANCE = 2500;

    public Player(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void buy(Product product, int quantity) {
        double cost = product.getPrice() * quantity;
        if (balance >= cost) {
            balance -= cost;
            System.out.println("Compraste " + quantity + " " + product.getName() + "(s) por " + cost + " dólares.");
        } else {
            System.out.println("Fondos insuficientes para comprar " + quantity + " " + product.getName() + "(s).");
        }
    }

    public void sell(Product product, int quantity) {
        double revenue = product.getPrice() * quantity;
        if (balance + revenue <= MAX_BALANCE) {
            balance += revenue;
            System.out.println("Vendiste " + quantity + " " + product.getName() + "(s) por " + revenue + " dólares.");
        } else {
            System.out.println("No puedes vender " + quantity + " " + product.getName() + "(s) porque excederías el saldo máximo permitido.");
        }
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
