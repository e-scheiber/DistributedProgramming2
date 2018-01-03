package client;
import client.CmmdcEJB;
import client.CmmdcEJBService;
import java.util.Scanner;

public class CmmdcClient {
  public static void main(String[] args) {
    try {
      CmmdcEJB port=new CmmdcEJBService().getCmmdcEJBPort();
      Scanner scanner=new Scanner(System.in);
      System.out.println("m=");
      long m=scanner.nextLong();
      System.out.println("n=");
      long n=scanner.nextLong();
      long result=port.cmmdc(m,n);
      System.out.println("Cmmdc="+result);
    }
    catch (Exception e) {
      System.out.printf("AnException : "+e.getMessage());
    }
  }
}
