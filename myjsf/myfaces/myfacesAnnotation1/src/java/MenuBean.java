import java.util.Collection;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="menuBean")
@SessionScoped
public class MenuBean implements java.io.Serializable{
  private Collection<MenuItem> menus;
  
  public Collection<MenuItem> getMenus(){
    return menus;
  }
  public void setMenus(Collection<MenuItem> menus){
    this.menus=menus;
  }
  
  public MenuBean(){
    menus=new ArrayList<MenuItem>();
    menus.add(new MenuItem("cmmdcInput.faces","CMMDC automat"));
    menus.add(new MenuItem("cmmdcInput1.faces","CMMDC manual"));      
    menus.add(new MenuItem("appjudInput.faces","App judete")); 
  }  
}