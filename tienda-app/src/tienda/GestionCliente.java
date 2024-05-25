package tienda;

public class GestionCliente {

  public static void verMenu() {
    GestionCliente.leerClientes();
    
    int menuSeleccionado = 0;
    do {
      System.out.println("++++++ Administración de Tienda ++++++");
      System.out.println("***** Menú Clientes *****");
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
            editarCliente();
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
    System.out.println("++++++ Administración de Tienda ++++++");
    System.out.println("***** Crear Cliente *****");
    try {
      System.out.print("Identificación: ");
      String identificacion = System.console().readLine();
      System.out.print("Nombres: ");
      String nombres = System.console().readLine();
      System.out.print("Apellidos: ");
      String apellidos = System.console().readLine();

      Cliente cliente = new Cliente(identificacion, nombres, apellidos);

      cliente.guardar();
      GestionCliente.guardarClientes();

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

  public static void editarCliente() {
    System.out.println("++++++ Administración de Tienda ++++++");
    System.out.println("***** Editar Cliente *****");

    try {
      System.out.print("Identificación: ");
      String identificacionCliente = System.console().readLine().trim();
      // primero, buscar si el cliente existe
      Cliente cliente = Cliente.buscarCliente(identificacionCliente);

      if (cliente == null) {
        System.out.printf("Error: no existe un cliente con identificación: %s%n", identificacionCliente);
        return;
      }

      // El cliente existe, mostrar los datos del cliente
      String formatoEncabezado = "| %-14s | %-14s | %-14s |%n";
      System.out.printf(formatoEncabezado, "IDENTIFICACIÓN", "NOMBRES", "APELLIDOS");

      String formatoFilas = "| %-14s | %-14s | %-14s |%n";
      System.out.println("=".repeat(52));

      System.out.printf(formatoFilas, cliente.getIdentificacion(), cliente.getNombres(), cliente.getApellidos());

      System.out.println("-".repeat(52));

      // Ahora, pedir los nuevos datos del cliente
      System.out.print("Identificación: ");
      String identificacion = System.console().readLine();
      System.out.print("Nombres: ");
      String nombres = System.console().readLine();
      System.out.print("Apellidos: ");
      String apellidos = System.console().readLine();

      cliente.setIdentificacion(identificacion);
      cliente.setNombres(nombres);
      cliente.setApellidos(apellidos);

      // Guardar en el archivo
      GestionCliente.guardarClientes();

    } catch (NumberFormatException error) {
      System.out.println("Error al convertir un número:\n" + error.getMessage());
    } catch (java.io.IOError error) {
      System.out.println("Error al capturar un dato:\n" + error.getMessage());
    }
    System.out.println();
  }
}
