package cmmdc;
import javax.ejb.Stateless;

@Stateless
public class App{
  public long cmmdc(long m,long n){
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
