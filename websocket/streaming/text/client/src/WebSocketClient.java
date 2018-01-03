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
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

public class WebSocketClient extends Endpoint{
  private static boolean sfarsit=false;
  private static String SERVER = "ws://localhost:8080/TextStreaming/text";
  
  public static void main(String[] args){
    Scanner scanner=new Scanner(System.in);
    System.out.println("Fisierul de accesat:");
    System.out.println("1: capitol.txt");
    System.out.println("2: junit.tex");
    int noFile=scanner.nextInt();
    String data=Integer.valueOf(noFile).toString();
    WebSocketContainer container = ContainerProvider.getWebSocketContainer();
    
    try {
      Session session=container.connectToServer(WebSocketClient.class, null, new URI(SERVER));
      session.getBasicRemote().sendText(data); 
      while(! sfarsit){;};
    } 
    catch(Exception ex){
       System.out.println("LocalEndPoint Exception : "+ex.getMessage());
    } 
  }
  
  // Varianta 1
  /*
  public void onOpen(Session session, EndpointConfig config){
    session.addMessageHandler(new MessageHandler.Whole<byte[]>() {
       public void onMessage(byte[] msg){
         //System.out.println(msg.length);
         System.out.println(new String(msg));
         try(InputStream is=new ByteArrayInputStream(msg);
             DataInputStream in = new DataInputStream(is)){
            
           String s;
           while(!(s=in.readUTF()).equals("endOFfile"))System.out.println(s);        
         }
         catch(IOException e){
           e.printStackTrace();
         }         
         sfarsit=true;
       }  
    });
  } 
  */
  
  //Varianta 2
  public void onOpen(Session session, EndpointConfig config){
    session.addMessageHandler(new MessageHandler.Whole<byte[]>() {
       public void onMessage(byte[] msg){
         System.out.println(new String(msg));               
         sfarsit=true;
       }  
    });
  }
}
