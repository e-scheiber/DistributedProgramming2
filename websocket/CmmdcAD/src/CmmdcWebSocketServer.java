package websocket.cmmdc;
import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;  
import javax.websocket.Session;
import javax.websocket.OnOpen;
import javax.websocket.OnClose;
import javax.websocket.EncodeException;
import java.io.IOException;
import java.util.Set;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Stream;
import javax.websocket.RemoteEndpoint;
import java.util.function.BiFunction;

@ServerEndpoint(value="/cmmdc")
  public class CmmdcWebSocketServer{
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
    
  private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
  
  @OnMessage
  public void myTask(String msg,Session session) throws IOException,EncodeException{
    String[] elem=msg.split(":");
    long m=Long.parseLong(elem[0]);
    long n=Long.parseLong(elem[1]);
    System.out.println(m+" : "+n);
    long r=CmmdcWebSocketServer.cmmdc(m,n);
    String rez=Long.valueOf(r).toString();
    //System.out.println(m+" : "+n+" : "+r);       
    Stream<Session> stream=sessions.stream();
    stream
      .filter(s->s.equals(session))
      .forEach(s->{
        RemoteEndpoint.Basic endpoint=s.getBasicRemote();
        try{
          endpoint.sendText(rez);
        }
        catch(IOException e){};
     });  
     /*
      .forEach(s->{
        Future<Void> future=s.getAsyncRemote().sendText(rez);
     });
     */
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
