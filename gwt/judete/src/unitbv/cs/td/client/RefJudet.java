package unitbv.cs.td.client;
public class RefJudet implements java.io.Serializable{
  private String jud;
  private String capit;
  private String abrev;
  
  public RefJudet(){}
  
  public RefJudet(String d){
    String[] dj=d.split(" ");
    this.jud=dj[0];
    this.capit=dj[1];
    this.abrev=dj[2];
  }
  
  public void setJud(String jud){
    this.jud=jud;
  }
  
  public String getJud(){
    return jud;
  }
  
  public void setCapit(String capit){
    this.capit=capit;
  }
  
  public String getCapit(){
    return capit;
  }
  
  public void setAbrev(String abrev){
    this.abrev=abrev;
  }
  
  public String getAbrev(){
    return abrev;
  }
}