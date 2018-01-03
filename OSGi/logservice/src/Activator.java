import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogService;
import org.osgi.service.log.LogReaderService;
import org.osgi.service.log.LogListener;
import org.osgi.service.log.LogEntry;

public class Activator implements BundleActivator{
  
  public void start(BundleContext context) throws Exception {
    ServiceReference ref = context.getServiceReference(LogService.class.getName());
    LogService logService=null;
    if (ref != null){
      logService = (LogService)context.getService(ref);
    } 
    ref = context.getServiceReference(LogReaderService.class.getName());
    if (ref != null){
      LogReaderService reader = (LogReaderService) context.getService(ref);
      reader.addLogListener(new LogWriter());
    }
    logService.log(LogService.LOG_INFO, "Pornirea serviciului de jurnalizare");
  }

  public void stop(BundleContext context) throws Exception{}
  
  class LogWriter implements LogListener{
    public void logged(LogEntry entry){
      System.out.println(entry.getMessage());
    }
  }  
}