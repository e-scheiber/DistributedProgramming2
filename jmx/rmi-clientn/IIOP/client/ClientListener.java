package client;
import javax.management.Notification;
import javax.management.NotificationListener;
import javax.management.AttributeChangeNotification;

public class ClientListener implements NotificationListener {
    public void handleNotification(Notification notification, Object handback) {
      System.out.println("\nReceived notification: " + notification);
      AttributeChangeNotification myNotif=(AttributeChangeNotification)notification;
      System.out.println("Curs initial : "+myNotif.getOldValue().toString());
      System.out.println("Curs curent  : "+myNotif.getNewValue().toString());
    }
}
