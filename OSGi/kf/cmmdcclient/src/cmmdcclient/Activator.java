package cmmdcclient;
import java.util.Date;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import cmmdc.ICmmdc;
public class Activator implements BundleActivator {
  public static BundleContext bc = null;
  
  public void start(BundleContext bc) throws Exception {
    System.out.println(bc.getBundle().getHeaders().get(Constants.BUNDLE_NAME) +
      " starting...");
    Activator.bc = bc; 
    ServiceReference reference =
      bc.getServiceReference(ICmmdc.class.getName());  
    if (reference != null) {
      ICmmdc service = (ICmmdc)bc.getService(reference);
      VisualCmmdcClient obj=new VisualCmmdcClient(service);
      obj.setVisible(true);
      bc.ungetService(reference);
    }
    else {
      System.out.println("No Service available!");
    }  
  }
    
  public void stop(BundleContext bc) throws Exception {
    System.out.println(bc.getBundle().getHeaders().get(Constants.BUNDLE_NAME) +
      " stopping...");
    Activator.bc = null;
  }
}
