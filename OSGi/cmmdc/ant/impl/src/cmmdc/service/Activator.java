package cmmdc.service;
import cmmdc.ICmmdc;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator{
  public void start(BundleContext context){
    context.registerService(ICmmdc.class.getName(),new CmmdcService(),null);
    System.out.println("Registering Cmmdc service.");
  }

  public void stop(BundleContext context) {}
}
