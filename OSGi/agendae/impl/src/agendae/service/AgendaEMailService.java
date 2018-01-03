package agendae.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;

public class AgendaEMailService implements agendae.IAgendaEMail{
  private Statement instructiune=null;
  private ResultSet rs=null;

  AgendaEMailService(){
    String jdbcDriver="org.apache.derby.jdbc.ClientDriver";
    String URLBazaDate="jdbc:derby://localhost:1527/AgendaEMail";
    Connection conn=null;
    try{
      Class.forName(jdbcDriver).newInstance();
      conn = DriverManager.getConnection(URLBazaDate);
      instructiune=conn.createStatement();
    }
    catch(Exception e){
      System.out.println("Eroare : "+e.getMessage());
    }  
  }
    
  public List<String> getEMails(String name){
    String nume='\''+name+'\'';
    String sql="select email from adrese where nume="+nume; 
    List<String> results=new ArrayList<String>(10);
    try{
      rs=instructiune.executeQuery(sql);   
      if(rs!=null){
        while(rs.next()){
          results.add(rs.getString("email"));
        }
      }
    }
    catch(SQLException e){
      System.out.println("SQL_Ex : "+e.getMessage());
    }
    return results;
  }
  
  public String getName(String email){
    String email0='\''+email+'\'';
    String sql="select nume from adrese where email="+email0;     
    String result="";
    try{
      rs=instructiune.executeQuery(sql);  
      if(rs!=null){
        while(rs.next()){
          result=rs.getString("nume");
        }
      }
    }  
    catch(SQLException e){
      System.out.println("SQL_Ex : "+e.getMessage());
    }
    return result;
  }
}
