package agent;
import java.io.IOException;
import javax.management.ObjectName;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.Attribute;
import java.util.Scanner;

public class Agent{
  public static void main(String[] args) {
    try {
      // Crearea Agentului - MBeanServer
      MBeanServer mbs = MBeanServerFactory.createMBeanServer();
      
      // Crearea unui MBean
      String domain = mbs.getDefaultDomain();
      String className="agent.Intro";
      String sObjectName=domain+":type="+className;
      ObjectName mbeanObjectName = new ObjectName(sObjectName);
      mbs.createMBean(className,mbeanObjectName);

      // Investigarea resurselor unui MBean  
      // MBeanInfo info=mbs.getMBeanInfo(mbeanObjectName);
      
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
    }
    catch (Exception e){
       System.out.println(e.getMessage());
       e.printStackTrace();
    }
  }
}
