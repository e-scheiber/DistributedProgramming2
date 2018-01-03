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

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.awt.Image;

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
    System.out.println("2: video1");	
    int noFile;
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
        // Salvarea fisierului video
        File file=new File(fileName);
        try{
          FileOutputStream stream = new FileOutputStream(file);
          stream.write(msg);
          stream.close();
        } 
        catch(IOException ex){
          System.out.println(ex);
        }
        String absolutePath=file.getAbsolutePath();
        // Fixarea cai catre WMP (Windows Media Player)
        String windowsMediaPlayerPath = 
          "\"C://Program Files (x86)/Windows Media Player/wmplayer.exe\" ";
        // Fixarea parametrilor WMP
        String wmpParam = windowsMediaPlayerPath + absolutePath;
        
        Process runningProcess = null;			    
        try{	
          runningProcess = Runtime.getRuntime().exec(wmpParam);							
        }
        catch(Exception ex){
          System.out.println(ex);
        }						
        try {
          while(true){					
            // Se asteapta terminarea procesului WMP
            int i = runningProcess.waitFor();
            if (i==0){
              runningProcess.destroy();
              break;
            }
          }
        }
        catch(InterruptedException e) {
          System.out.println(e);
        }	
        sfarsit=true;
        System.out.println(sfarsit);
        Runtime.getRuntime().exit(0);
      }  
    });
  } 
}
