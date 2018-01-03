package cmmdc.controller;
import javax.faces.component.UIInput;
import javax.faces.component.UIOutput;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import cmmdc.model.CmmdcBean;

public class CmmdcController implements java.io.Serializable{
  private CmmdcBean cmmdcBean;
  private UIInput primulNumar;
  private UIInput alDoileaNumar;
  private UIOutput rezultat;
  
  public CmmdcBean getCmmdcBean(){
    return cmmdcBean;
  }
  public void setCmmdcBean(CmmdcBean cmmdcBean){
    this.cmmdcBean=cmmdcBean;
  }

  public UIInput getPrimulNumar(){
    return primulNumar;
  }
  public void setPrimulNumar(UIInput primulNumar){
    this.primulNumar=primulNumar;
  }    
    
  public UIInput getAlDoileaNumar(){
    return alDoileaNumar;
  }
  public void setAlDoileaNumar(UIInput alDoileaNumar){
    this.alDoileaNumar=alDoileaNumar;
  }      
  
  public UIOutput getRezultat(){
    return rezultat;
  }
  public void setRezultat(UIOutput rezultat){
    this.rezultat=rezultat;
  }   
  
  public void cmmdc(){
    FacesContext facesContext = FacesContext.getCurrentInstance();
    try{
      cmmdcBean.compute();
      rezultat.setRendered(true);
      facesContext.addMessage(null, new FacesMessage(
          FacesMessage.SEVERITY_INFO, "OK", null));
    }
    catch(Exception e)    {
      rezultat.setRendered(false);
      facesContext.addMessage(null, 
          new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
      System.out.println(e.getMessage());
    }  
  }
}