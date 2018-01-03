package resources;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import java.net.URLDecoder;

@Path("query")
public class CmmdcResource {
   
  @GET
  public Response processForm(
      @QueryParam("m") String sm,
      @QueryParam("n") String sn,
      @QueryParam("tip") String tip) {
    
    String tip0=null;//URLDecoder.decode(tip,"UTF-8");
    try{
      tip0=URLDecoder.decode(tip,"UTF-8");
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
    //System.out.println(nume+" : "+tip0);

    long m=Long.parseLong(sm);
    long n=Long.parseLong(sn);
    System.out.println(m+" : "+n+" : "+tip0);
    long c=cmmdc(m,n);
    String message=(new Long(c)).toString();
    Response r=null;
    switch(tip0){
      case "text/plain": 
        r=Response.ok(getPlainRep(message),"text/plain").build(); 
        break;
      case "text/html":
        r=Response.ok(getHtmlRep(message),"text/html").build();
        break;
    } 
    return r;
  }
  
  public String getPlainRep(String msg) {
     return msg;
  } 
  
  public String getHtmlRep(String msg) {
    return "<html><head></head><body bgcolor=\"#aaeeaa\"><center><h1>Cmmdc : "+
      msg+"</h1></center></body></html>";
  } 
    
  public long cmmdc(long m,long n) {
    long c,r;
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