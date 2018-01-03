package appjud;
import java.util.Map;
import java.util.HashMap;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

public class JudBean extends ActionSupport{
  private String jud=null;
  private String capit=null;
  private String abrev=null;
  private String selectat;
  
  public JudBean(){}
  
  public String execute() throws Exception {
    Map attr=ActionContext.getContext().getSession();
    HashMap<String,RefJudet> refJudete=(HashMap<String,RefJudet>)attr.get("refJudete");
    /*
    Collection<RefJudet> col=refJudete.values();
    Iterator<RefJudet> iterator=col.iterator();
    while(iterator.hasNext()){
      RefJudet myJud=(RefJudet)iterator.next();
      System.out.println(myJud.getJud());
    }
    */
    RefJudet rj=refJudete.get(selectat);
    jud=rj.getJud();
    capit=rj.getCapit();
    abrev=rj.getAbrev();
    return SUCCESS;
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
