import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPPart;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.Name;
import java.util.Iterator;
import java.io.FileInputStream;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class MsgSOAPReceiver{
  public static void analyze(SOAPElement rootElement){
    Iterator iterator=rootElement.getChildElements();
    while(iterator.hasNext()){
      Object obj=iterator.next();
      if(!(obj instanceof Text)){
        SOAPElement element = (SOAPElement)obj;//iterator.next();
        short nodeType=element.getNodeType();
        System.out.println(nodeType); 
        Name name=element.getElementName();
        System.out.println("name : " + name.getLocalName());
        System.out.println("value : " + element.getValue());  
        analyze(element);
      }
    }
  }
 
  public static void main(String[] args) {
    try {
      FileInputStream fis=new FileInputStream("MySOAPMessage.xml");    
      MessageFactory mf = MessageFactory.newInstance();
      SOAPMessage soapMsg = mf.createMessage(null,fis);
      SOAPPart part=soapMsg.getSOAPPart();
      SOAPEnvelope envelope=part.getEnvelope();
      SOAPBody body=envelope.getBody(); 
      analyze(body);      
    } 
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}