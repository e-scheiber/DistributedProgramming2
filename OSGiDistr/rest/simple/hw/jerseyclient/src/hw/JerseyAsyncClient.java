package hw;
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

public class JerseyAsyncClient {
  public static void main(String args[]) {
    System.out.println("Asyncronous Execution\n");
    String rootURL="http://localhost:8080/services/helloworld";
    String[] urls={rootURL,rootURL+"/html",rootURL+"/xml"};
    CountDownLatch cdl=new CountDownLatch(urls.length);
    Client client=ClientBuilder.newClient();
    for(String url:urls){    
      client.target(url)
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
             System.out.println(throwable.getMessage());
             cdl.countDown();
           }
        });
    }
    
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
