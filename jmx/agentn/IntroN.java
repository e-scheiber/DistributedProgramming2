package agentn;
import javax.management.Notification;
import javax.management.AttributeChangeNotification;
import javax.management.NotificationBroadcasterSupport;
import javax.management.MBeanNotificationInfo;

public class IntroN extends NotificationBroadcasterSupport 
     implements IntroNMBean{
  private long sequenceNumber=1;

  //Atribute
  private final String label = "Fac. Matematica si Informatica";
  private double cursEuro = 4.50;
  
  public String getLabel() {
    return label;
  }

  public double getCursEuro() {
    return cursEuro;
  }

  public synchronized void setCursEuro(double cursEuro) {
    double oldCursEuro=this.cursEuro;
    this.cursEuro = cursEuro;
    //System.out.println("Curs de schimb euro : " + euro+" ron.");
    Notification n=new AttributeChangeNotification(
      this,
      sequenceNumber++,
      System.currentTimeMillis(),
      "Schimbarea cursului Euro",
      "cursEuro",
      "double",
      oldCursEuro,
      cursEuro);
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
  
  // Operatii
  public String sayHello() {
    String message="Hello World !";
    System.out.println(message);
    return message;
  } 
  
  public long cmmdc(long m,long n){
    long r,c;
    do{
      c=n;
      r=m%n;
      m=n;
      n=r;
    }
    while(r!=0);
    return c;
  }  
}
