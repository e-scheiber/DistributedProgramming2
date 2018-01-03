package mywidgets.client;

import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.Window;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class CmmdcWidget extends Composite {
  public CmmdcWidget() { 
    Label title=new Label("Cmmdc Widget");
    title.addStyleName("label-title");
    Label mLabel=new Label("m=");
    Label nLabel=new Label("n=");
    Label cmmdcLabel=new Label();
    TextBox mTextBox=new TextBox();
    TextBox nTextBox=new TextBox();
    Button button = new Button("Calculeaza");
    button.addStyleName("button");
    
    VerticalPanel cmmdcPanel = new VerticalPanel();
    cmmdcPanel.setWidth("100%");
    cmmdcPanel.addStyleName("vpanel");
    cmmdcPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
    cmmdcPanel.add(title);
    cmmdcPanel.add(mLabel);
    cmmdcPanel.add(mTextBox);
    cmmdcPanel.add(nLabel);
    cmmdcPanel.add(nTextBox);
    CmmdcWidgetClickHandler clickHandler=
      new CmmdcWidgetClickHandler(mTextBox,nTextBox,cmmdcLabel);  
    button.addClickHandler(clickHandler);   
    cmmdcPanel.add(button);
    cmmdcPanel.add(cmmdcLabel);
    
    initWidget(cmmdcPanel);
  }
}

class CmmdcWidgetClickHandler implements ClickHandler{
  TextBox mTextBox=null,nTextBox=null;
  Label cmmdcLabel=null;
  
  CmmdcWidgetClickHandler(TextBox mTextBox,TextBox nTextBox,Label cmmdcLabel){
    this.mTextBox=mTextBox;
    this.nTextBox=nTextBox;
    this.cmmdcLabel=cmmdcLabel;
  }
   
  public long cmmdc(long m,long n){
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
  
  public void onClick(ClickEvent event) {
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
       c=cmmdc(m,n);
    cmmdcLabel.setText("Cmmdc="+Long.valueOf(c).toString());
  }
}