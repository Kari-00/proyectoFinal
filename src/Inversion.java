public class Inversion extends Transaccion {
    public Inversion(String tipo, double monto) {
        super(tipo, monto);
    }

    @Override
    public double calcularMontoTotal() {
        return monto; // Las inversiones también devuelven el monto como total
    }
}
