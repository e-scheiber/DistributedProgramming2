package cmmdc.impl;
import cmmdc.ICmmdc;
import java.util.Properties;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator{
  public void start(BundleContext context){
    Properties props=new Properties();
    props.put("Cmmdc","simple");
    context.registerService(ICmmdc.class.getName(),new CmmdcService(),props);
    System.out.println("Registering Cmmdc service.");
  }

  public void stop(BundleContext context) {}
}
