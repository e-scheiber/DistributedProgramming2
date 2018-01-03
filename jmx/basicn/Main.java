package basicn;
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
      ObjectName mbeanObjectName = new ObjectName(domeniu+":type=IntroN,index=1");

      // Crearea MBean-ului
      IntroN mbean = new IntroN();

      // Inregistrarea MBean-ului
      mbs.registerMBean(mbean, mbeanObjectName);
  
  //Varianta 2 

      mbeanObjectName=new ObjectName(domeniu+":type=IntroN,index=2");
      mbs.createMBean("basicn.IntroN",mbeanObjectName);
      
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
