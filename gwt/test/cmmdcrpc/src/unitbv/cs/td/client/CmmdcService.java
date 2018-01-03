package unitbv.cs.td.client;
import com.google.gwt.user.client.rpc.RemoteService;

public interface CmmdcService extends RemoteService{
  public long cmmdc(long m,long n);
}  