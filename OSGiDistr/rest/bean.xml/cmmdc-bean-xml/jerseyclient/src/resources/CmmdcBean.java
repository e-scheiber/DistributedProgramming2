package resources;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="date")
public class CmmdcBean{
  private String sm;
  private String sn;
  private String result;
  
  public void setSm(String sm){
    this.sm=sm;
  }
  
  public String getSm(){
    return sm;
  }
  
  public void setSn(String sn){
    this.sn=sn;
  }
  
  public String getSn(){
    return sn;
  }
  
  public void setResult(String result){
    this.result=result;
  }
  
  public String getResult(){
    return result;
  }
}