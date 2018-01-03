package cmmdc.client;

import java.util.Scanner;

public class CmmdcClient {
  public static void main(String[] args) {
    System.out.println("Invocare sincrona");
    Scanner scanner=new Scanner(System.in);
    System.out.println("m=");
    long m=scanner.nextLong();
    System.out.println("n=");
    long n=scanner.nextLong();
    try {
      CmmdcWS port=new CmmdcWSService().getCmmdcWSPort();
      long result=port.cmmdc(m,n);
      System.out.println("Cmmdc="+result);
    }
    catch (Exception e) {
      System.out.printf("AnException : "+e.getMessage());
    }
  }
}
