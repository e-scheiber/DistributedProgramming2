package cmmdc;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget; 
import javax.ws.rs.core.MediaType;
import java.util.Scanner;

public class JerseyClient {
  public static void main(String args[]) {
    Scanner scanner=new Scanner(System.in);
    System.out.println("Primul numar : ");
    long m=scanner.nextLong();
    System.out.println("Al doilea numar : ");
    long n=scanner.nextLong();
    String sm=(new Long(m)).toString();
    String sn=(new Long(n)).toString();
    Client client = ClientBuilder.newClient(); 
    //WebTarget webTarget=client.target("http://localhost:8080/cmmdcapp/resources/cmmdc/"+sm+","+sn);
    WebTarget webTarget=client.target("http://localhost:8080/services/cmmdcpath/"+sm+","+sn);
    String response=webTarget.request(MediaType.APPLICATION_XML).get(String.class);
    System.out.println();
    System.out.println(MediaType.APPLICATION_XML); 
    System.out.println(response);
  }
}
