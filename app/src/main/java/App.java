package app.src.main.java;

public class App {
    public static void main(String[] args) {
        RestaurantOrderSystem system = new RestaurantOrderSystem();
        var orderId = system.placeOrder(new BitcoinProcessor(), new EmailNotifier());
        var orderId2 = system.placeOrder(new CreditPayment(), new SMSNotifier());
        
        system.deliverOrder(orderId);
        system.cancelOrder(orderId2);
        system.deliverOrder(orderId2);//pedido não encontrado
    }
}
