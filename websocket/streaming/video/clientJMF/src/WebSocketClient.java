import java.io.IOException;
import java.net.URI;
import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;
import javax.websocket.Session;
import java.util.Scanner;

import javax.websocket.Endpoint; 
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;

import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JFrame;
import java.io.File;
import java.io.FileOutputStream;


public class WebSocketClient extends Endpoint{
  private static boolean sfarsit=false;
  private static String SERVER = "ws://localhost:8080/VideoStreaming/video";
  private static String fileName="";
  
  public static void main(String[] args){
    Scanner scanner=new Scanner(System.in);
    System.out.println("Fisierul de descarcat:");
    System.out.println("1: airhorse.avi");
    System.out.println("2: video1.avi");	
    int noFile=1;
    do{
      noFile=scanner.nextInt();
    }
    while(noFile!=1 && noFile!=2);  
    if(noFile==1) 
      fileName="airhorse.avi";
    else
      fileName="video1.avi";
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
        // save video file
        File file=new File(fileName);
        try {
          FileOutputStream stream = new FileOutputStream(file);
          stream.write(msg);
          stream.close();
        } 
        catch(IOException ex){
          System.out.println(ex);
        }
        // start video player
        String absolutePath=file.getAbsolutePath();
        System.out.println(absolutePath);
        URL mediaURL=null;          
        try {
          mediaURL = new URL("file://"+absolutePath);				
          System.out.println(mediaURL);
        } 
        catch (MalformedURLException e) {
          System.out.println(e);
        }
       
        JFrame mediaTest = new JFrame("Movie Player");
        mediaTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MediaPlayer mediaPanel = new MediaPlayer(mediaURL);
        mediaTest.add(mediaPanel);
        mediaTest.setSize(800, 700); // set the size of the player
        mediaTest.setLocationRelativeTo(null);
        mediaTest.setVisible(true);	
   
        sfarsit=true;
      }  
    });
  } 
}
