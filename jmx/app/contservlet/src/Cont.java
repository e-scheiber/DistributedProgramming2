import javax.management.Notification;
import javax.management.AttributeChangeNotification;
import javax.management.NotificationBroadcasterSupport;
import javax.management.MBeanNotificationInfo; 

public class Cont extends NotificationBroadcasterSupport 
     implements ContMBean{
  private long sequenceNumber=1;
  private double cont;

  public synchronized double getCont() {
    return cont;
  }

  public synchronized void setCont(double cont) {
    double oldCont=this.cont;
    this.cont=cont;   
    Notification n=new AttributeChangeNotification(
      this,
      sequenceNumber++,
      System.currentTimeMillis(),
      "Schimbarea Cont",
      "cont",
      "double",
      oldCont,
      cont);
    sendNotification(n);
  }

  public MBeanNotificationInfo[] getNotificationInfo() { 
    String[] types = new String[] { 
      AttributeChangeNotification.ATTRIBUTE_CHANGE 
    }; 
    String name = AttributeChangeNotification.class.getName(); 
    String description = "An attribute of this MBean has changed"; 
    MBeanNotificationInfo info = 
      new MBeanNotificationInfo(types, name, description); 
    return new MBeanNotificationInfo[] {info}; 
  } 
}
