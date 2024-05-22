package tienda;

public class GestionCliente {

  public static void verMenu() {
    int menuSeleccionado = 0;
    do {
      System.out.println("++++++ Administración de Tienda ++++++");
      System.out.println("***** Menú Cliente *****");
      String menu = """
          1. Crear Cliente
          2. Editar Cliente
          3. Ver Clientes
          9. Regresar
          """;
      System.out.println(menu);

      try {
        System.out.print("Selecciona un menú: ");
        menuSeleccionado = Integer.parseInt(System.console().readLine());

        switch (menuSeleccionado) {
          case 1:
            crearCliente();
            break;
          case 2:
            // editar cliente
            break;
          case 3:
            verClientes();
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
  }

  public static void crearCliente() {
    try {
      System.out.print("Identificación: ");
      String identificacion = System.console().readLine();
      System.out.print("Nombres: ");
      String nombres = System.console().readLine();
      System.out.print("Apellidos: ");
      String apellidos = System.console().readLine();

      Cliente cliente = new Cliente(identificacion, nombres, apellidos);
      cliente.guardar();

    } catch (NumberFormatException error) {
      System.out.println("Error al convertir un número:\n" + error.getMessage());
    } catch (java.io.IOError error) {
      System.out.println("Error al capturar un dato:\n" + error.getMessage());
    }
    System.out.println();
  }

  public static void guardarClientes() {
    Cliente.guardarClientes();
  }

  public static void leerClientes() {
    Cliente.leerClientes();
  }

  public static void verClientes() {
    Cliente.verClientes();
  }
}
