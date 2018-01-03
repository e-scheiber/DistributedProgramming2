package download;
import javax.servlet.ServletContext;
//import org.apache.struts2.util.ServletContextAware;
import com.opensymphony.xwork2.ActionSupport;
//import com.opensymphony.xwork2.Result;
//import org.apache.struts2.dispatcher.StreamResult; 
//import com.opensymphony.xwork2.ActionContext; 
import org.apache.struts2.ServletActionContext;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Paths;

public class Download extends ActionSupport{
  private String file;
  
  public void setFile(String file) {
    this.file=file;
  }
  public String getFile(){
    return file;
  }  
  
  private InputStream fileInputStream;
  
  public InputStream getFileInputStream() {
    return fileInputStream;
  }
  
  public String execute() throws Exception {
    String fs=System.getProperty("file.separator"); 
    ServletContext servletContext = 
      ServletActionContext.getServletContext();
    String path=servletContext.getRealPath("/")+
      fs+"resources"+fs;
      
    fileInputStream = new FileInputStream(new File(path+file));
    return "success";
  }
}
