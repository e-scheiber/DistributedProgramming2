package basic;
import java.lang.management.ManagementFactory;
import javax.management.ObjectName;
import javax.management.MBeanServer;

public class Main{
  public static void main(String[] args){
    String domeniu="";
    if(args.length>0)
      domeniu=args[0];
    try{
      
      // Serverul platformei
      MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
      
  //Varianta 1
      // Construirea ObjectName corespunzator MBean-ului
      ObjectName mbeanObjectName = new ObjectName(domeniu+":type=Intro,index=1");

      // Crearea MBean-ului
      Intro mbean = new Intro();

      // Inregistrarea MBean-ului
      mbs.registerMBean(mbean, mbeanObjectName);
  
  //Varianta 2 

      mbeanObjectName=new ObjectName(domeniu+":type=Intro,index=2");
      mbs.createMBean("basic.Intro",mbeanObjectName);
      
      /*
      MBeanServer mbs0 = MBeanServerFactory.createMBeanServer();
      String domain=mbs0.getDefaultDomain();
      System.out.println(domain);
      ObjectName mbeanObjectName0 = new ObjectName("basic:type=Intro,index=2");
      mbs0.createMBean("basic.Intro", mbeanObjectName);
      */

      // Asteptare nedefinita
      System.out.println("Waiting forever...");
      while(true);
    }
    catch(Exception e){
      System.err.println("Exception : "+e.getMessage());
      e.printStackTrace();
    }
  }
}
