package unitbv.cs.td.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
//import com.google.gwt.user.client.ui.*;
import java.util.*;

public class CmmdcCallback implements AsyncCallback {
  public void onFailure(Throwable caught) {
    GWT.log("Error ", caught);
    caught.printStackTrace();
    Window.alert(caught.toString());
  }

  public void onSuccess(Object result) {
    long rez=((Long)result).longValue();
    Window.alert("Cmmdc="+rez);
  }
}
