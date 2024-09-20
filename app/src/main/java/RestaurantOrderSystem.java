package app.src.main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RestaurantOrderSystem {
    private List<Order> orders = new ArrayList<>();
    private Long orderNumber = 0l;

    public long placeOrder(PaymentProcessor payment, Notifier notifier) {
        var order = new Order(orderNumber, new ArrayList<>(), 100, payment, notifier);
        orderNumber++;
        orders.add(order);
        sendNotification(order.orderId, "Pedido criado com sucesso");

        return order.orderId;
    }

    public void cancelOrder(long orderId) {
        var order = findOrderById(orderId);

        if (order.isPresent()) {
            orders.remove(order.get());
            order.get().notifier.sendNotification("Pedido cancelado com sucesso");
        } else {
            System.out.println("Pedido não encontrado");
        }
    }

    public void deliverOrder(long orderId) {
        var order = findOrderById(orderId);

        if (order.isPresent()) {
            order.get().notifier.sendNotification("Pedido entregue com sucesso.");
            orders.remove(order.get());
        } else {
            System.out.println("Pedido não encontrado");
        }
    }

    private void sendNotification(long orderId, String message) {
        var order = findOrderById(orderId);      
        
        if (order.isPresent()) {
            order.get().notifier.sendNotification(message);
        } else {
            System.out.println("Pedido não encontrado");
        }
    }

    private Optional<Order> findOrderById(long orderId) {
        return orders.stream()
                .filter(o -> o.orderId == orderId)
                .findFirst();
    }
}