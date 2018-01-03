package unitbv.cs.td.server;
import unitbv.cs.td.client.*;
import java.util.*;
import java.sql.*;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class AdreseServiceImpl extends RemoteServiceServlet implements AdreseService{  
  public static final String DRIVER="org.apache.derby.jdbc.ClientDriver";
  public static final String PROTOCOL="jdbc:derby://localhost:1527/AgendaEMail";
  
  public List<String> getEMail(String nume){
    List<String> adrese;
    try {
      Class.forName(DRIVER).newInstance();
      Connection con = DriverManager.getConnection(PROTOCOL);
      Statement s = con.createStatement();
      ResultSet rs = s.executeQuery("SELECT email FROM adrese where nume=\'"+nume+"\'");
      adrese=new ArrayList<String>();
      while(rs.next()){
        adrese.add(rs.getString("email"));
      }
    } 
    catch (Exception e) {
      e.printStackTrace();
      adrese=null;
    }
    finally {
      try {
        DriverManager.getConnection("jdbc:derby:;shutdown=true");
      } 
      catch (SQLException ignore) {}
    }
    return adrese;
  }
  
  public String getNume(String email) {
    String nume="";
    try {
      //Class.forName(DRIVER).newInstance();
      Connection con = DriverManager.getConnection(PROTOCOL);
      Statement s = con.createStatement();
      ResultSet rs = s.executeQuery("SELECT nume FROM adrese where email=\'"+email+"\'");
      if(rs.next())
        nume=rs.getString("nume");
    } 
    catch (Exception e) {
      e.printStackTrace();
      nume=null;
    }
    finally {
      try {
        DriverManager.getConnection("jdbc:derby:;shutdown=true");
      } 
      catch (SQLException ignore) {}
    }
    return nume;  
  }
}
