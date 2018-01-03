package actions;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
//import org.apache.struts2.convention.annotation.Results;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Paths;

@Result(name="success",type="stream", params={"inputName","fileInputStream","bufferSize","2048","contentType","application/octet-stream","contentDisposition","attachment;filename=${file}"})

public class DownloadAction{
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
    /*
    String pathTomcat = new java.io.File(".").getCanonicalPath();
    String path=Paths.get(pathTomcat).toString()+
      fs+"webapps"+fs+"mystruts2-anapp"+
      fs+"resources"+fs; 
    System.out.println(path+file);
    */
    ServletContext servletContext = 
      ServletActionContext.getServletContext();
    String path=servletContext.getRealPath("/")+
      fs+"resources"+fs;
      
    fileInputStream = new FileInputStream(new File(path+file));
    return "success";
  }
}
