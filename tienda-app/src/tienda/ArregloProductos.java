package objetos;
class Producto {
    String nombre;
    double precio;
    int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Getters and setters (opcionales)

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // ... (otros getters y setters para precio y cantidad)

    // Método para calcular el valor total del producto
    public double calcularValorTotal() {
        return precio * cantidad;
    }

    // Método toString para imprimir información del producto
    @Override
    public String toString() {
        return "Producto: " + nombre + ", Precio: $" + precio + ", Cantidad: " + cantidad + ", Valor Total: $" + calcularValorTotal();
    }
}
public class ArregloProductos {

    public static void main(String[] args) {
        // Creación del arreglo de productos
        Producto[] productos = new Producto[2];

        // Inicialización de productos
        productos[0] = new Producto("Manzanas", 2.50, 10);
        productos[1] = new Producto("Leche", 3.20, 5);

        // Cálculo y muestra del valor total para cada producto
        for (Producto producto : productos) {
            System.out.println(producto); // Imprime la información del producto y su valor total
        }

        // Cálculo y muestra del valor total de todos los productos
        double valorTotal = 0;
        for (Producto producto : productos) {
            valorTotal += producto.calcularValorTotal();
        }
        System.out.println("\nValor total de la compra: $" + valorTotal);
    }
}
