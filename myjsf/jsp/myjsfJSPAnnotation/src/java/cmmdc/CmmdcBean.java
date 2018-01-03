package cmmdc;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="cb")
@SessionScoped
public class CmmdcBean implements java.io.Serializable{
  private String sm;
  private String sn;
  private String sresult;

  public CmmdcBean(){}

  public String getSm(){
    return sm;
  }

  public void setSm(String sm){
    this.sm=sm;
  }

  public String getSn(){
    return sn;
  }

  public void setSn(String sn){
    this.sn=sn;
  }

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
    long m=Long.parseLong(sm);
    long n=Long.parseLong(sn);
    long c=cmmdc(m,n);
    sresult=Long.valueOf(c).toString(); 
    //System.out.println(sresult);
    return "/cmmdcOutput.jsp";
  }
  
  public void validateString(FacesContext context,UIComponent component,
    Object value)throws ValidatorException{
    if((context==null)||(component==null)) {
      throw new NullPointerException();
    }
    if(value.toString().trim().equals("")){
      throw new ValidatorException(new FacesMessage("Nu ati completat campul"));
    }
    else{
      String s=value.toString();
      try{
        Long.parseLong(s);
      }
      catch(NumberFormatException e){
        throw new ValidatorException(new FacesMessage("Nu este numar"));
      }
    }
  }
}

