package hello;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity; 
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response; 
import java.util.Scanner;

public class JerseyClient {
  public static void main(String args[]) {
    Client client = ClientBuilder.newClient(); 
    WebTarget webTarget=client.target("http://localhost:8080/Hello/resources/hello");
    Scanner scanner=new Scanner(System.in);
    System.out.println("Introduceti tipul raspunsului : ");
    System.out.println("( plain | html )");
    String tip=scanner.next();
    System.out.println("Introduceti numele : ");
    String nume=scanner.next();
	Form f=new Form().param("nume",nume).param("tip","text/"+tip);
    Response response=webTarget.request().post(Entity.form(f));
    String r = response.readEntity(String.class); 
    System.out.println(r);
  }
}
