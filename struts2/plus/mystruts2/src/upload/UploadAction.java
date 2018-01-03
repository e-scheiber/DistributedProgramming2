package upload;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.FileOutputStream;

public class UploadAction extends ActionSupport{
  private File myFile;
  private String myFileFileName;
  private String myFileContentType;
  
  public File getMyFile() {
      return myFile;
  }

  public void setMyFile(File myFile) {
      this.myFile = myFile;
  }

  public String getMyFileFileName() {
      return myFileFileName;
  }

  public void setMyFileFileName(String myFileFileName) {
      this.myFileFileName = myFileFileName;
  }

  public String getMyFileContentType() {
      return myFileContentType;
  }

  public void setMyFileContentType(String myFileContentType) {
      this.myFileContentType = myFileContentType;
  }

  public String upload() throws Exception {
    String fs=System.getProperty("file.separator");
    Map attr=ActionContext.getContext().getSession();
    ServletContext servletContext = 
      ServletActionContext.getServletContext();
    if (myFile != null) {
      String dataDir = servletContext.getRealPath("/WEB-INF");
      System.out.println("dataDir = "+dataDir);
      System.out.println("FileName = "+myFileFileName);
      File savedFile = new File(dataDir, myFileFileName);
      myFile.renameTo(savedFile);
      
      StringBuffer sb=new StringBuffer();
      FileInputStream fis=new FileInputStream(savedFile);
      InputStreamReader isr=new InputStreamReader(fis);
      BufferedReader br=new BufferedReader(isr);
      
      int n=dataDir.length()-7;
      String dataDir0=dataDir.substring(0,n);
      System.out.println(dataDir0);
      //File f=new File("webapps/mystruts2-app/upload/"+myFileFileName);
      File f=new File(dataDir0+fs+"upload"+fs+myFileFileName);
      FileOutputStream fos=new FileOutputStream(f);
      OutputStreamWriter osw=new OutputStreamWriter(fos);
      BufferedWriter bw=new BufferedWriter(osw);
      String line;
      do{
        line=br.readLine();
        if(line!=null){
          sb.append(line+"\n");
          bw.write(line,0,line.length());
          bw.newLine();
        }
      }
      while(line!=null);
      attr.put("files",sb.toString());
      bw.close();
      osw.close();
      fos.close();
      br.close();
      isr.close();
      return SUCCESS;
    }
    else{
      attr.put("error","Upload Error");
      return ERROR;
    }   
  }
}
