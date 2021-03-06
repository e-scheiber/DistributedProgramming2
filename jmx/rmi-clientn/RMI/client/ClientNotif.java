package client;
import javax.management.ObjectName;
import javax.management.MBeanInfo;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanConstructorInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanServerConnection;
import javax.management.remote.JMXServiceURL;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;

public class ClientNotif {
  public static void main(String[] args) {
    String host="localhost";
    String port="1099";
    //String port="1050";
    if(args.length<=1){
      System.out.println("The server and domain names are required");
      System.exit(0);
    }
    String serverName=args[0];
    String domain=args[1];
    if(args.length>=3)
      host=args[2];
    if(args.length>=4)
      port=args[3];
    ClientNotif obj=new ClientNotif();  
    try {
      // Crearea unui conector si a obiectului de tip MBeanServerConnection
      String surl="service:jmx:rmi:///jndi/rmi://"+host+":"+port+"/"+args[0];
      //String surl="service:jmx:iiop:///jndi/iiop://"+host+":"+port+"/"+args[0];
      JMXServiceURL url = new JMXServiceURL(surl);
      JMXConnector jmxc = JMXConnectorFactory.connect(url,null);
      MBeanServerConnection cs = jmxc.getMBeanServerConnection();
              
      System.out.println("DefaultDomain : " +domain);
      // Crearea unui MBean Intro
      String className="basicn.IntroN";
      String sObjectName=domain+":type="+className;
      ObjectName mbeanObjectName = new ObjectName(sObjectName); 
      
      MBeanInfo info=cs.getMBeanInfo(mbeanObjectName);
      getMBeanResources(info);
        
      // Utilizarea notificarii
      // Crearea unui ascultator
      ClientListener listener = new ClientListener();
      // Activarea notificatorului
      cs.addNotificationListener(mbeanObjectName, listener, null, obj);
      
      Thread.sleep(500);
      // Disponibilizarea ascultatorului de notificari
      System.out.println("Press Enter to finish !");
      try{
        System.in.read();
      }
      catch(java.io.IOException e){}
      cs.removeNotificationListener(mbeanObjectName, listener);      
      // Disponibilizarea obiectului MBeanObjectName
      cs.unregisterMBean(mbeanObjectName);     
    }
    catch(Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }
  
  private static void getMBeanResources(MBeanInfo info){
    System.out.println("CLASA: \t" + info.getClassName());
    System.out.println("DESCR: \t" + info.getDescription());
    System.out.println("ATTRIBUTE");
    MBeanAttributeInfo[] attrInfo = info.getAttributes();
    if (attrInfo.length > 0) {
      for (int i = 0; i < attrInfo.length; i++) {
        System.out.println("\tNUME: \t" + attrInfo[i].getName());
        System.out.println("\tDESC: \t" + attrInfo[i].getDescription());
        System.out.println("\tTIP: \t" + attrInfo[i].getType() +
         " READ: "+ attrInfo[i].isReadable() +
         " WRITE: "+ attrInfo[i].isWritable());
      }
    }
    else 
      System.out.println("\tFara atribute !");
    System.out.println("CONSTRUCTORI");
    MBeanConstructorInfo[] constrInfo = info.getConstructors();
    for (int i=0; i<constrInfo.length; i++) {
      System.out.println("\tNUME: \t" + constrInfo[i].getName());
      System.out.println("\tDESCR: \t" + constrInfo[i].getDescription());
      System.out.println("\tPARAM: \t" + constrInfo[i].getSignature().length +" parametri");
    }
    System.out.println("OPERATII");
    MBeanOperationInfo[] opInfo = info.getOperations();
    if (opInfo.length > 0) { 
      for (int i = 0; i < opInfo.length; i++) {
        System.out.println("\tNUME: \t" + opInfo[i].getName());
        System.out.println("\tDESCR: \t" + opInfo[i].getDescription());
        System.out.println("\tPARAM: \t" + opInfo[i].getSignature().length +" parametri");
      }
    }
    else 
      System.out.println("\tFara operatii");
    System.out.println("NOTIFICARI");
    MBeanNotificationInfo[] notifInfo = info.getNotifications();
    if (notifInfo.length > 0) {
      for (int i = 0; i < notifInfo.length; i++) {
        System.out.println("\tNUME: " + notifInfo[i].getName());
        System.out.println("\tDESCR: " + notifInfo[i].getDescription());
        String notifTypes[] = notifInfo[i].getNotifTypes();
        for (int j = 0; j < notifTypes.length; j++) {
          System.out.println("\tTIP: " + notifTypes[j]);
        }
      }
    }
    else
      System.out.println("\tFara notificari");
  } 
}
