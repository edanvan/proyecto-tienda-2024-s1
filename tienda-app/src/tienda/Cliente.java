package tienda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Cliente {
  private static final List<Cliente> clientes = new ArrayList<Cliente>(10);
  private static final String nombreArchivo = "./datos/clientes.csv";

  public static void guardarClientes() {

    try (Formatter escritor = new Formatter(nombreArchivo, "UTF-8")) {
      // 
      for (Cliente cliente : clientes) {
        // escribir cada atributo separándolos con comas(,) y un salto de línea al final para cada cliente
        escritor.format("%s,%s,%s%n", cliente.getIdentificacion(), cliente.getNombres(), cliente.getApellidos());
      }
    } catch (SecurityException | FileNotFoundException | FormatterClosedException
        | UnsupportedEncodingException error) {
      System.out.printf("Error al guardar la lista de clientes:%n%s%n", error);
    }
  }

  public static void leerClientes() {
    // El scanner separará los atributos usando comas (,) pero evitará leer líneas vacías (\R)
    try (Scanner lector = new Scanner(Paths.get(nombreArchivo), "UTF-8").useDelimiter(",|\\R")) {
      // leer cada línea del archivo hasta que no queden más líneas
      while (lector.hasNext()) {
        // crear un cliente con los datos de la línea
        Cliente cliente = new Cliente(lector.next(), lector.next(), lector.next());
        // // agregar el cliente a la lista de clientes.
        clientes.add(cliente);
      }
    } catch (IOException | NoSuchElementException | IllegalStateException e) {
      e.printStackTrace();
    }
  }

  public static void verClientes() {
    String formatoEncabezado = "| %-14s | %-14s | %-14s |%n";
    System.out.printf(formatoEncabezado, "IDENTIFICACIÓN", "NOMBRES", "APELLIDOS");

    String formatoFilas = "| %-14s | %-14s | %-14s |%n";
    System.out.println("=".repeat(52));

    for (Cliente cliente : clientes) {
      System.out.printf(formatoFilas, cliente.getIdentificacion(), cliente.getNombres(), cliente.apellidos);
    }

    System.out.println("-".repeat(52));

  }

  private String identificacion;
  private String nombres;
  private String apellidos;

  public Cliente() {
    this("", "", "");
  }

  public Cliente(String identificacion, String nombres, String apellidos) {
    setIdentificacion(identificacion);
    setNombres(nombres);
    setApellidos(apellidos);
  }

  public boolean guardar() {
    return Cliente.clientes.add(this);
  }

  public String getIdentificacion() {
    return identificacion;
  }

  public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
  }

  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

}