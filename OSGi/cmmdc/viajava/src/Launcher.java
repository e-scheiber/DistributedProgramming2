import java.util.ArrayList; 
import java.util.HashMap; 
import java.util.List; 
import java.util.Map; 
import java.util.ServiceLoader;
import org.osgi.framework.Bundle; 
import org.osgi.framework.BundleContext; 
import org.osgi.framework.BundleException; 
import org.osgi.framework.launch.Framework; 
import org.osgi.framework.launch.FrameworkFactory;
public class Launcher{    
  public static void main(String args[]) throws BundleException { 
    FrameworkFactory frameworkFactory = ServiceLoader.load(FrameworkFactory.class).iterator().next();    
    Map<String, String> config = new HashMap<>();     
    Framework framework = frameworkFactory.newFramework(config); 
    framework.start();
    BundleContext context = framework.getBundleContext();  
    List<Bundle> bundles = new ArrayList<>();       
    bundles.add(context.installBundle("file:lib/org.apache.felix.gogo.command-1.0.2.jar"));  
    bundles.add(context.installBundle("file:lib/org.apache.felix.gogo.runtime-1.0.10.jar"));      
    //bundles.add(context.installBundle("file:lib/org.apache.felix.gogo.shell-0.10.0.jar"));
    bundles.add(context.installBundle("file:lib/org.apache.felix.gogo.jline-1.0.10.jar"));
    bundles.add(context.installBundle("file:lib/org.apache.felix.bundlerepository-2.0.10.jar"));
    bundles.add(context.installBundle("file:lib/jline-3.5.1.jar"));
    bundles.add(context.installBundle("file:lib/jansi-1.16.jar"));
    
    bundles.add(context.installBundle("file:interface/dist/icmmdc.jar"));
    bundles.add(context.installBundle("file:impl/dist/cmmdcservice.jar"));
    bundles.add(context.installBundle("file:client3/dist/clientcmmdc3.jar"));
    
    for (Bundle bundle : bundles){
      bundle.start(); 
    }   
  } 
} 
