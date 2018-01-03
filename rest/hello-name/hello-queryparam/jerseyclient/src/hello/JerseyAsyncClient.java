package hello;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget; 
import javax.ws.rs.core.MediaType;
import java.util.Scanner;
import javax.ws.rs.client.InvocationCallback; 
import java.util.concurrent.Future;

public class JerseyAsyncClient {
  public static void main(String args[]) {
    Scanner scanner=new Scanner(System.in);
    System.out.println("Introduceti tipul raspunsului : ");
    System.out.println("( plain | html )");
    String tip=scanner.next();
    System.out.println("Introduceti numele : ");
    String nume=scanner.next();
    String url="http://localhost:8080/Hello/resources/hello";
    Client client = ClientBuilder.newClient(); 
    WebTarget webTarget=client.target(url);
    Future<String> future=webTarget
      .queryParam("nume",nume)
      .queryParam("tip","text/"+tip)
      .request()
      .async()
      .get(new InvocationCallback<String>(){
           @Override
           public void completed(String msg){
             System.out.println("Received: "+"\n"+msg);
           }
           @Override
           public void failed(Throwable throwable){
             System.out.println(throwable.getMessage());
           }
        });
    while(!future.isDone()){};
    client.close();
  }
}
