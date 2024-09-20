package app.src.main.java;

public class EmailNotifier implements Notifier{

    @Override
    public void sendNotification(String message) {
        System.out.println("Email diz: " + message);
    }
    
}
