import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.OutputStream;

@ManagedBean(name="downloadPage")
@RequestScoped
public class DownloadPage implements java.io.Serializable{
  private String file;
  
  public void setFile(String file){
    this.file=file;
  }

  public String getFile(){
    return file;
  }  
    
  public void downloadFile() throws Exception{
    FacesContext fc=FacesContext.getCurrentInstance();
    ExternalContext context =fc.getExternalContext();
    OutputStream out=context.getResponseOutputStream();
    System.out.println(file);
    Path cale=Paths.get("webapps/download/resources/"+file);
    try{
      System.out.println(cale+file);
      context.setResponseContentType("Application/Octet-stream"); 
      context.setResponseHeader("Content-Disposition", "attachment; filename="+ file);
      Files.copy(cale,out);
      out.close(); 
      fc.responseComplete();
    }
    catch(Exception e){
      e.printStackTrace();
    }      
  }
}
