import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import javax.websocket.EncodeException;
import javax.json.Json;
//import javax.json.JsonArray;
import javax.json.JsonObject;

public class CmmdcBeanJSONEncoder implements Encoder.Text<CmmdcBean> {
   @Override
   public void init(EndpointConfig ec) { }
   
   @Override
   public void destroy() { }
   
   @Override
   public String encode(CmmdcBean obj) throws EncodeException{
       long m=obj.getM();
       long n=obj.getN();
       /*
       JsonArray jsonArray=Json.createArrayBuilder()
        .add(Json.createObjectBuilder()
          .add("m",m))
        .add(Json.createObjectBuilder()
          .add("n",n))
        .build();
      String objJsonString=jsonArray.toString();
      */
      JsonObject jsonObject=Json.createObjectBuilder()
        .add("m",Long.valueOf(m).toString())
        .add("n",Long.valueOf(n).toString())
        .build();
      String objJsonString=jsonObject.toString();
      return objJsonString;
   }
}