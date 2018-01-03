package cmmdc.service;
 
public class CmmdcService implements cmmdc.ICmmdc{
  public long cmmdc(long m, long n){
    long c,r;
    do{
      c=n;
      r=m % n;
      m=n;
      n=r;
    }
    while (r!=0);
    return c;
  }
}
