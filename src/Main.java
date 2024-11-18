import java.util.*;
import java.text.*;

public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        int opcion;
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar Venta");
            System.out.println("2. Agregar Gasto");
            System.out.println("3. Ver Producto Más y Menos Vendido");
            System.out.println("4. Ver Resumen Mensual");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea restante

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese producto: ");
                    String producto = scanner.nextLine();
                    System.out.print("Ingrese cantidad: ");
                    int cantidad = scanner.nextInt();
                    System.out.print("Ingrese precio: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine(); // Consumir la línea restante
                    System.out.print("Ingrese la fecha de la venta (formato dd/MM/yyyy): ");
                    String fechaVentaStr = scanner.nextLine();
                    try {
                        Date fechaVenta = sdf.parse(fechaVentaStr); // Convertir la cadena a Date
                        tienda.agregarVenta(new Venta(producto, cantidad, precio, fechaVenta));
                    } catch (ParseException e) {
                        System.out.println("Error en el formato de la fecha. Intente de nuevo.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese descripción del gasto: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Ingrese monto: ");
                    double monto = scanner.nextDouble();
                    scanner.nextLine(); // Consumir la línea restante
                    System.out.print("Ingrese la fecha del gasto (formato dd/MM/yyyy): ");
                    String fechaGastoStr = scanner.nextLine();
                    try {
                        Date fechaGasto = sdf.parse(fechaGastoStr); // Convertir la cadena a Date
                        tienda.agregarGasto(new Gasto(descripcion, monto, fechaGasto));
                    } catch (ParseException e) {
                        System.out.println("Error en el formato de la fecha. Intente de nuevo.");
                    }
                    break;
                case 3:
                    tienda.mostrarProductoMasYMenosVendido();
                    break;
                case 4:
                    System.out.print("Ingrese mes (1-12): ");
                    int mes = scanner.nextInt();
                    System.out.print("Ingrese año: ");
                    int año = scanner.nextInt();
                    tienda.mostrarResumenMensual(mes, año);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
