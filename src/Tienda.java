import java.util.*;

public class Tienda {
    private List<Venta> ventas = new ArrayList<>();
    private List<Gasto> gastos = new ArrayList<>();
    private List<CuentaPendiente> cuentasPendientes = new ArrayList<>();
    private List<Inversion> inversiones = new ArrayList<>();

    public void agregarVenta(Venta venta) {
        ventas.add(venta);
    }

    public void agregarGasto(Gasto gasto) {
        gastos.add(gasto);
    }

    public void agregarCuentaPendiente(CuentaPendiente cuentaPendiente) {
        cuentasPendientes.add(cuentaPendiente);
    }

    public void agregarInversion(Inversion inversion) {
        inversiones.add(inversion);
    }

    public Venta obtenerProductoMasVendido() {
        Venta masVendido = null;
        int maxCantidad = 0;

        for (Venta venta : ventas) {
            if (venta.getCantidad() > maxCantidad) {
                maxCantidad = venta.getCantidad();
                masVendido = venta;
            }
        }
        return masVendido;
    }

    public Venta obtenerProductoMenosVendido() {
        Venta menosVendido = null;
        int minCantidad = Integer.MAX_VALUE;

        for (Venta venta : ventas) {
            if (venta.getCantidad() < minCantidad) {
                minCantidad = venta.getCantidad();
                menosVendido = venta;
            }
        }
        return menosVendido;
    }

    public double calcularTotalVentas(int mes, int año) {
        double totalVentas = 0.0;

        for (Venta venta : ventas) {
            if (esDelMesYAño(venta.getFecha(), mes, año)) {
                totalVentas += venta.calcularMontoTotal();
            }
        }
        return totalVentas;
    }

    public double calcularTotalGastos(int mes, int año) {
        double totalGastos = 0.0;

        for (Gasto gasto : gastos) {
            if (esDelMesYAño(gasto.getFecha(), mes, año)) {
                totalGastos += gasto.calcularMontoTotal();
            }
        }
        return totalGastos;
    }

    public double calcularGanancias(int mes, int año) {
        return calcularTotalVentas(mes, año) - calcularTotalGastos(mes, año);
    }

    private boolean esDelMesYAño(Date fecha, int mes, int año) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        return cal.get(Calendar.MONTH) + 1 == mes && cal.get(Calendar.YEAR) == año;
    }

    public void mostrarResumenMensual(int mes, int año) {
        System.out.println("Resumen para el mes " + mes + " del año " + año + ":");
        System.out.println("Total Ventas: " + calcularTotalVentas(mes, año));
        System.out.println("Total Gastos: " + calcularTotalGastos(mes, año));
        System.out.println("Ganancias: " + calcularGanancias(mes, año));
    }

    public void mostrarProductoMasYMenosVendido() {
        Venta masVendido = obtenerProductoMasVendido();
        Venta menosVendido = obtenerProductoMenosVendido();

        // Mostrar detalles del producto más vendido
        if (masVendido != null) {
            System.out.println("Producto más vendido: " + masVendido.getDescripcion());
            System.out.println("Cantidad vendida: " + masVendido.getCantidad());
            System.out.println("Monto total: " + masVendido.calcularMontoTotal());
        } else {
            System.out.println("Producto más vendido: N/A (no hay ventas registradas)");
        }

        // Mostrar detalles del producto menos vendido
        if (menosVendido != null) {
            System.out.println("Producto menos vendido: " + menosVendido.getDescripcion());
            System.out.println("Cantidad vendida: " + menosVendido.getCantidad());
            System.out.println("Monto total: " + menosVendido.calcularMontoTotal());
        } else {
            System.out.println("Producto menos vendido: N/A (no hay ventas registradas)");
        }
    }
}
