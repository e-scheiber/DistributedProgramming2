package unitbv.cs.td.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import java.util.*;

public class AgendaEMail implements EntryPoint {  
  public void findByNume(String nume){
    AdreseServiceAsync adreseService=
      (AdreseServiceAsync)GWT.create(AdreseService.class);
    ServiceDefTarget target=(ServiceDefTarget)adreseService;
    String relativeURL=GWT.getModuleBaseURL()+"adrese";
    target.setServiceEntryPoint(relativeURL);
    adreseService.getEMail(nume, new AdreseCallback());
  }
  
  public void findByEMail(String email){
    AdreseServiceAsync adreseService=
      (AdreseServiceAsync)GWT.create(AdreseService.class);
    ServiceDefTarget target=(ServiceDefTarget)adreseService;
    String relativeURL=GWT.getModuleBaseURL()+"adrese";
    target.setServiceEntryPoint(relativeURL);
    adreseService.getNume(email, new AdreseCallback());
  }
  
  public void onModuleLoad(){
    final Button button=new Button("Cauta");
    final Label labelCriteriu=new Label("Criteriul de cautare");
    final Label labelEntitate=new Label("Entitatea cautata");
    final ListBox listBoxCriteriu=new ListBox();
    final TextBox textBoxEntitate=new TextBox();
    
    VerticalPanel adresePanel=new VerticalPanel();
    Label title=new Label("Agenda de adrese E-MAIL");
    title.addStyleName("label-title"); 
    Grid grid=new Grid(2,2);
    grid.setWidget(0,0,labelCriteriu);
    listBoxCriteriu.addItem("nume");
    listBoxCriteriu.addItem("email");
    listBoxCriteriu.setVisibleItemCount(1);
    grid.setWidget(0,1,listBoxCriteriu);
    grid.setWidget(1,0,labelEntitate);
    grid.setWidget(1,1,textBoxEntitate);
    button.addClickHandler(new ClickHandler(){
      public void onClick(ClickEvent event){
        String s=textBoxEntitate.getText();
        if(!"".equals(s)){
          if(listBoxCriteriu.getSelectedIndex()==0)
            findByNume(s);
          else
            findByEMail(s);
        }
      }
    });
    adresePanel.add(title);
    adresePanel.add(grid);
    adresePanel.add(button);
    RootPanel.get("adresePanel").add(adresePanel);
  }    
}
