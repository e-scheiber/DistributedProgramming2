package hello;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Entity; 
//import javax.ws.rs.client.Invocation; 
import javax.ws.rs.core.MediaType;
import java.util.Scanner;
import java.io.PrintWriter; 
import resources.HelloBean;

public class JerseyClient {
  public static void main(String args[]) {
    Scanner scanner=new Scanner(System.in);
    System.out.println("Numele : ");
    String nume=scanner.next();
    HelloBean bean=new HelloBean();
    bean.setMsg(nume);  
    
    Client client = ClientBuilder.newClient(); 
    String sURI="http://localhost:8080/JsonHelloMoxy/resources/hello";
    //String sURI="http://localhost:8080/cmmdc";  //grizzly
    WebTarget target=client.target(sURI);
    HelloBean obj = target
            .request()
            .post(Entity.entity(bean, MediaType.APPLICATION_JSON), HelloBean.class);
    System.out.println(obj.getMsg());
  }
}
