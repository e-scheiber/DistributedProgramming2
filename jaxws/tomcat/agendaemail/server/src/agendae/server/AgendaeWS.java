package agendae.server;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

@WebService()
public class AgendaeWS {
  private static Connection conn=null;

  static{
    String driver="org.apache.derby.jdbc.ClientDriver";
    String dbURI="jdbc:derby://localhost:1527/AgendaEMail";
    try{
      Class.forName(driver).newInstance();
      conn = DriverManager.getConnection(dbURI);
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }

  @WebMethod
  public List<String> getEmailAddresses(@WebParam(name = "nume") String nume) {
    List<String> lst=new ArrayList(10);
    try{
      String sql="select email from adrese where nume=?";
      PreparedStatement ps=conn.prepareStatement(sql);
      ps.setString(1,nume);
      ResultSet rs=ps.executeQuery();
      if(rs!=null){
        System.out.println("S-au gasit adresele de e-mail:");
        while(rs.next()){
          lst.add(rs.getString("email"));
          System.out.println(rs.getString("email"));
        }
      }
    }
    catch(Exception e){
      e.printStackTrace();
    }  
    return lst;
  }
}
