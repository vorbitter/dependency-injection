package app.src.main.java;

public class SMSNotifier implements Notifier {

    @Override
    public void sendNotification(String message) {
        System.out.println("SMS diz: " + message);
    }
    
}
