package tienda;

public class GestionProducto {

  public static void verMenu() {
    int menuSeleccionado = 0;
    do {
      System.out.println("++++++ Administración de Tienda ++++++");
      System.out.println("***** Menú Productos *****");
      String menu = """
          1. Crear Producto
          2. Editar Producto
          3. Ver Productos
          9. Regresar
          """;
      System.out.println(menu);

      try {
        System.out.print("Selecciona un menú: ");
        menuSeleccionado = Integer.parseInt(System.console().readLine());

        switch (menuSeleccionado) {
          case 1:
            crearProducto();
            break;
          case 2:
            // editar cliente
            break;
          case 3:
            verProductos();
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

  public static void crearProducto() {
    try {
      System.out.print("Código: ");
      String codigo = System.console().readLine();
      System.out.print("Nombre: ");
      String nombre = System.console().readLine();
      System.out.print("Precio sin IVA: ");
      double precio = Double.parseDouble(System.console().readLine());
      System.out.print("Porcentaje de IVA: ");
      double porcentajeIva = Double.parseDouble(System.console().readLine());
      System.out.print("Cantidad en Inventario: ");
      int cantidadInventario = Integer.parseInt(System.console().readLine());

      Producto producto = new Producto(codigo, nombre, precio, porcentajeIva, cantidadInventario);

      producto.guardar();

    } catch (NumberFormatException error) {
      System.out.println("Error al convertir un número:\n" + error.getMessage());
    } catch (java.io.IOError error) {
      System.out.println("Error al capturar un dato:\n" + error.getMessage());
    }
    System.out.println();
  }

  public static void guardarProductos() {
    Producto.guardarProductos();
  }

  public static void leerProductos() {
    Producto.leerProductos();
  }

  public static void verProductos() {
    Producto.verProductos();
  }

}
