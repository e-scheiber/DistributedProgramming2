import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet; 
import javax.servlet.annotation.WebInitParam;
import javax.management.ObjectName;
import javax.management.Attribute;
import javax.management.MBeanServerConnection;
import javax.management.remote.JMXServiceURL;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;

@WebServlet(urlPatterns = "/appdepozit",
  initParams = {
    @WebInitParam(name = "jmxServerHost", value = "localhost")
  }
) 
public class DepozitServlet extends HttpServlet {
  MBeanServerConnection cs=null;
  ObjectName mbeanObjectName=null;
  String host;
  String port="1099";
  String server="server";
  
  public void init(ServletConfig config) {
    try {
      super.init(config);
      host=config.getInitParameter("jmxServerHost");
      String surl="service:jmx:rmi:///jndi/rmi://"+host+":"+port+"/"+server;
      //String surl="service:jmx:iiop:///jndi/iiop://"+host+":"+port+"/"+server;
      JMXServiceURL url = new JMXServiceURL(surl);
      JMXConnector jmxc = JMXConnectorFactory.connect(url,null);
      cs = jmxc.getMBeanServerConnection();
      String domain = cs.getDefaultDomain();
      String className="Cont";
      String sObjectName=domain+":type="+className;
      mbeanObjectName = new ObjectName(sObjectName); 
      cs.createMBean(className,mbeanObjectName, null, null); 
    }
    catch(Exception e){
      System.out.println(e.getMessage());
      System.exit(0);
    }
  } 

  public void doGet(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException{
    ServletOutputStream out=res.getOutputStream(); 
    String oper=req.getParameter("oper");
    String message="";
    double suma=0;
    if(!oper.equals("con")){
      String s=req.getParameter("suma");
      suma=Double.parseDouble(s);
    }
    Double objValue=null;
    try{
      objValue=(Double)cs.getAttribute(mbeanObjectName,"Cont"); 
    }
    catch(Exception e){
      message="JMX-Error : "+e.getMessage();
    }
    double value=objValue.doubleValue();
    double x;
    Attribute curs=null;
    switch(oper){
      case "dep":
        x=value+suma;
        curs=new Attribute("Cont", x); 
        try{
          cs.setAttribute(mbeanObjectName,curs); 
          message="S-a depus suma";
        }
        catch(Exception e){
          message="JMX-Error : "+e.getMessage();
        }
        break;
      case "ext":    
        if(value>=suma){
          x=value-suma;
          curs=new Attribute("Cont", x);
          try{ 
            cs.setAttribute(mbeanObjectName,curs); 
            message="S-a extras suma";
          }
          catch(Exception e){
            message="JMX-Error : "+e.getMessage();
          }
        }
        else{
          message="Cererea nu poate fi indeplinita";
        }
        break;
      case "con":
        message="Suma din cont este "+value+" unit.";
        break;   
    }
    res.setContentType("text/html");
    out.println("<html>");
    out.println("<head><title>Depozit</title></head>");
    out.println("<body>");
    out.println("<h1>Operatiuni Cont</h1>");
    out.println("<p>");
    out.println( message);
    out.println("</p>");
    out.println("</body></html>");
    out.close();
  }

  public void doPost(HttpServletRequest req,HttpServletResponse res)
     throws ServletException,IOException{
    doGet(req,res);
  }
}
