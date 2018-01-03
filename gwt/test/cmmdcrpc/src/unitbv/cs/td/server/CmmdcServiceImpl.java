package unitbv.cs.td.server;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import unitbv.cs.td.client.CmmdcService;

public class CmmdcServiceImpl extends RemoteServiceServlet implements CmmdcService{
  public long cmmdc(long m,long n){
    long r,c;
    do{
      c=n;
      r=m%n;
      m=n;
      n=r;
    }
    while(r!=0);
    return c;
  }
}  