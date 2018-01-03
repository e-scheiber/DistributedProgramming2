package resources;
import javax.ws.rs.QueryParam;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import java.net.URLDecoder;
//import javax.annotation.ManagedBean;
//import javax.inject.Inject;
import javax.ejb.EJB;
import cmmdc.App;

@Path("cmmdcquery")
//@ManagedBean
public class CmmdcQueryResource {
  //@Inject 
  @EJB
  App obj;

  @GET
  public Response processQuery(
      @QueryParam("m") String sm,
      @QueryParam("n") String sn,
      @QueryParam("tip") String tip) {
    String tip0=URLDecoder.decode(tip);
    long m=Long.parseLong(sm);
    long n=Long.parseLong(sn);
    System.out.println(m+" : "+n+" : "+tip0);
    long c=obj.cmmdc(m,n);
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
} 