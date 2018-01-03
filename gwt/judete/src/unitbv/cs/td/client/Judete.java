package unitbv.cs.td.client;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler; 
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class Judete implements EntryPoint {
  private List<RefJudet> refJudete;

  public void onModuleLoad(){
    ListBox listBox=new ListBox();
    listBox.setVisibleItemCount(3);
    DBJudete db=new DBJudete();
    refJudete=db.getRefJudete();
    Iterator<RefJudet> iter=refJudete.iterator();
    while(iter.hasNext()){
      RefJudet ref=(RefJudet)iter.next();
      listBox.addItem(ref.getJud());
    }
    
    VerticalPanel dataPanel=new VerticalPanel(); 
    dataPanel.add(listBox);
    
    Label judLabel=new Label();
    Label capitLabel=new Label();
    Label abrevLabel=new Label();
    VerticalPanel resultsPanel=new VerticalPanel(); 
    resultsPanel.add(judLabel);
    resultsPanel.add(capitLabel);
    resultsPanel.add(abrevLabel);
    
    HorizontalPanel hp=new HorizontalPanel();
    hp.setSpacing(10);
    hp.add(dataPanel);
    hp.add(resultsPanel); 
    
    Button button=new Button("Cauta");
    button.addStyleName("button");
    MyClickHandler handler=new MyClickHandler(judLabel,
      capitLabel, abrevLabel, listBox);
    button.addClickHandler(handler); 
    
    RootPanel.get("judetePage").add(hp);
    RootPanel.get("button").add(button);
  }
  
  class MyClickHandler implements ClickHandler{ 
    private Label judLabel;
    private Label capitLabel;
    private Label abrevLabel;
    private ListBox listBox;
    
    MyClickHandler(Label judLabel,Label capitLabel,
      Label abrevLabel,ListBox listBox){
      this.judLabel=judLabel;
      this.capitLabel=capitLabel;
      this.abrevLabel=abrevLabel;
      this.listBox=listBox;
    }  
    
    public void onClick(ClickEvent event){ 
      int index=listBox.getSelectedIndex();
      RefJudet ales=(RefJudet)refJudete.get(index);
      judLabel.setText("Judetul : "+ales.getJud());
      capitLabel.setText("Capitala : "+ales.getCapit());
      abrevLabel.setText("Abrevierea : "+ales.getAbrev());
    }
  }  
}
