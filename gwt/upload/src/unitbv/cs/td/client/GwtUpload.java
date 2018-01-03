package unitbv.cs.td.client;

import com.google.gwt.core.client.*; 
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*; 
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class GwtUpload implements EntryPoint{ 
  public void onModuleLoad(){ 
    final FormPanel form = new FormPanel(); 
    form.setAction("/upload/upload"); 
    form.setEncoding(FormPanel.ENCODING_MULTIPART); 
    form.setMethod(FormPanel.METHOD_POST); 
     
    Label title=new Label("File upload");
    title.addStyleName("label-title"); 
    
    VerticalPanel panel = new VerticalPanel(); 
    form.setWidget(panel); 
    
    panel.add(title);
    
    // Crearea unui widget FileUpload 
    FileUpload upload = new FileUpload(); 
    upload.setName("uploadFormElement"); 
    panel.add(upload); 

    // Adaugarea unui buton "submit"
    panel.add(new Button("Submit", new ClickHandler() { 
      public void onClick(ClickEvent event) { 
        form.submit(); 
      } 
    })); 
    
    // Activitati premergatoare expedierii formularului. 
    form.addSubmitHandler(new FormPanel.SubmitHandler() { 
      public void onSubmit(FormPanel.SubmitEvent event) { 
      }
    }); 
    
    // Activitati la receptionarea raspunsului
    form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() { 
      public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) { 
        String results=event.getResults();
        Window.alert(results); 
      } 
    });  
    RootPanel.get().add(form); 
  } 
} 
