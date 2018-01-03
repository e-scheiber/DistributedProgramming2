package resources;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

@Path("hello/{name}")
public class HelloResource {
  
  public HelloResource() {}
  
  @GET
  @Produces("text/plain")
  public String sayHello(@PathParam("name") String nume){
    System.out.println(nume);
    return "Hi "+nume+" !";
  } 
}