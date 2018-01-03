package resources;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.container.AsyncResponse;
import java.util.concurrent.TimeUnit;

@Path("async")
public class HelloResource {
   
  @GET
  public void processForm(@Suspended AsyncResponse response,
      @QueryParam("nume") String nume,
      @QueryParam("tip") String tip) {
    
    new Thread(()->{  
      Response r=null; 
      String s;      
      switch(tip){
      case "text/plain": 
        s="Hello "+nume+" !";
        r=Response.ok(s,"text/plain").build(); 
        break;
      case "text/html":
        s="<html><head></head><body bgcolor=\"#aaeeaa\"><center><h1>Hello "+nume+" ! </h1></center></body></html>";
        r=Response.ok(s,"text/html").build();
        break;
      } 
      response.resume(r);
    }).start();
   
    response.setTimeout(5, TimeUnit.SECONDS); 
    //client will recieve a HTTP 408 (timeout error) after 10 seconds
    response.setTimeoutHandler((asyncResp) -> {
      asyncResp.resume(Response.status(Response.Status.REQUEST_TIMEOUT).build());
    });  
  } 
} 