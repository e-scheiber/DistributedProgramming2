package resources;
//import com.sun.jersey.api.representation.Form;
import javax.ws.rs.FormParam;
import java.io.InputStream;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.net.URLDecoder;

@Path("form")
public class FormResource {
  @Context ServletContext sc;  
  
  @GET
  @Produces("text/html")
  public InputStream doGet() {
    return sc.getResourceAsStream("/form.html");
  }    
  
  
  /**
   * Process the form submission. Produces a table showing the form field
   * values submitted.
   * @return a dynamically generated HTML table.
   * @param formData the data from the form submission
   */
   
  @POST
  @Consumes("application/x-www-form-urlencoded")
  public Response processForm(
      @FormParam("m") String sm,
      @FormParam("n") String sn,
      @FormParam("tip") String tip) {
    String tip0=URLDecoder.decode(tip);
    long m=Long.parseLong(sm);
    long n=Long.parseLong(sn);
    System.out.println(m+" : "+n+" : "+tip0);
    long c=cmmdc(m,n);
    String message=(new Long(c)).toString();
    Response r=null;
    switch(tip0){
      case "text/plain": 
        r=Response.ok(getPlainRep(message),"text/plain").build(); 
        break;
      case "text/html":
        r=Response.ok(getHtmlRep(message),"text/html").build();
        break;
    } 
    return r;
  }
  
  public String getPlainRep(String msg) {
     return msg;
  } 
  
  public String getHtmlRep(String msg) {
    return "<html><head></head><body bgcolor=\"#aaeeaa\"><center><h1>Cmmdc : "+
      msg+"</h1></center></body></html>";
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