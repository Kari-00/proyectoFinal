import java.util.Date;

public class Gasto extends Transaccion {
    private Date fecha;


    public Gasto(String descripcion, double monto, Date fecha) {
        super(descripcion, monto);
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    @Override
    public double calcularMontoTotal() {
        return monto; // Los gastos no tienen cálculos adicionales, se retorna el monto directamente
    }
}
