package unitbv.cs.td.client;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CmmdcServiceAsync{
  public void cmmdc(long m,long n,AsyncCallback<Long> callback);
}  