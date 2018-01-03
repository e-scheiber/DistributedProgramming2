package agentn;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import javax.management.ObjectName;
import javax.management.MBeanServer;
import javax.management.Attribute;
import javax.management.MBeanInfo;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanConstructorInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanNotificationInfo;
import java.util.Scanner;

public class AgentN{
  public static void main(String[] args) {
    try {
      // Crearea Agentului - MBeanServer
      //MBeanServer mbs = MBeanServerFactory.createMBeanServer();
      MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
      
      // Crearea unui MBean
      String domain = mbs.getDefaultDomain();
      String className="agentn.IntroN";
      String sObjectName=domain+":type="+className;
      ObjectName mbeanObjectName = new ObjectName(sObjectName);
      mbs.createMBean(className,mbeanObjectName);

      // Investigarea resurselor unui MBean  
      MBeanInfo info=mbs.getMBeanInfo(mbeanObjectName);
      getMBeanResources(info);
      
      // Utilizarea MBean-ului
      
      // Apelarea operatiilor
      String operatia="sayHello";
      mbs.invoke(mbeanObjectName,operatia,null,null);
      
      operatia="cmmdc";
      System.out.println("Cmmdc al numerelor:");
      Scanner scanner=new Scanner(System.in);
      System.out.println("Primul numar:");
      long m=scanner.nextLong();
      System.out.println("Al doilea numar:");
      long n=scanner.nextLong();
      Object[] param={m,n}; 
      String[] sign={"long", "long"};
      Long r=(Long)mbs.invoke(mbeanObjectName,operatia,param,sign);
      System.out.println("cmmdc="+r.toString());

      // Utilizarea Atributelor
      String label=(String)mbs.getAttribute(mbeanObjectName,"Label");
      System.out.println("Valoarea atributului label : "+label);

      //Attribute curs=new Attribute("CursEuro", new Double(4));
      System.out.println("Introduceti cursul euro");
      double cursEuro=scanner.nextDouble();
      Attribute curs=new Attribute("CursEuro", cursEuro);
      mbs.setAttribute(mbeanObjectName,curs);
      Double euro=(Double)mbs.getAttribute(mbeanObjectName,"CursEuro");
      System.out.println("Valoarea atributului cursEuro : "+euro);
      System.out.println("Press Enter to finish");
      System.in.read();
    }
    catch (Exception e){
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
