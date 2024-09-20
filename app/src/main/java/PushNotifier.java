package app.src.main.java;

public class PushNotifier implements Notifier {

    @Override
    public void sendNotification(String message) {
        System.out.println("Notificação de push diz: " + message);
    }
    
}
