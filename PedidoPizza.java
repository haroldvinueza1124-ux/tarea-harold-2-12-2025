import java.util.Arrays;

public class PedidoPizza extends Pedido implements OperacionesPedido {

    private String tamanio;
    private String[] ingredientesExtras;
    private final double costoDelivery = 3.50;

    public PedidoPizza(String cliente, String direccion, double precioBase, boolean delivery,
                       String tamanio, String[] ingredientesExtras) {

        super(cliente, direccion, precioBase, TipoComida.PIZZA, delivery);
        this.tamanio = tamanio;
        this.ingredientesExtras = ingredientesExtras;
    }

    @Override
    public double calcularCostoTotal() {
        double costo = getPrecioBase();
        costo += ingredientesExtras.length * 0.80; // Extra por cada ingrediente
        if (isDelivery()) costo += costoDelivery;
        return costo;
    }

    @Override
    public void mostrarResumenPedido() {
        System.out.println("----- RESUMEN PEDIDO PIZZA -----");
        System.out.println("Cliente: " + getCliente());
        System.out.println("Dirección: " + getDireccion());
        System.out.println("Tamaño: " + tamanio);
        System.out.println("Ingredientes extra: " + Arrays.toString(ingredientesExtras));
        System.out.println("Delivery: " + (isDelivery() ? "Sí" : "No"));
    }

    @Override
    public int estimarTiempoEntrega() {
        int tiempo = 25;
        if (isDelivery()) tiempo += 10;
        return tiempo;
    }

    @Override
    public void mostrarDetallesEspeciales() {
        System.out.println("Pizza tamaño " + tamanio + " con extras " + Arrays.toString(ingredientesExtras));
    }
}
