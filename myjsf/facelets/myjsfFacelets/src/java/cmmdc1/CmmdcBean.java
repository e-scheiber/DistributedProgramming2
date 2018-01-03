package cmmdc1;
import javax.servlet.http.HttpServletRequest;
import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;

public class CmmdcBean implements java.io.Serializable{
  private static final long serialVersionUID = 962139051193136314L;
  private String sresult;

  public CmmdcBean(){}
  
  private long cmmdc(long m,long n){
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
  
  public String getSresult(){
    return sresult;
  }

  public String compute(){
    ExternalContext context =
    FacesContext.getCurrentInstance().getExternalContext();
    HttpServletRequest request=(HttpServletRequest)context.getRequest();
    String sm = request.getParameter("myform:sm");
    String sn = request.getParameter("myform:sn");
	  long m=Long.parseLong(sm);
    long n=Long.parseLong(sn);
	  long c=cmmdc(m,n);
    sresult=Long.valueOf(c).toString(); 
    return "OK";
  }
}

