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
      	httpService.registerResources("/agenda.html", "/agenda.html", null); 
      	httpService.registerServlet("/adrese", new AgendaEMailServlet(), null, null);
      } catch (Exception e) {
        e.printStackTrace();
      }
      return httpService;
    }		
    
    public void removedService(ServiceReference reference, Object service) {
      HttpService httpService = (HttpService) service;
      httpService.unregister("/agenda.html"); 
      httpService.unregister("/adrese"); 
      super.removedService(reference, service);
    }
  }
}
