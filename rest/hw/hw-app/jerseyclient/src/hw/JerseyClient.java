package hw;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation; //.Builder;
import javax.ws.rs.core.MediaType;
import java.util.Scanner;
import java.net.URI;
import javax.ws.rs.core.UriBuilder;

public class JerseyClient {
  public static void main(String args[]) {
    String host="http://localhost";
    int port=8080;
    String context="HelloWorld";
    String resources="webresources";
    String path="helloworld";
    
    URI rootURL=UriBuilder.fromUri(host)
      .port(port)
      .path(context)
      .path(resources)
      .path(path)
      .build();
    
    //String rootURL="http://localhost:8080/HelloWorld/webresources/helloworld";
    Client client = ClientBuilder.newClient();
    Scanner scanner=new Scanner(System.in);
    System.out.println("Introduceti tipul raspunsului : ");   
    System.out.println("( plain / html / xml )");
    String tip=scanner.next().trim();
    String response="";
    WebTarget webTarget=null;
    Invocation.Builder invocationBuilder=null;
    switch(tip){
      case "plain":  
        webTarget=client.target(rootURL);
        invocationBuilder=webTarget.request();
        response=invocationBuilder.get(String.class);
        break;
      case "html": 
        webTarget=client.target(rootURL+"/html");
        invocationBuilder=webTarget.request();
        response=invocationBuilder.get(String.class);
        break;
      case "xml": 
        webTarget=client.target(rootURL+"/xml");
        invocationBuilder=webTarget.request();
        response=invocationBuilder.get(String.class);
        break;
    }   
    System.out.println(response);
  }
}
