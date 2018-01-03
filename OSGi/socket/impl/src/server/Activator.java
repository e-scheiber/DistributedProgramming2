package server;
//import java.util.Properties;
import server.impl.MyMServer;
import iserver.IMyMServer;
import org.osgi.framework.*;

public class Activator implements BundleActivator{
  public void start(BundleContext context){
    context.registerService(IMyMServer.class.getName(),new MyMServer(),null);
    System.out.println("Registering Socket service.");
  }

  public void stop(BundleContext context) {}
}
