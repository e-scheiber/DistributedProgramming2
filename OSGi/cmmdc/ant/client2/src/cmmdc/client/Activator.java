package cmmdc.client;
import cmmdc.ICmmdc;
import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator{
  public void start(BundleContext context){
    ServiceTracker serviceTracker=new ServiceTracker(context,
       ICmmdc.class.getName(),null);
    serviceTracker.open();
    ICmmdc obj=(ICmmdc)serviceTracker.getService();
    System.out.println("Client Cmmdc 2");
    Scanner scanner=new Scanner(System.in);
    System.out.println("Primul numar : ");
    long m=scanner.nextLong();
    System.out.println("al doilea numar : ");
    long n=scanner.nextLong();
    long c=obj.cmmdc(m,n);
    System.out.println("Cmmdc = "+c);
  }

  public void stop(BundleContext context) {}
}

