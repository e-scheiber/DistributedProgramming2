package cmmdc;

public class CmmdcBean implements java.io.Serializable{
  private String sm="";
  private String sn="";
  private String sresult;
  private long m;
  private long n;
  
  public CmmdcBean(){}

  public String getSm(){
    return sm;
  }

  public void setSm(String sm){
    this.sm=sm;
  }

  public String getSn(){
    return sn;
  }

  public void setSn(String sn){
    this.sn=sn;
  }

  private long cmmdc(long m,long n){
    long r,c;
    do{
      c=n;
      r=m%n;
      m=n;
      n=r;
    }
    while(r!=0);
    return c;
  }
  
  public String getSresult(){
    return sresult;
  }
  
  public String compute(){
    System.out.println("Errors= "+m+" "+n+" : "+sm+" "+sn);
    if((m!=0) && (n!=0)){
      long c=cmmdc(m,n);
      sresult=Long.valueOf(c).toString(); 
    }  
    return "OK";
  }
  
  public void validateSm(){
    try{
      m=Long.parseLong(sm);
    }
    catch(NumberFormatException e){
      sresult="Nu este numar";
      m=0;
      sm="";
    }
  }
 
  public void validateSn(){
    try{
      n=Long.parseLong(sn);
    }
    catch(NumberFormatException e){
      sresult="Nu este numar";
      n=0;
      sn="";
    }
  }
}

