package hw;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation; 
import java.util.Scanner;

public class JerseyClient {
  public static void main(String args[]) {
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
        webTarget=client.target("http://localhost:8080/hw/webapi/helloworld");
        invocationBuilder=webTarget.request();
        response=invocationBuilder.get(String.class);
        break;
      case "html": 
        webTarget=client.target("http://localhost:8080/hw/webapi/helloworld/html");
        invocationBuilder=webTarget.request();//(MediaType.TEXT_PLAIN_TYPE);
        response=invocationBuilder.get(String.class);
        break;
      case "xml": 
        webTarget=client.target("http://localhost:8080/hw/webapi/helloworld/xml");
        invocationBuilder=webTarget.request();//(MediaType.TEXT_PLAIN_TYPE);
        response=invocationBuilder.get(String.class);
        break;
    }   
    System.out.println(response);
  }
}
