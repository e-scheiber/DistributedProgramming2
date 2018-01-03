package hw;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation; 
import javax.ws.rs.core.MediaType;

public class JerseyClient {
  public static void main(String args[]) {
    String serviceURL="http://localhost:8080/HelloWorld/resources/helloworld";
    Client client = ClientBuilder.newClient(); 
    WebTarget webTarget=client.target(serviceURL);    
    String response;
    System.out.println("MediaType.TEXT_PLAIN_TYPE"); 
    response=webTarget.request(MediaType.TEXT_PLAIN_TYPE)
      .get(String.class);   
    System.out.println(response);
    System.out.println(); 
    System.out.println("MediaType.TEXT_HTML_TYPE"); 
    response=webTarget.request(MediaType.TEXT_HTML_TYPE)
      .get(String.class);
    System.out.println(response);
    System.out.println(); 
    System.out.println("MediaType.TEXT_XML_TYPE"); 
    response=webTarget.request(MediaType.TEXT_XML_TYPE)
      .get(String.class);
    System.out.println(response);
    System.out.println(); 
    System.out.println("MediaType.APPLICATION_XML_TYPE"); 
    response=webTarget.request(MediaType.APPLICATION_XML_TYPE)
      .get(String.class);
    System.out.println(response); 
    System.out.println(); 
    System.out.println("MediaType.APPLICATION_JSON_TYPE");
    response=webTarget.request(MediaType.APPLICATION_JSON_TYPE)
      .get(String.class);
    System.out.println(response);
    System.out.println(); 
  }
}
