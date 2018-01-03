import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import javax.websocket.EncodeException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class CmmdcBeanXMLEncoder implements Encoder.Text<CmmdcBean> {
   @Override
   public void init(EndpointConfig ec) { }
   
   @Override
   public void destroy() { }
   
   @Override
   public String encode(CmmdcBean obj) throws EncodeException{
     JAXBContext jaxbContext=null;
     StringWriter st=null;
     try{
       jaxbContext=JAXBContext.newInstance(CmmdcBean.class);
       Marshaller marshaller=jaxbContext.createMarshaller();
       st=new StringWriter();
       marshaller.marshal(obj,st);
       System.out.println("Results : "+st.toString());
     }
     catch(Exception e){
       e.printStackTrace();
     }
     return st.toString();
   }  
}