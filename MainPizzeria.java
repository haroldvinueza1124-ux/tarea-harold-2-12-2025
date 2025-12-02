import java.util.ArrayList;
import java.util.List;

public class MainPizzeria {
    public static void main(String[] args) {

        List<Pedido> pedidos = new ArrayList<>();

        pedidos.add(new PedidoPizza(
                "Ana Torres",
                "Calle 123",
                8.50,
                true,
                "Grande",
                new String[]{"Pepperoni", "Queso extra"}
        ));

        pedidos.add(new PedidoHamburguesa(
                "Carlos Ruiz",
                "Av. Central 456",
                5.00,
                false,
                true,
                3
        ));

        // Demostración polimórfica
        for (Pedido p : pedidos) {
            p.mostrarDetallesEspeciales();
            p.mostrarResumenPedido();
            System.out.println("Total a pagar: $" + p.calcularCostoTotal());
            System.out.println("Tiempo estimado: " + p.estimarTiempoEntrega() + " min\n");
        }
    }
}









