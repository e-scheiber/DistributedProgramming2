package form;

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
    WebTarget webTarget=client.target("http://localhost:8080/Cmmdc/resources/form"); 
   
    Scanner scanner=new Scanner(System.in);
    System.out.println("Primul numar : ");
    long m=scanner.nextLong();
    System.out.println("Al doilea numar : ");
    long n=scanner.nextLong();
    String sm=(new Long(m)).toString();
    String sn=(new Long(n)).toString();
    Form f=new Form().param("m",sm).param("n",sn).param("tip","text/plain");
    //f.add("n",sn);
    //f.add("tip","text/plain");
    Response response=webTarget.request().post(Entity.form(f));
    String r = response.readEntity(String.class);
    System.out.println(r);
  }
}
