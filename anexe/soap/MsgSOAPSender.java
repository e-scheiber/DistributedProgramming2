import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.Name;
import java.io.FileOutputStream;

public class  MsgSOAPSender{
  public static void main(String[] args){
    Name name=null;
    try{
      MessageFactory mf=MessageFactory.newInstance();
      SOAPMessage soapMsg=mf.createMessage();
      SOAPPart part=soapMsg.getSOAPPart();
      SOAPEnvelope envelope=part.getEnvelope();
      SOAPBody body=envelope.getBody();    
      Name n1=envelope.createName("e1");
      SOAPElement e1=body.addBodyElement(n1);
      e1.addTextNode("primul");
      Name n2=envelope.createName("e2");
      SOAPElement e2=body.addBodyElement(n2);
      e2.addTextNode("al doilea");
      Name n11 =envelope.createName("e11");
      SOAPElement e11=e1.addChildElement(n11);
      e11.addTextNode("al treilea");
      FileOutputStream f=new FileOutputStream("MySOAPMessage.xml");
      soapMsg.writeTo(f);
    }
    catch(Exception e){
      System.out.println("Exception : "+e.getMessage());
    }
  }
}
