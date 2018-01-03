import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
// import java.text.DateFormat;
import java.net.*;
//import org.apache.derby.drda.NetworkServerControl;

public class AgendaEMailServlet extends HttpServlet {
  Statement instructiune=null;

  public void init(ServletConfig config) throws ServletException{
    super.init(config);
    // SGBD Derby
    String jdbcDriver="org.apache.derby.jdbc.ClientDriver";
    String URLBazaDate="jdbc:derby://localhost:1527/AgendaEMail";
    // SGBD Mysql
    /*
    String jdbcDriver="com.mysql.jdbc.Driver";
    String URLBazaDate="jdbc:mysql://localhost:3306/AgendaEMail?user=root";
    */
    // SGBD Access
    /*
    String jdbcDriver="sun.jdbc.odbc.JdbcOdbcDriver";
    String URLBazaDate="jdbc:odbc:AgendaEMail";
    */
    Connection con=null;
    try{
      Class.forName(jdbcDriver).newInstance();
      con=DriverManager.getConnection(URLBazaDate);
      instructiune=con.createStatement();
    }
    catch(ClassNotFoundException e){
      System.out.println("Driver inexistent JDBC: "+jdbcDriver);
    }
    catch(SQLException e){
      System.out.println("Baza de date inexistenta "+URLBazaDate);
    }
    catch(Exception e){
      System.out.println("Eroare : "+e.getMessage());
    }    
  }   

  public void doGet(HttpServletRequest req,HttpServletResponse res)
     throws ServletException,IOException{
    String myAtribut,myVal;
    res.setContentType("text/html");
    ServletOutputStream out = res.getOutputStream();
   
    myAtribut=req.getParameter("criteriu");
    myVal=req.getParameter("termen");
    myVal='\''+myVal+'\'';
    try{
      String sql="select * from adrese where "+ myAtribut+" = "+myVal;
      ResultSet rs=instructiune.executeQuery(sql);
      out.println("<html>");
      out.println("<head><title>AgendaEMail</title></head>");
      out.println("<body>");
      out.println("<h1>Agenda de Adrese e-mail </h1>");
      out.println("<p/>"); 
      out.println("<b>    Nume    <-->    Adresa e-mail  </b>");
      out.println("<br/>");
      while(rs.next()){
        out.print(rs.getString("nume")+" <--> "+rs.getString("email"));
        out.println("<br/>");
      }
      out.println("</body>");
      out.println("</html>");
      out.close();
    }
    catch(SQLException e){
      System.out.println("SQLException: "+e.getMessage());
    }
    catch(Exception e){
      System.out.println("Eroare : "+e.getMessage());
    }    
  }

  public void doPost(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException{
    doGet(req,res);
  }
}
