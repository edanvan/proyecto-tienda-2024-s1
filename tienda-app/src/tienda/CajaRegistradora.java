package tienda;

import java.util.Scanner;

public class CajaRegistradora {

  public static void main() {
    Scanner scanner = new Scanner(System.in);
    // Lista de productos
    String[] productos = { "Arroz", "Frijoles", "Aceite de cocina", "Harina de trigo", "Azúcar", "Sal", "Pasta",
        "Salsa de tomate", "Café", "Té", "Leche", "Huevos", "Pan", "Papel higiénico", "Jabón", "Champú",
        "Pasta de dientes", "Cepillos de dientes", "Galletas", "Refrescos" };
    double[] preciosUnitarios = { 855, 1045, 1900, 380, 570, 950, 760, 285, 190, 190, 855, 95, 95, 475, 570, 285,
        665, 760, 152, 228 };
    String[] presentaciones = { "libra", "libra", "litro", "libra", "kilo", "kilo", "paquete", "sobre", "sobre",
        "sobre", "bolsa", "unidad", "unidad", "rollo", "unidad", "sobre", "tubo", "unidad", "paquete",
        "botella" };
    double iva = 0.19; // Tasa de IVA

    // Variables para el total de la compra
    double totalSinIVA = 0;
    double totalIVA = 0;
    double totalConIVA = 0;

    // Bucle para ingresar los productos
    int cantidadProducto;
    String nombreProducto;
    double precioUnitario;
    String presentacion;
    double precioTotalSinIVA;
    double precioIVA;
    double precioTotalConIVA;

    System.out.println("Bienvenido a la caja registradora");

    do {
      System.out.println("\nSeleccione un producto:");
      for (int i = 0; i < productos.length; i++) {
        System.out.printf("%d. %s (%s)\n", i + 1, productos[i], presentaciones[i]);
      }
      System.out.print("Ingrese el número del producto (0 para salir): ");
      int opcionProducto = scanner.nextInt();
      scanner.nextLine(); // Consumir el salto de línea

      if (opcionProducto > 0 && opcionProducto <= productos.length) {
        System.out.print("Ingrese la cantidad: ");
        cantidadProducto = scanner.nextInt();
        scanner.nextLine();

        nombreProducto = productos[opcionProducto - 1];
        precioUnitario = preciosUnitarios[opcionProducto - 1];
        presentacion = presentaciones[opcionProducto - 1];

        precioTotalSinIVA = cantidadProducto * precioUnitario;
        precioIVA = precioTotalSinIVA * iva;
        precioTotalConIVA = precioTotalSinIVA + precioIVA;

        System.out.printf("\n%s x %d (%s):\n", nombreProducto, cantidadProducto, presentacion);
        System.out.printf("Precio unitario: $%.2f\n", precioUnitario);
        System.out.printf("Subtotal: $%.2f\n", precioTotalSinIVA);
        System.out.printf("IVA: $%.2f\n", precioIVA);
        System.out.printf("Total: $%.2f\n", precioTotalConIVA);

        totalSinIVA += precioTotalSinIVA;
        totalIVA += precioIVA;
        totalConIVA += precioTotalConIVA;
      } else if (opcionProducto == 0) {
        System.out.println("Saliendo de la caja registradora");
        break;
      } else {
        System.out.println("Opción no válida");
      }
    } while (true);

    // Mostrar el total de la compra
    System.out.println("\nResumen de compra:");
    System.out.printf("Subtotal: $%.2f\n", totalSinIVA);

    scanner.close();
  }
}