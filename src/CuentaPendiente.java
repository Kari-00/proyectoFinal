public class CuentaPendiente extends Transaccion {
    public CuentaPendiente(String descripcion, double monto) {
        super(descripcion, monto);
    }

    @Override
    public double calcularMontoTotal() {
        return monto; // Las cuentas pendientes solo devuelven el monto
    }
}
