package appjud;
import java.util.HashMap;
import javax.servlet.http.HttpSession;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

//@ManagedBean(name="judBean")
@Named("judBean")
@SessionScoped
public class JudBean implements java.io.Serializable{
  private static final long serialVersionUID = 5246554239140497934L;
  private String jud=null;
  private String capit=null;
  private String abrev=null;
  
  public JudBean(){}
  
  public void execute(){
    ExternalContext context=FacesContext.getCurrentInstance().getExternalContext();
    HttpSession session=(HttpSession)context.getSession(true);  
    HashMap<String,RefJudet> refJudete=(HashMap<String,RefJudet>)session.getAttribute("refJudete");
    //System.out.println(refJudete.size());
    RefJudet rj=refJudete.get(jud);
    capit=rj.getCapit();
    abrev=rj.getAbrev();
    //System.out.println(jud);
    //return "/appjudOutput.xhtml";
  }
  
  public void setJud(String jud){
    this.jud=jud;
  }
  
  public String getJud(){
    return jud;
  }
  
  public String getCapit(){
    return capit;
  }
  
  public String getAbrev(){
    return abrev;
  }
}
