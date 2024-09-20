package app.src.main.java;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public Long orderId;
    public List<?> items = new ArrayList<>();
    public double totalAmount;
    public PaymentProcessor payment;
    public Notifier notifier;

    public Order(Long orderId, List<?> items, double totalAmount, PaymentProcessor payment, Notifier notifier) {
        this.orderId = orderId;
        this.items = items;
        this.totalAmount = totalAmount;
        this.payment = payment;
        this.notifier = notifier;
    }

    public Order(PaymentProcessor _payment, Notifier _notifier){
        notifier = _notifier;
        payment = _payment;
    }
}
