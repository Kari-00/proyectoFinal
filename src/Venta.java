import java.util.Date;

public class Venta extends Transaccion {
    private int cantidad;
    private Date fecha;

    // Constructor de la clase
    public Venta(String producto, int cantidad, double precio, Date fecha) {
        super(producto, precio); // Llama al constructor de la clase base Transaccion
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    @Override
    public double calcularMontoTotal() {
        return cantidad * monto; // monto es el precio unitario de la transacción
    }
}
