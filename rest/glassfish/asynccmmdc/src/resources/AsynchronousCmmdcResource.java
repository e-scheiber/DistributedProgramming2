package resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.container.AsyncResponse;
import javax.ejb.Stateless;
import javax.ejb.Asynchronous;


@Stateless
@Path("/cmmdc")
public class AsynchronousCmmdcResource {
   
  @GET
  @Asynchronous
  public void asyncRestMethod(@Suspended final AsyncResponse asyncResponse,
      @QueryParam("m") String sm,
      @QueryParam("n") String sn) {
    long m=Long.parseLong(sm);
    long n=Long.parseLong(sn);
    System.out.println(m+" : "+n); 
    long r=cmmdc(m,n);    
    String result = new Long(r).toString();
    asyncResponse.resume(result);
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