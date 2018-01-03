package unitbv.cs.td.client;
import java.util.List;
import com.google.gwt.user.client.rpc.RemoteService;

public interface AdreseService extends RemoteService{
   public List<String> getEMail(String nume);
   public String getNume(String email);
}