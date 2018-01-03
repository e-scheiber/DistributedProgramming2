package websocket.cmmdc;
import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;  
import javax.websocket.Session;
import javax.websocket.OnOpen;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.RemoteEndpoint; 
import javax.websocket.EncodeException;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.Set;
import java.util.Collections;
import java.util.HashSet;
import java.util.function.BiFunction;

@ServerEndpoint(value="/cmmdc/{msg}")
public class CmmdcWebSocketServer{
  private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
  
  static public long cmmdc(long a,long b){
    BiFunction<Long,Long,Long> f=(m,n)->{ 
      long r,c;
      do{
        c=n;
        r=m % n;
        m=n;
        n=r;
      }
      while(r!=0);
      return Long.valueOf(c);
    };
    return f.apply(a,b).longValue();
  }  
    
  @OnMessage
  public void onMessage(String message,Session session){}
  
  @OnOpen
  public void onOpen(Session session, @PathParam("msg") String msg)
      throws IOException,EncodeException{
    sessions.add(session);
    String[] elem=msg.split(":");
    long m=Long.parseLong(elem[0]);
    long n=Long.parseLong(elem[1]);
    System.out.println(m+" : "+n);
    long r=CmmdcWebSocketServer.cmmdc(m,n);
    String rez="Cmmdc : "+Long.valueOf(r).toString(); 
    System.out.println(m+" : "+n+" : "+r);       
    /*
    for (Session peer : sessions) {
      if(peer.equals(session)){
        peer.getBasicRemote().sendText(new Long(r).toString());
      }
    }
    */
    sessions.stream()
      .filter(s->s.equals(session))
      .forEach(s->{
        RemoteEndpoint.Basic endpoint=s.getBasicRemote();
        try{
          endpoint.sendText(rez);
        }
        catch(IOException e){};
     });      
  }
     
  @OnClose
  public void onClose(Session session){
    sessions.remove(session);
  }
}
