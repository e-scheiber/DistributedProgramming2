package cmmdcws;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

@WebService
@Stateless
public class CmmdcEJB {
    
    @WebMethod
    public long cmmdc(@WebParam(name = "m") long m, @WebParam(name = "n") long n) {
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
