package appjud;
import javax.faces.model.SelectItem;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.faces.context.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="countyBean")
@SessionScoped
public class CountyBean implements java.io.Serializable{
  private ArrayList<SelectItem> judete=null;
  private HashMap<String,RefJudet> refJudete=new HashMap<String,RefJudet>();
  
  public CountyBean(){
    judete=new ArrayList<SelectItem>(50);
    try{
      // Fisierul judete.txt trebuie plasat in radacina apache-tomcat
      // FileInputStream fis=new FileInputStream("judete.txt");
      // Fisierul judete.txt plasat in catalogul aplicatiei
      InputStream fis=this.getClass().getResourceAsStream("judete.txt");
      InputStreamReader isr=new InputStreamReader(fis);
      BufferedReader br=new BufferedReader(isr);
      String s="",jud,capit,abrev;
      do{
        s=br.readLine();
        if(s!=null){
          StringTokenizer st=new StringTokenizer(s," ");
          jud=st.nextToken();
          capit=st.nextToken();
          abrev=st.nextToken(); 
          //System.out.println(s);
          judete.add(new SelectItem(jud,jud));
          //
          RefJudet rj=new RefJudet();
          rj.setJud(jud);
          rj.setCapit(capit);
          rj.setAbrev(abrev);
          //System.out.println(rj.getJud()+" "+rj.getCapit()+" "+rj.getAbrev());
          refJudete.put(jud,rj);
        }
      }
      while(s!=null);
      //
      ExternalContext context=FacesContext.getCurrentInstance().getExternalContext();
      HttpSession session=(HttpSession)context.getSession(true);  
      session.setAttribute("refJudete",refJudete);
      br.close();
      isr.close();
      fis.close();
    }
    catch(Exception e){
      System.out.println("CountyBeanException : "+e.getMessage());
    }
  }
  
  public Collection<SelectItem> getJudete(){
    return judete;
  }
}