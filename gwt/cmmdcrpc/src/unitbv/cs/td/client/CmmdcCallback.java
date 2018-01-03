package unitbv.cs.td.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HTML;

public class CmmdcCallback implements AsyncCallback {
  public void onFailure(Throwable caught) {
    GWT.log("Error ", caught);
    caught.printStackTrace();
    Window.alert(caught.toString());
  }

  public void onSuccess(Object result) {
  // Varianta 1
    HTML html = 
      //new HTML("Cmmdc : "+result.toString());
      new HTML("<h1 style='border:1px gray solid;color:red;'>"+"Cmmdc = " + result.toString() +"</h1>"); 
    VerticalPanel vp = new VerticalPanel();
    vp.add(html);   
    RootPanel.get("result").add(vp); 
    
  // Varianta 2
  //  long rez=((Long)result).longValue();
  //  Window.alert("Cmmdc="+rez);
  }
}
