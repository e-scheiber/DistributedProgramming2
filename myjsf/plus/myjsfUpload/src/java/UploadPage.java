import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

@ManagedBean(name="uploadPage")
@RequestScoped
public class UploadPage {
  private Part uploadFile;
  private String fileContent;

  public void validateFile(FacesContext ctx, UIComponent comp, Object value) {
    List<FacesMessage> msgs = new ArrayList<FacesMessage>();
    Part file = (Part)value;
    if (file.getSize() > 1024) {
      msgs.add(new FacesMessage("file too big"));
    }
    if (!"text/plain".equals(file.getContentType())) {
      msgs.add(new FacesMessage("not a text file"));
    }
    if (!msgs.isEmpty()) {
      throw new ValidatorException(msgs);
    }
  }

  public String uploadFile() throws Exception{
    String fs=System.getProperty("file.separator");
    ExternalContext context =
      FacesContext.getCurrentInstance().getExternalContext();
    HttpServletRequest request=(HttpServletRequest)context.getRequest();
    String fileRef=request.getSession().getServletContext().getRealPath("/")+fs;
    
    String myFileName=uploadFile.getSubmittedFileName();
    System.out.println(myFileName);
    try {
      Scanner scanner=new Scanner(uploadFile.getInputStream());
      StringBuffer sb=new StringBuffer();
      while(scanner.hasNextLine())
        sb.append(scanner.nextLine()+'\n');
      fileContent=sb.toString();  
    } 
    catch (IOException e) {
      FacesMessage msg = 
        new FacesMessage(FacesMessage.SEVERITY_ERROR,
          "error uploading file",
          null);
      FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    File f=new File(fileRef+fs+"WEB-INF"+fs+"upload"+fs+myFileName);
    FileOutputStream fos=new FileOutputStream(f);
    OutputStreamWriter osw=new OutputStreamWriter(fos);
    BufferedWriter bw=new BufferedWriter(osw);
    bw.write(fileContent,0,fileContent.length());
    bw.close();
    osw.close();
    fos.close();
    return "uploadOutput";
  }

  public Part getUploadFile() {
    return uploadFile;
  }

  public void setUploadFile(Part uploadFile) {
    this.uploadFile = uploadFile;
  }

  public String getFileContent() {
     return fileContent;
  }
}
