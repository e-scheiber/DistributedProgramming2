package unitbv.cs.td.client;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.List;

public interface AdreseServiceAsync{
   public void getEMail(String nume,AsyncCallback<List<String>> callback);
   public void getNume(String email,AsyncCallback<String> callback);
}