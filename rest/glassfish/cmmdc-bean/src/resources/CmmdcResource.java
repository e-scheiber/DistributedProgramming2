package resources;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType; 

@Path("cmmdc")
public class CmmdcResource {  
  public CmmdcResource(){}
  
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON) 
  public CmmdcBean myJob(CmmdcBean obj){
    String sm=obj.getSm();
    String sn=obj.getSn();
    long m=Long.parseLong(sm);
    long n=Long.parseLong(sn);
    long c=cmmdc(m,n);
    String cmmdc=(new Long(c)).toString();
    obj.setResult(cmmdc);
    return obj;
  } 
  
  public long cmmdc(long m,long n) {
    long c,r;
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