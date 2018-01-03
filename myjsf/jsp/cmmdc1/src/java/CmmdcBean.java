package cmmdc.model;

public class CmmdcBean implements java.io.Serializable{
  private long m=1;
  private long n=1;
  private long result;

  public CmmdcBean(){}

  public long getM(){
    return m;
  }
  public void setM(long m){
    this.m=m;
  }

  public long getN(){
    return n;
  }
  public void setN(long n){
    this.n=n;
  }

  public long getResult(){
    return result;
  } 
  
  public void compute(){
    result=cmmdc(m,n);
    System.out.println("m="+m+" n="+n);
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
}

