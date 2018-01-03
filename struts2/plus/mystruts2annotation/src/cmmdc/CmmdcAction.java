package actions;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.convention.annotation.Action;
import java.util.Map;
import org.apache.struts2.convention.annotation.Result;

@Result(name="success", location="/jsp/ResultCmmdc.jsp")
public class CmmdcAction{
  public String execute(){
    long c=cmmdc(m,n);
    //setMessage(Long.valueOf(c).toString());
    Map attr=ActionContext.getContext().getSession();
    attr.put("cmmdc",Long.valueOf(c).toString());
    return "success";
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
  /*
  //Cum se adauga ?
  public void validate(){
     if(getM()==0){
       addFieldError("m","Camp necompletat");
     }
     if(n==0){
       addFieldError("n","Camp necompletat");
     }
  }
  */
}