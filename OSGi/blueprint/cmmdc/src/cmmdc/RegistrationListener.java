package cmmdc.client;
import java.util.Map;
import java.util.Scanner;
import cmmdc.ICmmdc;

public class RegistrationListener {
 
  public void register(ICmmdc obj, Map properties) {
    VisualCmmdcClient myApp=new VisualCmmdcClient(obj);   
  }

  public void unregister(ICmmdc obj, Map properties) {
    System.out.println("Cmmmdc service unregistered");
  }
}
