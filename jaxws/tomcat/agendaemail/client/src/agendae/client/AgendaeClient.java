package agendae.client;
import java.util.List;
import java.util.Scanner;

public class AgendaeClient {
  public static void main(String[] args) {
    Scanner scanner=new Scanner(System.in);
    System.out.println("nume = ");
    String nume=scanner.next().trim();
    try {
      AgendaeWS port=new AgendaeWSService().getAgendaeWSPort();
      List<String> lst=port.getEmailAddresses(nume);
      for(String addr: lst){
        System.out.println(addr);
      }
    }
    catch (Exception e) {
      System.out.printf("AnException : "+e.getMessage());
    }
  }
}
