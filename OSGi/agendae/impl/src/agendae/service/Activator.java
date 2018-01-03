package agendae.service;
import agendae.IAgendaEMail;
import java.util.Properties;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator{
  public void start(BundleContext context){
    context.registerService(IAgendaEMail.class.getName(),new AgendaEMailService(),null);
    System.out.println("Registering AgendaEMail service.");
  }

  public void stop(BundleContext context) {}
}
