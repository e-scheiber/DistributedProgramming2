package client;
import java.util.Scanner;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.Attribute;
import javax.management.MBeanServerInvocationHandler;
import javax.management.remote.JMXServiceURL;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;

public class Client {
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
    Scanner scanner=new Scanner(System.in);
    try {
      // Crearea unui conector RMI si a obiectului de tip MBeanServercsection
      String surl="service:jmx:rmi:///jndi/rmi://"+host+":"+port+"/"+serverName;
      //String surl="service:jmx:iiop:///jndi/iiop://"+host+":"+port+"/"+serverName; 
      JMXServiceURL url = new JMXServiceURL(surl);
      JMXConnector jmxc = JMXConnectorFactory.connect(url,null);
      MBeanServerConnection cs = jmxc.getMBeanServerConnection();
      
      // Domeniile agentului sunt
      System.out.println("Domains:"); 
      String domains[] = cs.getDomains();
      for (int i = 0; i < domains.length; i++) {
        System.out.println("\tDomain[" + i + "] = " + domains[i]);
      }            
            
      // iar domeniul implicit
      System.out.println("DefaultDomain : " +cs.getDefaultDomain());
      System.out.println("Domain : " +domain);
      
      // Crearea unui MBean Intro
      String className="basic.Intro";
      String sObjectName=domain+":type="+className;
      ObjectName mbeanObjectName = new ObjectName(sObjectName); 
      cs.createMBean(className,mbeanObjectName, null, null);
      
      double cursEuro;
      long m,n;
     /*
      // Utilizarea notificarii
      // Crearea unui ascultator
      ClientListener listener = new ClientListener();
      // Activarea notificatorului
      cs.addNotificationListener(mbeanObjectName, listener, null, null);
      Thread.sleep(2000);
      */
      
      // Utilizarea MBean-ului
      // Varianta 1 prin proxy
      System.out.println("Varianta prin proxi");
      IntroMBean proxy = (IntroMBean)MBeanServerInvocationHandler.newProxyInstance(
               cs,
               mbeanObjectName,
               client.IntroMBean.class,
               true);
 
      //Utilizarea operatiilor
      // operatia "sayHello"
      proxy.sayHello();
      
      // operatia cmmdc
      System.out.println("Cmmdc al numerelor:");     
      System.out.println("Primul numar:");
      m=scanner.nextLong();
      System.out.println("Al doilea numar:");
      n=scanner.nextLong(); 
      System.out.println("Cmmdc="+proxy.cmmdc(m,n));
    
      // Utilizarea atributelor
      System.out.println("Numele: "+proxy.getLabel());
      System.out.println("Introduceti cursul euro");
      cursEuro=scanner.nextDouble(); 
      proxy.setCursEuro(cursEuro);
      System.out.println("Euro : "+proxy.getCursEuro());
      
      // Varianta 2 prin conexiune
       System.out.println("Varianta prin conexiune");
      // Apelarea operatiilor
      String operatia="sayHello";
      cs.invoke(mbeanObjectName,operatia,null,null);
      operatia="cmmdc";
      System.out.println("Cmmdc al numerelor:");
      System.out.println("Primul numar:");
      m=scanner.nextLong();
      System.out.println("Al doilea numar:");
      n=scanner.nextLong();
      Object[] param={m,n}; 
      String[] sign={"long", "long"}; 
      Long r=(Long)cs.invoke(mbeanObjectName,operatia,param,sign);
      System.out.println("Cmmdc="+r.toString());
      
      // Utilizarea Atributelor
      String label=(String)cs.getAttribute(mbeanObjectName,"Label");
      System.out.println("Valoarea atributului label : "+label); 

      System.out.println("Introduceti cursul euro");
      cursEuro=scanner.nextDouble();
      Attribute curs=new Attribute("CursEuro", cursEuro); 
      cs.setAttribute(mbeanObjectName,curs);
      Double newEuro=(Double)cs.getAttribute(mbeanObjectName,"CursEuro");
      System.out.println("Valoarea atributului euro : "+newEuro);

      // Disponibilizarea ascultatorului de notificari
      //cs.removeNotificationListener(mbeanObjectName, listener);      
      // Disponibilizarea MBean-ului creat
      cs.unregisterMBean(mbeanObjectName);     
    }
    catch(Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }
}
