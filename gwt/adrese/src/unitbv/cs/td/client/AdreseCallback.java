package unitbv.cs.td.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import java.util.*;

public class AdreseCallback implements AsyncCallback {
  public void onFailure(Throwable caught) {
    GWT.log("Error ", caught);
    caught.printStackTrace();
    Window.alert(caught.toString());
  }

  public void onSuccess(Object result) {
    final Label labelRez=new Label();
    Grid grid=new Grid(1,2);
    if(result instanceof String){
      String nume=(String)result;
      final Label labelNume=new Label((String)result);
      labelRez.setText("Numele cautat : ");
      grid.setWidget(0,0,labelRez);
      grid.setWidget(0,1,labelNume);
      RootPanel.get("rez").add(grid);
    }
    if(result instanceof List){
      final ListBox listAdrese=new ListBox();
      List<String> list=(List<String>)result;
      for(int i=0;i<list.size();i++){
        listAdrese.addItem((String)list.get(i));
      }
      labelRez.setText("Adresele cautate : ");
      grid.setWidget(0,0,labelRez);
      grid.setWidget(0,1,listAdrese);
      RootPanel.get("rez").add(grid);
    }
  }
}
