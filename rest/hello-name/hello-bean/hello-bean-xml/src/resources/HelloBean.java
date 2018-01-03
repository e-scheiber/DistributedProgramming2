package resources;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="date")
public class HelloBean{
  private String msg;
  
  public void setMsg(String msg){
    this.msg=msg;
  }
  
  public String getMsg(){
    return msg;
  }
}