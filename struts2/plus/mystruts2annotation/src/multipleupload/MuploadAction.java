package actions;

import java.io.*;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
//import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Results({
  @Result(name="error", location="/jsp/ErrorUpload.jsp"),
  @Result(name="success", location="/jsp/ResultMultipleUpload.jsp")
})

public class MuploadAction{
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
  
  public void setMyFileContentType(String[] myFileContentType) {
    this.myFileContentType = myFileContentType;
  }
  
  public String execute() throws Exception {
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
      return "success";
    else{
      attr.put("error","Upload Error");
      return "error";
    }
  }
}
