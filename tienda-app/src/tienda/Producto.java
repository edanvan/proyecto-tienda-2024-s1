package tienda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Producto {

    private static final List<Producto> productos = new ArrayList<Producto>(10);

    private static final String nombreArchivo = "datos/productos.csv";

    public static void guardarProductos() {

        String rutaArchivo = FileSystems.getDefault().getPath(nombreArchivo).toAbsolutePath().toString();

        try (Formatter escritor = new Formatter(rutaArchivo, "UTF-8")) {
            for (Producto producto : productos) {
                // Escribir cada atributo separándolos con comas(,) y un salto de línea al final
                // para cada producto
                escritor.format("%s,%s,%.2f,%.2f,%d%n", producto.getCodigo(), producto.getNombre(),
                        producto.getPrecio(),
                        producto.getPorcentajeIva(), producto.getCantidadInventario());
            }

        } catch (SecurityException | FileNotFoundException | FormatterClosedException
                | UnsupportedEncodingException error) {
            System.out.printf("Error al guardar la lista de productos:%n%s%n", error);
        }
    }

    public static void leerProductos() {
        String rutaArchivo = FileSystems.getDefault().getPath(nombreArchivo).toAbsolutePath().toString();
        // El scanner separará los atributos usando comas (,) pero evitará leer líneas
        // vacías (\R)
        try (Scanner lector = new Scanner(Path.of(rutaArchivo).toAbsolutePath(), "UTF-8").useDelimiter(",|\\R")) {
            // leer cada línea del archivo hasta que no queden más líneas
            while (lector.hasNext()) {
                // crear un producto con los datos de la línea
                Producto producto = new Producto(lector.next(), lector.next(), lector.nextDouble(), lector.nextDouble(),
                        lector.nextInt());
                // // agregar el cliente a la lista de clientes.
                productos.add(producto);
            }
        } catch (IOException | NoSuchElementException | IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public static void verProductos() {
        String formatoEncabezado = "| %-10s | %-30s | %-10s | %-8s | %-10s | %-10s |%n";
        System.out.printf(formatoEncabezado, "CÓDIGO", "NOMBRE", "PRECIO BASE", "IVA (%)", "PRECIO FINAL",
                "INVENTARIO");

        String formatoFilas = "| %-10s | %-30s | %,11.2f | %,8.2f | %,12.2f | %10d |%n";
        System.out.println("=".repeat(100));

        for (Producto producto : productos) {
            System.out.printf(formatoFilas, producto.getCodigo(), producto.getNombre(), producto.getPrecio(),
                    producto.getPorcentajeIva(), producto.getPrecio() * (1 + (producto.getPorcentajeIva() / 100.0d)),
                    producto.getCantidadInventario());
        }

        System.out.println("-".repeat(100));
    }

    private String codigo;
    private String nombre;
    private double precio;
    private double porcentajeIva;
    private int cantidadInventario;

    public Producto() {
        this("", "", 0.0d, 0.0d, 0);
    }

    public Producto(String codigo, String nombre, double precio, double getPorcentajeIva, int cantidadInventario) {
        setCodigo(codigo);
        setNombre(nombre);
        setPrecio(precio);
        setPorcentajeIva(getPorcentajeIva);
        setCantidadInventario(cantidadInventario);
    }

    public double calcularValorTotal() {
        return precio * (porcentajeIva / 100.0d) * cantidadInventario;
    }

    public void guardar() {
        Producto.productos.add(this);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public double getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(double porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public int getCantidadInventario() {
        return cantidadInventario;
    }

    public void setCantidadInventario(int cantidad) {
        this.cantidadInventario = cantidad;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Cantidad: " + cantidadInventario);
        System.out.println("Valor Total: $" + calcularValorTotal());
    }
}