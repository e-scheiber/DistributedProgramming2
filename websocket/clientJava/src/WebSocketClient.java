import java.io.IOException;
import java.net.URI;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;
import javax.websocket.Session;
import java.util.Scanner;

import javax.websocket.Endpoint; 
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;

public class WebSocketClient extends Endpoint{
  private static boolean sfarsit=false;
  private static String SERVER = "ws://localhost:8080/CmmdcWebSocketAD/cmmdc";
  //private static String SERVER = "ws://localhost:8080/CmmdcWebSocketParam/cmmdc";
  static long mom0;
  
  public static void main(String[] args){
    Scanner scanner=new Scanner(System.in);
    System.out.println("m=");
    long m=scanner.nextLong();
    String sm=Long.valueOf(m).toString();
    System.out.println("n=");
    long n=scanner.nextLong();
    String sn=Long.valueOf(n).toString();
    String data=sm+":"+sn;
    WebSocketContainer container = ContainerProvider.getWebSocketContainer();
    try {  
      Session session=container.connectToServer(WebSocketClient.class, null, new URI(SERVER));
      //Session session=container.connectToServer(WebSocketClient.class, null, URI.create(SERVER+"/"+data));
      mom0=System.currentTimeMillis();
      session.getBasicRemote().sendText(data); 
      while(! sfarsit){System.out.print("");};
      // De ce nu functioneaza ?
      // 1.
      // while(!sfarsit){;};
      // 2.
      // long i=0;while(!sfarsit){i++;};
      session.close();
    } 
    catch(Exception ex){
       System.out.println("LocalEndPoint Exception : "+ex.getMessage());
    } 
  }
  
  public void onOpen(Session session, EndpointConfig config) {
    session.addMessageHandler(new MessageHandler.Whole<String>() {
       public void onMessage(String text){
         long d=System.currentTimeMillis()-mom0;
         System.out.println("Durata : "+d);
         System.out.println("Cmmdc : "+text);
         sfarsit=true;
       }  
    });
  }
  
}
