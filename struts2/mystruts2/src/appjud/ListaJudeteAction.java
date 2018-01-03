package appjud;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ListaJudeteAction extends ActionSupport{
  //private static final long serialVersionUID = 1L;
  private HashMap<String,RefJudet> refJudete=new HashMap<String,RefJudet>();

  public List<RefJudet> getJudeteList(){
    List<RefJudet> list=new ArrayList<RefJudet>();
    try(
      InputStream fis=this.getClass().getResourceAsStream("judete.txt");
      InputStreamReader isr=new InputStreamReader(fis);
      BufferedReader br=new BufferedReader(isr);){
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
    }
    catch(IOException e){
      e.printStackTrace();
    }
    Map attr=ActionContext.getContext().getSession();
    attr.put("refJudete",refJudete);
    return list;  
  }
}
