package cmmdc.client;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.xml.ws.Response;
import javax.xml.ws.AsyncHandler;
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
      
      CmmdcAsyncHandler asyncHandler=new CmmdcAsyncHandler();
      Future<?> response=port.cmmdcAsync(m,n,asyncHandler);
      while(!response.isDone()){
         System.out.println("Wait "+delta+" ms");
         Thread.sleep(delta);
      }   
      CmmdcResponse output=asyncHandler.getResponse();
      long result=output.getReturn();
      System.out.println("Cmmdc="+result); 
    }
    catch (Exception e) {
      System.out.printf("AnException : "+e.getMessage());
    }
  }
}

class CmmdcAsyncHandler implements AsyncHandler<CmmdcResponse>{
  private CmmdcResponse output;
  
  public void handleResponse(Response<CmmdcResponse> response){
    try{
      output=response.get();
    }
    catch(ExecutionException e){
      System.out.println("ExecutionException : "+e.getMessage());
      e.printStackTrace();
    }
    catch(InterruptedException e){
      System.out.println("InterruptedException : "+e.getMessage());
      e.printStackTrace();
    }
  }
  
  CmmdcResponse getResponse(){
    return output;
  }
}
