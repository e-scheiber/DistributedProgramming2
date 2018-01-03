package agendae;
import java.util.List;
public interface IAgendaEMail{
  public List<String> getEMails(String name);
  public String getName(String email);
}