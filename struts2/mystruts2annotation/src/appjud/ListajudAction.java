package actions;
//import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import java.util.*;
import java.io.*;

import org.apache.struts2.convention.annotation.Result;
@Result(name="success",location="/jsp/AppJud.jsp")

public class ListajudAction{// extends ActionSupport{
  private HashMap<String,RefJudet> refJudete=new HashMap<String,RefJudet>();

  public String execute(){
    return "success";
  }
    
  public List<RefJudet> getJudeteList() throws IOException{
    List<RefJudet> list=new ArrayList<RefJudet>();
    InputStream fis=this.getClass().getResourceAsStream("judete.txt");
    InputStreamReader isr=new InputStreamReader(fis);
    BufferedReader br=new BufferedReader(isr);
    String s="",jud,capit,abrev;
    do{
      s=br.readLine();
      if(s!=null){
        String[] st=s.split(" ");  
        jud=st[0];
        capit=st[1];
        abrev=st[2];
        RefJudet bean=new RefJudet();
        bean.setJud(jud);
        bean.setCapit(capit);
        bean.setAbrev(abrev);
        list.add(bean);
        refJudete.put(jud,bean);
      }
    }
    while(s!=null);
    Map attr=ActionContext.getContext().getSession();
    attr.put("refJudete",refJudete);
    return list;
  }
}
