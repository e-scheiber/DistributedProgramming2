package cmmdc1;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.faces.context.*;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

//@ManagedBean(name="cb1")
@Named("cb1")
@SessionScoped
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
    return "/cmmdcOutput1.xhtml";
  }
}

