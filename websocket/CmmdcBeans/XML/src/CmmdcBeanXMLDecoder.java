package websocket.cmmdc;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import javax.websocket.DecodeException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class CmmdcBeanXMLDecoder implements Decoder.Text<CmmdcBean>{
   @Override
   public void init(EndpointConfig ec) { }
   
   @Override
   public void destroy() { }
   
   @Override
   public CmmdcBean decode(String string) throws DecodeException{
     StringReader sr=new StringReader(string);   
     CmmdcBean bean=null;
     JAXBContext jaxbContext;
     try{
       jaxbContext=JAXBContext.newInstance(CmmdcBean.class);
       Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
       bean=(CmmdcBean)unmarshaller.unmarshal(sr);
     }
     catch(Exception e){
       e.printStackTrace();
     }     
     return bean;
   }
   
   @Override
   public boolean willDecode(String string) {
     return (string!=null);
   }
}