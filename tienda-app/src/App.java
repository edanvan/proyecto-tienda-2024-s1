import tienda.CajaRegistradora;
import tienda.GestionCliente;
import tienda.GestionProducto;
import tienda.ProductoVenta;

public class App {
  public static void main(String[] args) throws Exception {

    App.leerDatos();

    int menuSeleccionado = 0;
    do {
      System.out.println("++++++ Administración de Tienda ++++++");
      System.out.println("***** Menú Principal *****");
      String menu = """
          1. Registrar Producto Venta
          2. Manejar Caja Registradora
          3. Gestionar Productos
          4. Gestionar Clientes
          8. Ver Acerca de
          9. Salir
          """;
      System.out.println(menu);

      try {
        System.out.print("Selecciona un menú: ");
        menuSeleccionado = Integer.parseInt(System.console().readLine());

        switch (menuSeleccionado) {
          case 1:
            ProductoVenta.main(args);
            break;
          case 2:
            CajaRegistradora.main();
            break;
          case 3:
            GestionProducto.verMenu();
            break;
          case 4:
            GestionCliente.verMenu();
            break;
          case 8:
            verAcercaDe();
            break;
          default:
            break;
        }
      } catch (NumberFormatException error) {
        System.out.println("Error al convertir un número:\n" + error.getMessage());
      } catch (java.io.IOError error) {
        System.out.println("Error al capturar un dato:\n" + error.getMessage());
      }

      System.out.println("\n");
    } while (menuSeleccionado != 9);

    App.guardarDatos();
    System.out.println("Elegiste salir. Adiós.");
  }

  static void leerDatos() {
    GestionCliente.leerClientes();
    GestionProducto.leerProductos();
  }

  static void guardarDatos() {
    GestionCliente.guardarClientes();
    GestionProducto.guardarProductos();
  }

  static void verAcercaDe() {
    String mensaje = """
        Integrantes:

          - Juan Pablo Carrero
          - Eder Andrés Ávila
          - José Luis Rodríguez
          - Sebastián Rodríguez
          - Valeryn Michel Pérez

        Asignatura: Fundamentos de Programación
        Programa: Tecnología en Programación de Sistemas Informáticos
        Facultad: Estudios a Distancia (FESAD)
        Universidad Pedagógica y Tecnológica de Colombia
        Fecha: 25 de mayo de 2024
        """;

    System.out.println("++++++ Administración de Tienda ++++++");
    System.out.println("***** Acerca de *****");
    System.out.println(mensaje);
  }
}
