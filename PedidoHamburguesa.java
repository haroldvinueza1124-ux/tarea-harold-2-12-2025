public class PedidoHamburguesa extends Pedido implements OperacionesPedido {

    private boolean comboCompleto;
    private int nivelPicante;
    private final double costoDelivery = 2.80;

    public PedidoHamburguesa(String cliente, String direccion, double precioBase, boolean delivery,
                             boolean comboCompleto, int nivelPicante) {

        super(cliente, direccion, precioBase, TipoComida.HAMBURGUESA, delivery);

        this.comboCompleto = comboCompleto;
        this.nivelPicante = nivelPicante;
    }

    @Override
    public double calcularCostoTotal() {
        double costo = getPrecioBase();
        if (comboCompleto) costo += 2.50;
        costo += nivelPicante * 0.30;
        if (isDelivery()) costo += costoDelivery;
        return costo;
    }

    @Override
    public void mostrarResumenPedido() {
        System.out.println("----- RESUMEN PEDIDO HAMBURGUESA -----");
        System.out.println("Cliente: " + getCliente());
        System.out.println("Dirección: " + getDireccion());
        System.out.println("Combo completo: " + (comboCompleto ? "Sí" : "No"));
        System.out.println("Nivel picante: " + nivelPicante);
        System.out.println("Delivery: " + (isDelivery() ? "Sí" : "No"));
    }

    @Override
    public int estimarTiempoEntrega() {
        int tiempo = 15;
        if (isDelivery()) tiempo += 10;
        return tiempo;
    }

    @Override
    public void mostrarDetallesEspeciales() {
        System.out.println("Hamburguesa (combo: " + comboCompleto + ", picante: " + nivelPicante + ")");
    }
}
