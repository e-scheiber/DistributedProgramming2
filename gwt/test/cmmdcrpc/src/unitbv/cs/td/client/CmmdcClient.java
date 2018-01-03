package unitbv.cs.td.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
//import com.google.gwt.user.client.ui.ClickHandler;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.Window;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class CmmdcClient implements EntryPoint {
  
  public void getResult(long m,long n){
    CmmdcServiceAsync cmmdcService=(CmmdcServiceAsync)GWT.create(CmmdcService.class);
    ServiceDefTarget sdt=(ServiceDefTarget)cmmdcService;
    String endpoint=GWT.getModuleBaseURL()+"cmmdcrpc";
    sdt.setServiceEntryPoint(endpoint);
    cmmdcService.cmmdc(m,n,new CmmdcCallback());
  }
  
  public void onModuleLoad() { 
    Label title=new Label("CMMDC");
    title.addStyleName("label-title");
    Label mLabel=new Label("m=");
    Label nLabel=new Label("n=");
    final Label cmmdcLabel=new Label();
    final TextBox mTextBox=new TextBox();
    final TextBox nTextBox=new TextBox();
    Button button = new Button("Compute");
    button.addStyleName("pc-template-btn");
    
    VerticalPanel cmmdcPanel = new VerticalPanel();
    cmmdcPanel.setWidth("100%");
    cmmdcPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
    cmmdcPanel.add(title);
    cmmdcPanel.add(mLabel);
    cmmdcPanel.add(mTextBox);
    cmmdcPanel.add(nLabel);
    cmmdcPanel.add(nTextBox);  
    button.addClickHandler(new ClickHandler(){
      public void onClick(ClickEvent event){
        String sm=mTextBox.getText();
        String sn=nTextBox.getText();   
        long m=0,n=0; 
        if(sm.equals("")){
          Window.alert("\'m\' nu este dat");
          cmmdcLabel.setText("?");
          return;
        }    
        if(sn.equals("")){
          Window.alert("\'n\' nu este dat");  
          cmmdcLabel.setText("?");
          return; 
        } 
        try{
          m=Long.parseLong(sm);
        }
        catch(NumberFormatException e){
          Window.alert("\'m\' nu este numar");
          cmmdcLabel.setText("?");
          return;
        }
        try{
          n=Long.parseLong(sn);
        }
        catch(NumberFormatException e){
          Window.alert("\'n\' nu este numar");
          cmmdcLabel.setText("?");
          return;
        }
        long c=0;
        if((m!=0)&&(n!=0))
           getResult(m,n);
      }
    });   
    cmmdcPanel.add(button);
    cmmdcPanel.add(cmmdcLabel);
    
    // Add image and button to the RootPanel
    RootPanel.get("cmmdcPage").add(cmmdcPanel);
  }
}
