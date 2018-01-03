package websocket.cmmdc; 
//import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name="date")
public class CmmdcBean{
  private long m;
  private long n;
  public void setM(long m){
    this.m=m;
  }
  
  public long getM(){
    return m;
  }
  
  public void setN(long n){
    this.n=n;
  }
  
  public long getN(){
    return n;
  }
}