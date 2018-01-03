import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;  
import javax.websocket.Session;
import javax.websocket.OnOpen;
import javax.websocket.OnClose;
import javax.websocket.EncodeException;
import java.io.IOException;
import java.io.OutputStream;
//import java.io.FileInputStream;
//import java.io.InputStream;
import java.util.Set;
import java.util.Collections;
import java.util.HashSet;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

@ServerEndpoint(value="/audio")
public class AudioStreaming{
  private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
  
  @OnMessage
  public void myTask(String msg,Session session) 
      throws IOException,EncodeException{
    String fs=System.getProperty("file.separator");
    String pathServer=new java.io.File(".").getCanonicalPath();
    int x=pathServer.indexOf("glassfish");
    String path="";
    String path0=fs+"AudioStreaming"+
        fs+"WEB-INF"+fs+"audio"+fs;
    if(x==-1){
      // apache-tomcat
      path=pathServer+fs+"webapps"+path0;
    }  
    else{
      // glassfish
      x=pathServer.lastIndexOf(fs);
      String pathGlassfish=pathServer.substring(0,x);
      path=pathGlassfish+fs+"applications"+path0;
    }     
    int noFile=Integer.parseInt(msg);
    String fileName;
    if(noFile==1)
        fileName="TomJones.mp3";
      else
        fileName="Katusha.mp3"; 
    System.out.println(path+fileName);
    Path cale=Paths.get(path+fileName);
    //InputStream fis=new FileInputStream(path+fileName);  
    for (Session peer : sessions) {
      if(peer.equals(session)){
        OutputStream out=peer.getBasicRemote().getSendStream();
        /*
        int s; 
        byte[] b=new byte[8192];
        while((s=fis.read(b,0,b.length))!=-1){
          out.write(b,0,b.length);   
          out.flush();
        } 
        */ 
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
