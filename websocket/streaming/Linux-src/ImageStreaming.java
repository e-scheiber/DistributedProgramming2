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

@ServerEndpoint(value="/image")
public class ImageStreaming{
  private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
  
  @OnMessage
  public void myTask(String msg,Session session) 
      throws IOException,EncodeException{
    String fs=System.getProperty("file.separator");
    int noFile=Integer.parseInt(msg);
    String fileName="";
    switch(noFile){
    case 1:
      fileName="brasov.jpg";
      break;
    case 2:  
      fileName="xml-pic.jpg"; 
      break;
    }  
    // Tomcat
    String pathLinux="/home/mk/JavaApp/apache-tomcat-9.0.1/";
    String path="webapps"+fs+"ImageStreaming"+fs+"WEB-INF"+fs+"images"+fs;
    // Glassfish    
    //String path=".."+fs+"applications"+fs+"ImageStreaming"+fs+"WEB-INF"+fs+"images"+fs;
    System.out.println(path+fileName);
    
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
