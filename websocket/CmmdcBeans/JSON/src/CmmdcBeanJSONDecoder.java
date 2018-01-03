package websocket.cmmdc; 
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import javax.websocket.DecodeException;
import javax.json.Json;
import javax.json.JsonArray;
//import javax.json.JsonValue;
import javax.json.JsonObject;
//import javax.json.JsonNumber;
//import javax.json.JsonString;
import javax.json.JsonReader;
//import java.util.Iterator;
//import java.util.Map;
import java.io.StringReader;

public class CmmdcBeanJSONDecoder implements Decoder.Text<CmmdcBean>{
   @Override
   public void init(EndpointConfig ec) { }
   
   @Override
   public void destroy() { }
   
   @Override
   public CmmdcBean decode(String string) throws DecodeException{
     StringReader sr=new StringReader(string);   
     JsonReader jsonReader = Json.createReader(sr);
     //JsonArray jsonArray=jsonReader.readArray();
     JsonObject obj=jsonReader.readObject();
     jsonReader.close();
     
     //JsonObject obj=jsonArray.getJsonObject(0);
     long m=0,n=0;
     String sm=obj.getString("m"); 
     m=Long.parseLong(sm);   
     String sn=obj.getString("n");
     n=Long.parseLong(sn);   
     CmmdcBean bean=new CmmdcBean();
     bean.setM(m);
     bean.setN(n);
     return bean;
   }
   
   @Override
   public boolean willDecode(String string) {
     return true;
   }
}