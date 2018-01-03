package upload;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.File;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet; 
import java.util.List;
import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;

@WebServlet(urlPatterns = "/upload") 

public class FileUploadServlet extends HttpServlet{
  
  public void doPost(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException {
    String fs=System.getProperty("file.separator");
    String pathTomcat = new File(".").getCanonicalPath();
    // Linux
    //String pathTomcat="/home/mk/JavaApp/apache-tomcat-9.0.1";
    String contextPath=req.getContextPath();
    
    res.setContentType("text/plain");
    ServletOutputStream out = res.getOutputStream();
    try{
      //boolean isMultipart = ServletFileUpload.isMultipartContent(req);
      ServletFileUpload upload = new ServletFileUpload();
      FileItemIterator iter = upload.getItemIterator(req);
      while (iter.hasNext()) {
        FileItemStream item = iter.next();
        String name = item.getFieldName();
        out.println(name);      
        if (!item.isFormField()) {
          String fileName = item.getName();
          out.println(fileName);
          InputStream in=item.openStream();
          System.out.println(pathTomcat+fs+"webapps"+contextPath+fs+"upload"+fs+fileName);
          File file=new File(pathTomcat+fs+"webapps"+contextPath+fs+"upload"+fs+fileName);
          byte[] b=new byte[1024];
          FileOutputStream fos=new FileOutputStream(file);
          int s=0;
          do{
            s=in.read(b,0,1024);
            if(s!=-1)
              fos.write(b,0,s);
          }
          while(s!=-1);      
          fos.close();
          in.close();
          out.println("The file "+fileName+" has been uploaded !");
          out.close();
        }
      }
    }
    catch(Exception e){
      System.out.println("Exception: "+e.getMessage());
    }
  }
  
}