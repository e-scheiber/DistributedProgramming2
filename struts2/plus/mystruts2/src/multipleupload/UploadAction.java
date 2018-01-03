package multipleupload;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{
  private File[] myFile;
  private String[] myFileFileName;
  private String[] myFileContentType;
  
  public File[] getMyFile() {
    return myFile;
  }
  
  public void setMyFile(File[] myFile) {
    this.myFile = myFile;
  }
  
  public String[] getMyFileFileName() {
    return myFileFileName;
  }
  
  public void setMyFileFileName(String[] myFileFileName) {
    this.myFileFileName = myFileFileName;
  }
  
  public String[] getMyFileContentType() {
    return myFileContentType;
  }
  
  public void setmyFileContentType(String[] myFileContentType) {
    this.myFileContentType = myFileContentType;
  }
  
  public String upload() throws Exception {
    String fs=System.getProperty("file.separator");
    Map attr=ActionContext.getContext().getSession();
    boolean error=false;
    ServletContext servletContext = 
      ServletActionContext.getServletContext();
    String dataDir = servletContext.getRealPath("/WEB-INF");
    int n=dataDir.length()-7;
    String dataDir0=dataDir.substring(0,n);
    System.out.println(dataDir0);
    for (int i=0; i < myFile.length; i++){
      if(myFile[i]!=null){
        File savedFile = new File(dataDir, myFileFileName[i]);
        myFile[i].renameTo(savedFile); 
        System.out.println("Tratarea fis "+i);
        try{
          //File outputFile = new File("webapps/mystruts2-app/multipleupload/"+myFileFileName[i]);
          File outputFile=new File(dataDir0+fs+"multipleupload"+fs+myFileFileName[i]);
          FileInputStream in = new FileInputStream(savedFile);
          FileOutputStream out = new FileOutputStream(outputFile);
          int c;
          while ((c = in.read()) != -1)
          out.write(c);
          in.close();
          out.close();
        }
        catch(IOException e){
          System.out.println("FILE COPY ERROR : "+e.getMessage());
        }
      }
      else
        error=true;
    }
    if(!error)
      return SUCCESS;
    else{
      attr.put("error","Upload Error");
      return ERROR;
    }
  }
}
