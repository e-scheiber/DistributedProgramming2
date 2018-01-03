package actions;

import java.util.Map;
import java.util.Random;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;

/*
@InterceptorRefs({
    @InterceptorRef("randomInterceptor"),
    @InterceptorRef("defaultStack")
})
@Action("guess")
*/

@Results({
  @Result(name="error", location="/jsp/error.jsp"),
  @Result(name="success", location="/jsp/success.jsp"),
  @Result(name="input", location="/jsp/index.jsp"),
})

@org.apache.struts2.convention.annotation.ParentPackage(value = "anint")

@Action(value="guess",interceptorRefs={@InterceptorRef("randomInterceptor"),@InterceptorRef("defaultStack")})


  
public class GuessNumber extends ActionSupport implements SessionAware{

	private int numar;
  private int incercari=1;
	private Map session;
	private int maxIncercari=4;
  
	public int getNumar() {
		return numar;
	}
	public void setNumar(int numar) {
		this.numar = numar;
	}
	
  public int getIncercari() {
		return incercari;
	}
	public void setIncercari(int incercari) {
		this.incercari = incercari;
	}
  
  public void setMaxIncercari(int maxIncercari) {
		this.maxIncercari = maxIncercari;
	}
  public int getMaxIncercari(){
    return maxIncercari;
  }  
  
	@Override
	public void setSession(Map session) {
		this.session = session;
	}
  
	public void validate() {
		//Validare pentru numarul introdus. 
		//Daca nu este integer valoarea, atunci se arunca o exceptie automat
		//pe care o prinde struts
		if(getNumar()==0) {
      addFieldError("numar", "Introduceti numerul");
		}
    if((numar>10) ||(numar<1))
      addFieldError("numar", "Trebuie sa fie cuprins intre 1 si 10");
	}

	@Override
	public String execute(){
    int deGhicit=((Integer)session.get("guess")).intValue();     
    Integer objIncercari=(Integer)session.get("incercari");
    
    if(objIncercari!=null){
       incercari=objIncercari.intValue();
    }     
    System.out.println(incercari+" "+numar+" "+deGhicit);
    incercari++;
    session.put("incercari",new Integer(incercari));
    
    if(numar==deGhicit){ 
      session.remove("guess");
      session.remove("incercari");
      return SUCCESS;
    }  
    else{
      if(incercari==maxIncercari){
        session.remove("guess");
        session.remove("incercari");
        return ERROR;  
      }
      else{
        return INPUT;
      }
    }      
  }
}
