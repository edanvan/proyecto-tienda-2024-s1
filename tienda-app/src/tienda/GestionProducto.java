package tienda;

public class GestionProducto {

  public static void verMenu() {
    GestionProducto.leerProductos();

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
            editarProducto();
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
      GestionProducto.guardarProductos();

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

  public static void editarProducto() {
    System.out.println("++++++ Administración de Tienda ++++++");
    System.out.println("***** Editar Producto *****");

    try {
      System.out.print("Código: ");
      String codigoProducto = System.console().readLine().trim();

      // buscar si el producto existe
      Producto producto = Producto.buscarProducto(codigoProducto);

      if (producto == null) {
        System.out.printf("Error: no existe un producto con código: %s%n", codigoProducto);
        return;
      }

      // El producto sí existe, mostrar los datos del producto
      String formatoEncabezado = "| %-10s | %-30s | %-10s | %-8s | %-10s | %-10s |%n";
      System.out.printf(formatoEncabezado, "CÓDIGO", "NOMBRE", "PRECIO BASE", "IVA (%)", "PRECIO FINAL",
          "INVENTARIO");

      String formatoFilas = "| %-10s | %-30s | %,11.2f | %,8.2f | %,12.2f | %10d |%n";
      System.out.println("=".repeat(100));

      System.out.printf(formatoFilas, producto.getCodigo(), producto.getNombre(), producto.getPrecio(),
          producto.getPorcentajeIva(), producto.getPrecio() * (1 + (producto.getPorcentajeIva() / 100.0d)),
          producto.getCantidadInventario());

      System.out.println("-".repeat(100));

      // Ahora se pide los datos nuevos del producto
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

      producto.setCodigo(codigo);
      producto.setNombre(nombre);
      producto.setPrecio(precio);
      producto.setPorcentajeIva(porcentajeIva);
      producto.setCantidadInventario(cantidadInventario);

      GestionProducto.guardarProductos();

    } catch (NumberFormatException error) {
      System.out.println("Error al convertir un número:\n" + error.getMessage());
    } catch (java.io.IOError error) {
      System.out.println("Error al capturar un dato:\n" + error.getMessage());
    }
    System.out.println();
  }
}