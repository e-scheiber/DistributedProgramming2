package server;
//import java.io.IOException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.remote.JMXServiceURL;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;

public class MBServer{
  public static void main(String[] args) {
    String host="localhost";
    String port="1099";
    //String port="1050";
    if(args.length==0){
      System.out.println("The name of the server is required");
      System.exit(0);
    }
    if(args.length>=2)
      host=args[1];
    if(args.length>=3)
      port=args[2];
    try {
      // Crearea MBeanServer
      MBeanServer mbs = MBeanServerFactory.createMBeanServer();

      // Crearea unui RMI server-conector
      String surl="service:jmx:rmi:///jndi/rmi://"+host+":"+port+"/"+args[0];
      //String surl="service:jmx:iiop:///jndi/iiop://"+host+":"+port+"/"+args[0];
      JMXServiceURL url = new JMXServiceURL(surl);
      JMXConnectorServer cs =JMXConnectorServerFactory.newJMXConnectorServer(url,null,mbs);

      // Pornirea server-conectorului 
      cs.start();
      System.out.println("Press Enter to finish !");
      System.in.read();
      cs.stop();
    }
    catch (Exception e){
       System.out.println(e.getMessage());
       e.printStackTrace();
    }
  }
}
