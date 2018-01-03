import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;  
import javax.websocket.Session;
import javax.websocket.OnOpen;
import javax.websocket.OnClose;
import javax.websocket.EncodeException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;
import java.util.Collections;
import java.util.HashSet;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

@ServerEndpoint(value="/video")
public class VideoStreaming{
  private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
  
  @OnMessage
  public void myTask(String msg,Session session) 
      throws IOException,EncodeException{
    String fs=System.getProperty("file.separator");
    int noFile=Integer.parseInt(msg);
    String fileName="";
    switch(noFile){
    case 1:
      fileName="airhorse.avi"; 	  
      break;
    case 2:  
      fileName="video1.avi"; 	  
      break;	
    }    
    // Tomcat
    String pathLinux="/home/mk/JavaApp/apache-tomcat-9.0.1/";
    String path="webapps"+fs+"VideoStreaming"+fs+"WEB-INF"+fs+"videos"+fs;
    // Glassfish 
    //String path=".."+fs+"applications"+fs+"VideoStreaming"+fs+"WEB-INF"+fs+"videos"+fs;
    //System.out.println(path+fileName);
    Path cale=Paths.get(pathLinux+path+fileName);
    for (Session peer : sessions) {
      if(peer.equals(session)){
        OutputStream out=peer.getBasicRemote().getSendStream();			
		    Files.copy(cale,out);        
        out.close();
      }
    }              
  }
  
  @OnOpen
  public void onOpen(Session session){
    sessions.add(session);
  }
     
  @OnClose
  public void onClose(Session session){
    sessions.remove(session);
  }
}
