public abstract class Transaccion implements Calculable {
    protected String descripcion;
    protected double monto;


    public Transaccion(String descripcion, double monto) {
        this.descripcion = descripcion;
        this.monto = monto;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public double getMonto() {
        return monto;
    }

    @Override
    public abstract double calcularMontoTotal();
}
