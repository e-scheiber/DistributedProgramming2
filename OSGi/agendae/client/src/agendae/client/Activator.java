package agendae.client;
import agendae.IAgendaEMail;
import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import java.util.List;
import java.util.Iterator;

public class Activator implements BundleActivator{
  public void start(BundleContext context){
    try{
      ServiceReference[] refs=context.getServiceReferences(IAgendaEMail.class.getName(),null);
      if(refs!=null){
        IAgendaEMail obj=(IAgendaEMail)context.getService(refs[0]);
        Scanner scanner=new Scanner(System.in);
        System.out.println("Client AgendaEMail");
        System.out.println("Alegeti : ");
        System.out.println("1 : Selectare dupa nume");
        System.out.println("2 : Selectare dupa email");
        int m=scanner.nextInt();
        switch(m){
          case 1 :
            System.out.println("Numele : ");
            String nume=scanner.next().trim();
            List<String> results=obj.getEMails(nume);
            if(results!=null){
              Iterator<String> iter=results.iterator();
              while(iter.hasNext()){
                System.out.println(iter.next());
              }  
            }
            break;
          case 2 :
            System.out.println("EMail : ");
            String email=scanner.next().trim();
            String result=obj.getName(email);
            System.out.println(result);
            break;
          default :
            System.out.println("Cod de actiune inexistent");
            break;
        }    
      }
    }
    catch(Exception e){
      System.out.println("Client Exception : "+e.getMessage());
    }
  }

  public void stop(BundleContext context) {}
}
