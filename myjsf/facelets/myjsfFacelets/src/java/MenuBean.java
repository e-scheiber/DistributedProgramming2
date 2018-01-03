import java.util.Collection;
import java.util.ArrayList;
public class MenuBean implements java.io.Serializable{
  private static final long serialVersionUID = -5224582011024151505L;
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