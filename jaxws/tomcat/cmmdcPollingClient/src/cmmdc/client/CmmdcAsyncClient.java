package cmmdc.client;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.Future;
import javax.xml.ws.Response;
//import javax.xml.ws.AsyncHandler;
import java.util.Scanner;

public class CmmdcAsyncClient {
  public static void main(String[] args) {
    long delta=500;
    try {
      CmmdcWS port=new CmmdcWSService().getCmmdcWSPort();
      Scanner scanner=new Scanner(System.in);
      System.out.println("m=");
      long m=scanner.nextLong();
      System.out.println("n=");
      long n=scanner.nextLong();
      
      Response<CmmdcResponse> response=port.cmmdcAsync(m,n);
      while(!response.isDone()){
         System.out.println("Wait "+delta+" ms");
         Thread.sleep(delta);
      }
      CmmdcResponse output=response.get();
      long result=output.getReturn();
      System.out.println("Cmmdc="+result);
    }
    catch (Exception e) {
      System.out.printf("AnException : "+e.getMessage());
    }
  }
}
