package cmmdc;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.client.Invocation; 
import javax.ws.rs.client.InvocationCallback; 
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
//import java.util.concurrent.Future;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
import java.util.Scanner;

public class JerseyAsyncClient {
  public static void main(String args[]) {
    Scanner scanner=new Scanner(System.in);
    System.out.println("Primul numar : ");
    long m=scanner.nextLong();
    System.out.println("Al doilea numar : ");
    long n=scanner.nextLong();
    String sm=(new Long(m)).toString();
    String sn=(new Long(n)).toString();
    CountDownLatch cdl=new CountDownLatch(1);
    System.out.println("Asyncronous Execution\n");
    String url="http://localhost:8080/asynccmmdc/resources/cmmdc";
   
    Client client=ClientBuilder.newClient();
    
     
      client.target(url)
        .queryParam("m",sm)
        .queryParam("n",sn)
        .request()
        .async()
        .get(new InvocationCallback<String>(){
           @Override
           public void completed(String msg){
             System.out.println("Received: "+"\n"+msg);
             cdl.countDown();
           }
           @Override
           public void failed(Throwable throwable){
             throwable.printStackTrace();
             //System.out.println(throwable.getMessage());
             cdl.countDown();
           }
        });
   
    try {
      //if(cdl.await(10, TimeUnit.SECONDS)){
      cdl.await();
      client.close();
         //System.out.println("Waiting for requests to complete has timed out.");
       //}
    } 
    catch (final InterruptedException e) {
       e.printStackTrace();
    }
   
  }
}
