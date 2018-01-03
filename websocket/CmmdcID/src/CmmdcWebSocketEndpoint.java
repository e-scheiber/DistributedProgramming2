package websocket.cmmdc;
import javax.websocket.CloseReason;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.EncodeException;
import java.io.IOException;

public class CmmdcWebSocketEndpoint extends Endpoint {
  
  public void onOpen (Session session, EndpointConfig config) {
   final RemoteEndpoint.Basic remote = session.getBasicRemote();
   session.addMessageHandler (new MessageHandler.Whole<String>() {
      public void onMessage(String msg) {
        try {
                    
          String[] elem=msg.split(":");
          long m=Long.parseLong(elem[0]);
          long n=Long.parseLong(elem[1]);
          System.out.println(m+" : "+n);
          long r=cmmdc(m,n);
          remote.sendText(Long.valueOf(r).toString());          
        } 
        catch (Exception ioe) {
           // handle send failure here
        }
      }
   });
  }

  public void onClose(Session session, CloseReason closeReason) {
    System.out.println("Closing: " + closeReason.getReasonPhrase()); 
  }
  
  
  public void onError (Session session, Throwable throwable) {
    System.out.println("Error: " + throwable.getLocalizedMessage()); 
  }
  
  public long cmmdc(long m,long n){
    long r,c;
    do{
       c=n;
       r=m%n;
       m=n;
       n=r;
       }
    while(r!=0);
    return c;
  }  
}
