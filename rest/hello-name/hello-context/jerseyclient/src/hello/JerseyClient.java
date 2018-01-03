package hello;
import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientConfig;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation; //.Builder;
import javax.ws.rs.core.MediaType; 
import java.util.Scanner;

public class JerseyClient {
  public static void main(String args[]) {
    Client client = ClientBuilder.newClient(); 
    WebTarget webTarget=client.target("http://localhost:8080/Hello/resources/hello");
    Scanner scanner=new Scanner(System.in);
    System.out.println("Introduceti tipul raspunsului : ");
    System.out.println("( plain / html )");
    String tip=scanner.next();
    System.out.println("Introduceti numele : ");
    String nume=scanner.next();
    String response=webTarget.queryParam("nume",nume).
          queryParam("tip","text/"+tip).request().get(String.class);
    System.out.println(response);
  }
}
