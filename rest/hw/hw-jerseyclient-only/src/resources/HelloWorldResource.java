package resources;

import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

@Path("helloworld")
public class HelloWorldResource {

  public HelloWorldResource() {}
  
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getText() {
    return ("Hello World");
  } 
  
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String getAsHtml() {
    return "<html><head></head><body bgcolor=\"#bbeebb\"><center><p>Hello World</p></center></body></html>";
  } 
  
  @GET
  @Produces(MediaType.TEXT_XML)
  public String getAsXml() {
      return "<response>Hello World</response>";
  } 
  
  @GET
  @Produces(MediaType.APPLICATION_XML)
  public String getAsAppXml() {
      return "<response>Hello World</response>";
  } 
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getAsJson() {
      return "[\"Hello World\"]";
  } 
}