package resources;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
//import java.net.URLDecoder;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.container.AsyncResponse;
import java.util.concurrent.TimeUnit;

@Path("query")
public class CmmdcResource {
   
  @GET
  public void processForm(@Suspended AsyncResponse response,
      @QueryParam("m") String sm,
      @QueryParam("n") String sn) {
    long m=Long.parseLong(sm);
    long n=Long.parseLong(sn);
    System.out.println(m+" : "+n);
    
    new Thread(()->{
      long c=cmmdc(m,n);
      String sc="Cmmdc : "+new Long(c).toString();
      response.resume(sc);
    }).start();
   
    response.setTimeout(5, TimeUnit.SECONDS); 
    //client will recieve a HTTP 408 (timeout error) after 10 seconds
    response.setTimeoutHandler((asyncResp) -> {
      asyncResp.resume(Response.status(Response.Status.REQUEST_TIMEOUT).build());
    });  
    /*
    new Thread(() -> {
      try {
          Thread.sleep(6000);
      } catch (InterruptedException ex) {
         //ignoring
      }
    }).start();
    */
  }
    
  private long cmmdc(long m,long n) {
    long c,r;
    do{
        c=n;
        r=m%n;
        m=n;
        n=r;
    }
    while(r!=0);
    /*
    try{
      Thread.sleep(10000);
    }
    catch(InterruptedException e){}
    */
    return c;
  }
} 