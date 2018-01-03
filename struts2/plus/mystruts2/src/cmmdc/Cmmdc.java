package cmmdc;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import java.util.Map;

public class Cmmdc extends ActionSupport {
  //private static final long serialVersionUID = 1L;

  public String computeCmmdc(){
    long c=cmmdc(m,n);
    //setMessage(Long.valueOf(c).toString());
    Map attr=ActionContext.getContext().getSession();
    attr.put("cmmdc",Long.valueOf(c).toString());
    return SUCCESS;
  }

  public long cmmdc(long m, long n){
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

  private long m;
  public long getM() {
      return m;
  }
  public void setM(long m) {
      this.m = m;
  }

  private long n;
  public long getN() {
      return n;
  }
  public void setN(long n) {
      this.n = n;
  }
  /*
  private String message;
  public void setMessage(String message){
      this.message = message;
  }
  public String getMessage() {
      return message;
  }
  */
  public void validate(){
     if(getM()==0){
       addFieldError("m","Camp necompletat");
     }
     if(n==0){
       addFieldError("n","Camp necompletat");
     }
  }
}