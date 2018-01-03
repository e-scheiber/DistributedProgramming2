package cmmdc.client;
import java.util.Scanner;
import cmmdc.ICmmdc;

public class CmmdcClient {
  private ICmmdc service;
  
  public void bindMyService(ICmmdc a) {
    System.out.println("Service was set");
    service = a;
    Scanner scanner=new Scanner(System.in);
    System.out.println("m=");
    long m=scanner.nextLong();
    System.out.println("n=");
    long n=scanner.nextLong();
    System.out.println("Cmmdc = "+service.cmmdc(m,n));
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
