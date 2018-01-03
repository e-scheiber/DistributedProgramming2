package cmmdc.server;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService()
public class CmmdcWS {
    
    @WebMethod
    public long cmmdc(@WebParam(name = "m") long m, @WebParam(name = "n") long n) {
        System.out.println(m+" "+n);
        long c,r;
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
