package resources;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType; 

@Path("hello")
public class HelloResource {  
  public HelloResource(){}
  
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON) 
  public HelloBean myJob(HelloBean obj){
    String nume=obj.getMsg();
    String response="Hello "+nume+" !";
    obj.setMsg(response);
    return obj;
  } 
}