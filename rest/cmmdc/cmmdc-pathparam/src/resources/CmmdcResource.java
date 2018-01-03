package resources;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

@Path("cmmdc/{num1},{num2}")
public class CmmdcResource {
  
  public CmmdcResource(){}
  
  @GET
  @Produces(MediaType.APPLICATION_XML)
  public String getCmmdcAsXML(@PathParam("num1") String sm,@PathParam("num2") String sn){
    System.out.println(sm+" "+sn);
    long m=Long.parseLong(sm);
    long n=Long.parseLong(sn);
    long c=cmmdc(m,n);
    String result=(new Long(c)).toString();
    return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><rezultat>"+result+"</rezultat>";
  } 
  
  private long cmmdc(long m,long n) {
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