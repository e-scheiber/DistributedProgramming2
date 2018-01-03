import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class HelloServlet extends HttpServlet {
  public void doGet(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException{
    ServletOutputStream out=res.getOutputStream(); 
    String nume=req.getParameter("name");
    String tip=req.getParameter("tip");
    if(tip.equals("text/html")){
      res.setContentType("text/html");
      out.println("<html>");
      out.println("<head><title>HelloServlet</title></head>");
      out.println("<body>");
      out.println("<h1>HelloServlet</h1>");
      out.println("<p>");
      out.println( "Hi "+ nume+" !");
      out.println("</p>");
      out.println("</body>");
      out.println("</html>");
    }
    else{
      res.setContentType("text/plain");
      out.println("Hi "+nume+" !");
    }
    out.close();
  }

  public void doPost(HttpServletRequest req,HttpServletResponse res)
     throws ServletException,IOException{
    doGet(req,res);
  }
}
