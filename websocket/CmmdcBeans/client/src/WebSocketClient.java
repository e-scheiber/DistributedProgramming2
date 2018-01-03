import java.net.URI;
//import java.io.IOException;
import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;
import javax.websocket.Session;
import java.util.Scanner;
import javax.websocket.Endpoint; 
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
//import javax.websocket.OnClose;
//import javax.websocket.OnOpen;
//import javax.websocket.CloseReason;

public class WebSocketClient extends Endpoint{
  private static boolean sfarsit=false;
  
  public static void main(String[] args){
    Scanner scanner=new Scanner(System.in);
    System.out.println("m=");
    long m=scanner.nextLong();
    System.out.println("n=");
    long n=scanner.nextLong();
    CmmdcBean obj=new CmmdcBean();
    obj.setM(m);
    obj.setN(n); 
    int tip=1;
    String server="";
    do{
      System.out.println("Encoder Type");
      System.out.println("1: JSON");
      System.out.println("2: XML");
      tip=scanner.nextInt();
    }  
    while((tip!=1) &&  (tip!=2));
    
    WebSocketContainer container = ContainerProvider.getWebSocketContainer(); 
    String request=null;
    try {
      if(tip==1){
        server="ws://localhost:8080/JsonCmmdcWebSocket/cmmdc";
        CmmdcBeanJSONEncoder encoderJSON=new CmmdcBeanJSONEncoder();
        request=encoderJSON.encode(obj); 
      }
      else{
        server="ws://localhost:8080/XmlCmmdcWebSocket/cmmdc";
        CmmdcBeanXMLEncoder encoderXML=new CmmdcBeanXMLEncoder();
        request=encoderXML.encode(obj);
      }  
      System.out.println(request);
      Session session=
        container.connectToServer(WebSocketClient.class, null, 
          new URI(server));
      session.getBasicRemote().sendText(request); 
      //session.getBasicRemote().sendObject(obj);
      while(! sfarsit){;};
    } 
    catch(Exception ex){
       System.out.println("LocalEndPoint Exception : "+ex.getMessage());
    } 
  }
  
  //@OnOpen
  public void onOpen(Session session, EndpointConfig config) {
    session.addMessageHandler(new MessageHandler.Whole<String>() {
       public void onMessage(String text){
         System.out.println("Cmmdc : "+text);
         sfarsit=true;
         System.exit(0);
       }  
    });
  }
  
  /*
  @OnClose
  public void onClose(Session session, CloseReason reason){// throws IOException {
    try{
      session.close(reason);
    }
    catch(IOException e){
      e.printStackTrace();
    }
  }
  */
}
