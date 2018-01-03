import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;

public class Activator implements BundleActivator{

  public void start(BundleContext context) throws Exception{
    ServiceReference sRef = context.getServiceReference(HttpService.class.getName());
    if (sRef != null){
      HttpService service = (HttpService) context.getService(sRef);
      service.registerServlet("/hello", new HelloServlet(), null, null);
      service.registerResources("/helloname.html", "/helloname.html", null); 
    }
  }
  
   public void stop(BundleContext context) throws Exception{}
}