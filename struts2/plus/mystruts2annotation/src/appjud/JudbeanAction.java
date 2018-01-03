package actions;
import java.util.*;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.convention.annotation.Result;

@Result(name="success", location="/jsp/ResultJud.jsp")

public class JudbeanAction{
  private String jud=null;
  private String capit=null;
  private String abrev=null;
  private String selectat;
  
  //public JudBeanAction(){}
  
  public String execute() throws Exception {
    Map attr=ActionContext.getContext().getSession();
    HashMap<String,RefJudet> refJudete=(HashMap<String,RefJudet>)attr.get("refJudete");
    RefJudet rj=refJudete.get(selectat);
    jud=rj.getJud();
    capit=rj.getCapit();
    abrev=rj.getAbrev();
    return "success";
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
  
  public void setSelectat(String selectat){
    this.selectat=selectat;
  }
  
  public String getSelectat(){
    return selectat;
  }
}
