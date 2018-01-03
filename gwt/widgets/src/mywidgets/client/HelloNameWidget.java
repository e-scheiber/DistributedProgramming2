package mywidgets.client;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class HelloNameWidget extends Composite{
  public HelloNameWidget() {
    Label title=new Label("Hello Name Widget");
    title.addStyleName("label-title");
    Button button = new Button("Apasa-ma");
    Label nameLabel=new Label("Introduceti numele");
    final Label sLabel=new Label();
    final TextBox  nameTextBox=new TextBox();
    
    button.addStyleName("button"); 
    VerticalPanel vPanel = new VerticalPanel();
    vPanel.addStyleName("vpanel");
    vPanel.add(title);
    vPanel.setWidth("100%");
    vPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
    vPanel.add(nameLabel);
    vPanel.add(nameTextBox);
    vPanel.add(button);
    vPanel.add(sLabel); 
    button.addClickHandler(new ClickHandler(){
      public void onClick(ClickEvent event){ 
        String name=nameTextBox.getText();
        sLabel.setText("Hello "+name+" !");
      }
    });
    initWidget(vPanel);
  }
}
