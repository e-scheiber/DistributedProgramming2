import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {

  private ServiceTracker httpServiceTracker;
  
  public void start(BundleContext context) throws Exception {
    httpServiceTracker = new HttpServiceTracker(context);
    httpServiceTracker.open();
  }
  
  public void stop(BundleContext context) throws Exception {
    httpServiceTracker.close();
    httpServiceTracker = null;
  }
  
  private class HttpServiceTracker extends ServiceTracker {
  
    public HttpServiceTracker(BundleContext context) {
      super(context, HttpService.class.getName(), null);
    }
    
    public Object addingService(ServiceReference reference) {
      HttpService httpService = (HttpService) context.getService(reference);
      try {			
      	httpService.registerResources("/cmmdc.html", "/cmmdc.html", null); 
      	httpService.registerServlet("/cmmdc", new CmmdcServlet(), null, null);
      } catch (Exception e) {
        e.printStackTrace();
      }
      return httpService;
    }		
    
    public void removedService(ServiceReference reference, Object service) {
      HttpService httpService = (HttpService) service;
      httpService.unregister("/cmmdc.html"); 
      httpService.unregister("/cmmdc"); 
      super.removedService(reference, service);
    }
  }
}
