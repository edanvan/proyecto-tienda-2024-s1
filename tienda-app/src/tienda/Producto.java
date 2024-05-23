package tienda;

public class Producto {

    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double calcularValorTotal() {
        return precio * cantidad;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Valor Total: $" + calcularValorTotal());
    }

    public static void main(String[] args) {

        Producto producto1 = new Producto("Manzana", 0.75, 100);

        producto1.mostrarInformacion();

        producto1.setCantidad(120);

        System.out.println("\nInformación actualizada del producto:");
        producto1.mostrarInformacion();
    }
}