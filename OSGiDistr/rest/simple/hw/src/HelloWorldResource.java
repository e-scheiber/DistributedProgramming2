package resources;

import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.GET;

@Path("helloworld")
public class HelloWorldResource {

  public HelloWorldResource() {}
  
  @GET
  @Produces("text/plain")
  public String getText() {
    return ("Hello World");
  } 
  
  @Path("html")
  @GET
  @Produces("text/html")
  public String getAsHtml() {
    return "<html><head></head><body bgcolor=\"#bbeebb\"><center><p>Hello World</p></center></body></html>";
  } 
  
  @Path("xml")
  @GET
  @Produces("application/xml")
  public String getAsXml() {
      return "<response>Hello World</response>";
  } 
}