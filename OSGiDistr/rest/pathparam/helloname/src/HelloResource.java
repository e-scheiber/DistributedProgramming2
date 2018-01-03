package resources;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

@Path("/hellopath/{name}")
public class HelloResource {
  
  public HelloResource() {}
  
  @GET
  //@Produces("text/plain")
  public String sayHello(@PathParam("name") String nume){
    System.out.println(nume);
    return "Hi "+nume+" !";
  } 
  
  @POST
  @Produces(MediaType.APPLICATION_XML)
  public String getCmmdcAsXML(@PathParam("name") String name){ 
    String result="Hi "+name+" !";
    return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><rezultat>"+result+"</rezultat>";
  } 
}