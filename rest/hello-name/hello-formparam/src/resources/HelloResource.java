package resources;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.FormParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.net.URLDecoder;
import java.io.InputStream;
import javax.ws.rs.core.Context;
import javax.servlet.ServletContext;

@Path("hello")
public class HelloResource {
  @Context ServletContext sc;  
  
  public HelloResource() {}
  
  @POST
  @Consumes("application/x-www-form-urlencoded")
  public Response processQuery(
      @FormParam("nume") String nume,
      @FormParam("tip") String tip) {
    String tip0=null;//URLDecoder.decode(tip,"UTF-8");
    try{
      tip0=URLDecoder.decode(tip,"UTF-8");
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
    System.out.println(nume+" : "+tip0);
    Response r=null;
    switch(tip0){
      case "text/plain": 
        r=Response.ok(getPlainRep(nume),"text/plain").build(); 
        break;
      case "text/html":
        r=Response.ok(getHtmlRep(nume),"text/html").build();
        break;
    } 
    return r;
  }

  public String getPlainRep(String nume) {
     return "Hello "+nume+" !";
  } 
  
  public String getHtmlRep(String nume) {
    return "<html><head></head><body bgcolor=\"#aaeeaa\"><center><h1>Hello "+nume+" ! </h1></center></body></html>";
  } 
}