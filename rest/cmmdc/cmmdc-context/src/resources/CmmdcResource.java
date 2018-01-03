package resources;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import java.net.URLDecoder;

@Path("cmmdc")
public class CmmdcResource {
  private String cmmdc;
  
  public CmmdcResource(){}
  
  @Context UriInfo uriInfo; 
  @GET
  public Response doGet(){
    MultivaluedMap<String,String> params=uriInfo.getQueryParameters();
    String sm=params.getFirst("m");
    String sn=params.getFirst("n");
    long m=Long.parseLong(sm);
    long n=Long.parseLong(sn);
    long c=cmmdc(m,n);
    cmmdc=(new Long(c)).toString();
    String tip=null;//URLDecoder.decode(params.getFirst("tip"));
	try{
	  tip=URLDecoder.decode(params.getFirst("tip"),"UTF-8");
	}
	catch(Exception e){
	  System.out.println(e.getMessage());
	}
    //System.out.println("Param : "+sm+" "+sn);
    Response r=null;
    switch(tip){
      case "text/plain": 
        r=Response.ok(getPlainRep(),"text/plain").build(); 
        break;
      case "text/html":
        r=Response.ok(getHtmlRep(),"text/html").build();
        break;
    } 
    return r;
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
  
  public String getPlainRep() {
    return cmmdc;
  } 
  
  public String getHtmlRep() {
    return "<html><head></head><body bgcolor=\"#aaeeaa\"><center><h1>Cmmdc : "+cmmdc+
      "</h1></center></body></html>";
  } 
}