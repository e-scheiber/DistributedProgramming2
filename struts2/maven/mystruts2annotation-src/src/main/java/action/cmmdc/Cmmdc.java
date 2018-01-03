package actions;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import java.util.*;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Results({
  @Result(name="error", location="/jsp/ErrorCmmdc.jsp"),
  @Result(name="success", location="/jsp/ResultCmmdc.jsp")
})

 @Action("cmmdc")
public class Cmmdc extends ActionSupport {
  public String execute(){
    long c=cmmdc(m,n);
   
    Map attr=ActionContext.getContext().getSession();
    attr.put("cmmdc",(new Long(c)).toString());
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
  private String message;
  public void setMessage(String message){
      this.message = message;
  }
  public String getMessage() {
      return message;
  }
}