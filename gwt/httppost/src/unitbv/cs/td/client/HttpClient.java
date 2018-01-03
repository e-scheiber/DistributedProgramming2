package unitbv.cs.td.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.http.client.*;
import com.google.gwt.user.client.Window;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;   

public class HttpClient implements EntryPoint {
  public void onModuleLoad() {
    Label title=new Label("CMMDC");
    title.addStyleName("label-title");
    Label mLabel=new Label("m=");
    Label nLabel=new Label("n=");
    Label cmmdcLabel=new Label();
    TextBox mTextBox=new TextBox();
    TextBox nTextBox=new TextBox();
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
    
  public void doPost(String url, String postData){
    RequestBuilder rb=new RequestBuilder(RequestBuilder.POST,url); 
    rb.setHeader("Content-Type","application/x-www-form-urlencoded");
    MyRequestCallback rc=new MyRequestCallback(cmmdcLabel);
    try{
      Request response=rb.sendRequest(postData,rc);
    }
    catch(RequestException e){
      cmmdcLabel.setText("RequestException : "+e.getMessage());
    }
  }
  
  public void onClick(ClickEvent event) {
    String url="/appcmmdc/cmmdc";
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
    if((m!=0)&&(n!=0)){
      StringBuffer sb=new StringBuffer();
      String encodedM=URL.encodeComponent("m")+"="+URL.encodeComponent(sm);
      sb.append(encodedM);
      sb.append("&");
      String encodedN=URL.encodeComponent("n")+"="+URL.encodeComponent(sn);
      sb.append(encodedN);
      sb.append("&");
      String encodedTip=URL.encodeComponent("tip")+"="+URL.encodeComponent("plain/plain");
      sb.append(encodedTip);
      String postData=sb.toString();
      doPost(url,postData);
    }
  }
}
 
class MyRequestCallback implements RequestCallback{
  Label label;
  private static final int STATUS_CODE_OK=200;
  
  MyRequestCallback(Label label){
    this.label=label;
  }
  
  public void onError(Request request,Throwable e){
    label.setText("Connection error : "+e.getMessage());
  }
  
  public void onResponseReceived(Request request,Response response){
    int sc=response.getStatusCode();
    if(sc==STATUS_CODE_OK){
      label.setText(response.getText());
    }
    else{
      label.setText("STATUS CODE : "+sc);
    }
  }
}
      