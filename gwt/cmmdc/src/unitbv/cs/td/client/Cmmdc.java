package unitbv.cs.td.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label; 
import com.google.gwt.user.client.Window;
 
public class Cmmdc implements EntryPoint {
  public void onModuleLoad() {
    final Label title=new Label("CMMDC");
    title.addStyleName("label-title");
    final Label mLabel=new Label("m=");
    final Label nLabel=new Label("n=");
    final Label cmmdcLabel=new Label();
    final TextBox mTextBox=new TextBox();
    final TextBox nTextBox=new TextBox();
    final Button button = new Button("Compute");
    button.addStyleName("pc-template-btn");
    
    VerticalPanel cmmdcPanel = new VerticalPanel();
    cmmdcPanel.setWidth("100%");
    cmmdcPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
    cmmdcPanel.add(title);
    cmmdcPanel.add(mLabel);
    cmmdcPanel.add(mTextBox);
    cmmdcPanel.add(nLabel);
    cmmdcPanel.add(nTextBox); 
    MyClickHandler clickHandler=new MyClickHandler(mTextBox,nTextBox,cmmdcLabel);  
    button.addClickHandler(clickHandler);   
    cmmdcPanel.add(button); 
    cmmdcPanel.add(cmmdcLabel); 
    
    RootPanel.get("cmmdcPage").add(cmmdcPanel); 
  }
}    
 
class MyClickHandler implements ClickHandler{
  TextBox mTextBox=null,nTextBox=null;
  Label cmmdcLabel=null;
  
  MyClickHandler(TextBox mTextBox,TextBox nTextBox,Label cmmdcLabel){
    this.mTextBox=mTextBox;
    this.nTextBox=nTextBox;
    this.cmmdcLabel=cmmdcLabel;
  }
   
  private long cmmdc(long m,long n){
    long r,c;
    do{
      c=n;
      r=m%n;
      m=n;
      n=r;
    }
    while(r!=0);
    return c;
  }
  
  public void onClick(ClickEvent event){
    String sm=mTextBox.getText();
    String sn=nTextBox.getText();   
    long m=0,n=0; 
    if(sm.equals("")){
      Window.alert("\'m\' nu este dat");
      //GWT.log("\'m\' nu este dat",null);
      cmmdcLabel.setText("?");
      return;
    }    
    if(sn.equals("")){
      Window.alert("\'n\' nu este dat");  
      //GWT.log("\'n\' nu este dat",null);
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
       c=cmmdc(m,n);
    cmmdcLabel.setText("Cmmdc="+Long.valueOf(c).toString());
  }
}
