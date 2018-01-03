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

// Varianta 1
/*
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.DataOutputStream;
*/
// Varianta 2
import java.nio.file.Path;
import java.nio.file.Files;

@ServerEndpoint(value="/text")
public class TextStreaming{
  private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
  
  @OnMessage
  public void myTask(String msg,Session session) 
      throws IOException,EncodeException{  
    String fs=System.getProperty("file.separator");
    String pathServer=new java.io.File(".").getCanonicalPath();
    System.out.println(pathServer);
    int x=pathServer.indexOf("glassfish");
    String path="";
    String path0=fs+"TextStreaming"+
        fs+"WEB-INF"+fs+"text"+fs;
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
    String fileName="";
    switch(noFile){
    case 1: 
        fileName="capitol.txt";
        break;
    case 2:    
        fileName="junit.tex";
        break;
    }     
    System.out.println(path+fileName);
    // Varianta 1
    /*
    File inputFile=new File(path+fileName);
    FileReader fr=new FileReader(inputFile);
    BufferedReader br= new BufferedReader(fr);
    for (Session peer : sessions) {
      if(peer.equals(session)){
        OutputStream out=peer.getBasicRemote().getSendStream();
        DataOutputStream dos=new DataOutputStream(out);
        String s; 
        while((s=br.readLine())!=null) dos.writeUTF(s);   
        dos.writeUTF("endOFfile");      
        dos.flush();
        br.close();
        fr.close();
        dos.close();       
      }
    }  
    */    
  
    // Varianta 2
    Path cale=Paths.get(path+fileName);
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
