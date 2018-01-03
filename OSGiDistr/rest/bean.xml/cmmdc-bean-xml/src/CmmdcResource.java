package resources;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType; 

@Path("cmmdcbeanxml")
public class CmmdcResource {  
  public CmmdcResource(){}
  
  @POST
  @Produces(MediaType.APPLICATION_XML)
  @Consumes(MediaType.APPLICATION_XML) 
  public CmmdcBean myJob(CmmdcBean obj){
    
    String sm=obj.getSm();
    String sn=obj.getSn();
    /*
    String sm=obj.smValue;
    String sn=obj.snValue;
    */
    System.out.println(sm+" : "+sn);
    long m=Long.parseLong(sm);
    long n=Long.parseLong(sn);
    long c=cmmdc(m,n);
    String cmmdc=(new Long(c)).toString();
    //obj.setResult(cmmdc);
    CmmdcBean cb=new CmmdcBean();
    //cb.resultValue=cmmdc;
    //cb.setSm(cmmdc);
    cb.setResult(cmmdc);
    return cb;
    //return obj;
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