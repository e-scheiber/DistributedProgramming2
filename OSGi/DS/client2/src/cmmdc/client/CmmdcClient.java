package cmmdc.client;
import cmmdc.ICmmdc;

public class CmmdcClient {
  private ICmmdc service;
  
  public void bindMyService(ICmmdc a) {
    System.out.println("Service was set");
    service = a;
    VisualCmmdcClient myApp=new VisualCmmdcClient(service);
    /*
    Thread thread=new Thread(new Runnable(){
      public void run(){
        VisualCmmdcClient myApp=new VisualCmmdcClient(service);
      }  
    });
    thread.start();
    */
  }
  
  public void unbindMyService(ICmmdc a) {
    if(service==a)
      service = null;
    System.out.println("Service was unset");
  }
  
}
