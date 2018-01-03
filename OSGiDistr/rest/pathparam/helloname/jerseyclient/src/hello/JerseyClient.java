package hello;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation; 
import javax.ws.rs.core.MediaType;  
import java.util.Scanner;

public class JerseyClient {
  public static void main(String args[]) {
    Scanner scanner=new Scanner(System.in);
    System.out.println("Introduceti numele : ");
    String nume=scanner.next();
    Client client = ClientBuilder.newClient(); 
    WebTarget webTarget=client.target("http://localhost:8080/services/hellopath/"+nume); 
    
    String response=webTarget.request().get(String.class);
    System.out.println(response);
  }
}
