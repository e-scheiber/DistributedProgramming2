package resources;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import java.net.URLDecoder;

@Path("hello")
public class HelloResource {
  
  public HelloResource() {}
  
  @Context UriInfo uriInfo; 
  @GET
  public Response doGet(){
    MultivaluedMap<String,String> params=uriInfo.getQueryParameters();
    String nume=params.getFirst("nume");
    String tip=null;//URLDecoder.decode(params.getFirst("tip"));
	try{
	  tip=URLDecoder.decode(params.getFirst("tip"),"UTF-8");
	}
	catch(Exception e){
	  System.out.println(e.getMessage());
	}
    System.out.println("Param : "+nume+" "+tip);
    Response r=null;
    switch(tip){
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