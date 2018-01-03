package hw;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation; 
//import javax.ws.rs.client.SyncInvoker;

public class JerseyClient {
  public static void main(String args[]) {
    Client client = ClientBuilder.newClient();
    String rootURL="http://localhost:8080/services/helloworld"; 
    String response="";
    WebTarget webTarget=null;
    Invocation.Builder invocationBuilder=null;
    //SyncInvoker invocationBuilder=null;
    
    webTarget=client.target(rootURL);
    invocationBuilder=webTarget.request();
    response=invocationBuilder.get(String.class);
    System.out.println("PLAIN TEXT");
    System.out.println(response+"\n");
      
    //webTarget=client.target(rootURL+"/html");
    invocationBuilder=webTarget
      .path("html")
      .request();
    response=invocationBuilder.get(String.class);
    System.out.println("HTML");
    System.out.println(response+"\n");
      
    //webTarget=client.target(rootURL+"/xml");
    invocationBuilder=webTarget
      .path("xml")
      .request();
    response=invocationBuilder.get(String.class);
    System.out.println("XML");
    System.out.println(response);
  }
}
