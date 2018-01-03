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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ByteArrayInputStream;


public class WebSocketClient extends Endpoint{
  private static boolean sfarsit=false;
  private static String SERVER = "ws://localhost:8080/AudioStreaming/audio";
  private static String fileName;
  
  public static void main(String[] args){
    Scanner scanner=new Scanner(System.in);
    System.out.println("Melodia de accesat:");
    System.out.println("1: Tom Jones");
    System.out.println("2: Katusha");
    int noFile=scanner.nextInt();
    if(noFile==1)
        fileName="TomJones.mp3";
      else
        fileName="Katusha.mp3"; 
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
  
  public void onOpen(Session session, EndpointConfig config){
    session.addMessageHandler(new MessageHandler.Whole<byte[]>() {
       public void onMessage(byte[] msg){
         //System.out.println(msg.length);
         try{
           InputStream in=new ByteArrayInputStream(msg);
           FileOutputStream fos=new FileOutputStream(fileName);
            
           int i;
           byte[] b=new byte[8192];
           while((i=in.read(b,0,b.length))!=-1) {
             fos.write(b,0,b.length);
             fos.flush();
           }  
           fos.close();
           FileInputStream fis=new FileInputStream(fileName);
           // De ce nu merge direct de pe inputstream?
           
           System.out.println("Play MP3");   
           MP3Player mp3Player=new MP3Player(fis);    
           mp3Player.start();                  
         }
         catch(IOException e){
           e.printStackTrace();
         }         
         sfarsit=true;
       }  
    });
  } 
}
