package unitbv.cs.td.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import mywidgets.client.*;

public class MyApp implements EntryPoint {
   
  public void onModuleLoad() {
    HorizontalPanel hPanel=new HorizontalPanel();
    hPanel.setSpacing(50); 
    CmmdcWidget cw=new CmmdcWidget();
    HelloNameWidget hnw=new HelloNameWidget();
    hPanel.add(hnw);
    hPanel.add(cw);
    RootPanel.get("ginterface").add(hPanel);
  }
}
