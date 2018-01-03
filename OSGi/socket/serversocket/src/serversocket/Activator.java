package serversocket;
import iserver.IMyMServer;
import server.impl.MyMServer;
import java.net.ServerSocket;
//import java.util.Scanner;

import org.osgi.framework.*;
public class Activator implements BundleActivator{
  public void start(BundleContext context){
    try{
      ServiceReference[] refs=context.getServiceReferences(IMyMServer.class.getName(),null);
      if(refs!=null){
        int port=7999;
        IMyMServer myMServer=(IMyMServer)context.getService(refs[0]);
        ServerSocket serverSocket=myMServer.getServerSocket(port);
        myMServer.myAction(serverSocket);
      }
    }
    catch(Exception e){
      System.out.println("Client Exception : "+e.getMessage());
    }
  }

  public void stop(BundleContext context) {}
}
