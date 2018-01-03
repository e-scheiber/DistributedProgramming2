package cmmdc;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.client.Invocation; 
//import javax.ws.rs.core.MediaType;
import java.util.Scanner;

public class JerseyClient {
  public static void main(String args[]) {
    Client client = ClientBuilder.newClient(); 
    WebTarget webTarget=client.target("http://localhost:8080/Cmmdc/TestServlet");
    Scanner scanner=new Scanner(System.in);
    System.out.println("Primul numar : ");
    long m=scanner.nextLong();
    System.out.println("Al doilea numar : ");
    long n=scanner.nextLong();
    String sm=(new Long(m)).toString();
    String sn=(new Long(n)).toString();
    String response=webTarget.queryParam("m",sm).
          queryParam("n",sn).
          queryParam("tip","text/plain").request().get(String.class);
    System.out.println(response);
  }
}
