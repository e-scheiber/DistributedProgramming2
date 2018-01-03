package resources;
import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlValue;


@XmlRootElement(name="date")
//@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class CmmdcBean{
  private String sm;
  private String sn;
  private String result;
  
  //@XmlElement
  public void setSm(String sm){
    this.sm=sm;
  }
  
  public String getSm(){
    return sm;
  }
  
  //@XmlElement
  public void setSn(String sn){
    this.sn=sn;
  }
  
  public String getSn(){
    return sn;
  }
  
  //@XmlElement
  public void setResult(String result){
    this.result=result;
  }
  
  public String getResult(){
    return result;
  }
}