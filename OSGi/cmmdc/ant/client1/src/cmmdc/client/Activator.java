package cmmdc.client;
import cmmdc.ICmmdc;
import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator{
  public void start(BundleContext context){
    try{
      ServiceReference[] refs=context.getServiceReferences(ICmmdc.class.getName(),null);
      if(refs!=null){
        ICmmdc obj=(ICmmdc)context.getService(refs[0]);
        Scanner scanner=new Scanner(System.in);
        System.out.println("Client Cmmdc 1");
        System.out.println("Primul numar : ");
        long m=scanner.nextLong();
        System.out.println("al doilea numar : ");
        long n=scanner.nextLong();
        long c=obj.cmmdc(m,n);
        System.out.println("Cmmdc = "+c);
      }
    }
    catch(Exception e){
      System.out.println("Client Exception : "+e.getMessage());
    }
  }

  public void stop(BundleContext context) {}
}
