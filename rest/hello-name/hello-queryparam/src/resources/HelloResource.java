package resources;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.net.URLDecoder;

@Path("hello")
public class HelloResource {
  
  public HelloResource() {}
  
  @GET
  public Response processQuery(
      @QueryParam("nume") String nume,
      @QueryParam("tip") String tip) {
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