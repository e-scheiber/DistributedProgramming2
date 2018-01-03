package hw;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation; 
import java.net.URI;
import javax.ws.rs.core.UriBuilder;


public class JerseyClient {
  public static void main(String args[]) {
    String host="http://localhost";
    int port=8080;
    String context="HelloWorld";
    String resources="resources";
    String path="helloworld";
    
    URI rootURL=UriBuilder.fromUri(host)
      .port(port)
      .path(context)
      .path(resources)
      .path(path)
      .build();
      
    //String rootURL="http://localhost:8080/HelloWorld/resources/helloworld";   
  
    Client client = ClientBuilder.newClient();   
    String response="";
    WebTarget webTarget=null;
    Invocation.Builder invocationBuilder=null;
    
    webTarget=client.target(rootURL);
    invocationBuilder=webTarget.request();
    response=invocationBuilder.get(String.class);
    System.out.println("PLAIN TEXT");
    System.out.println(response+"\n");
      
    invocationBuilder=webTarget
      .path("html")
      .request();
    response=invocationBuilder.get(String.class);
    System.out.println("HTML");
    System.out.println(response+"\n");
      
    invocationBuilder=webTarget
      .path("xml")
      .request();
    response=invocationBuilder.get(String.class);
    System.out.println("XML");
    System.out.println(response);
  }
}
