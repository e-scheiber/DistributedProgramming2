import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class Client{
  public static void main(String args[]){
    Scanner scanner=new Scanner(System.in);
    try{
      String param="?";
      System.out.println("Primul numar");
      String m=URLEncoder.encode(scanner.next(),"UTF-8");
      param=param+"m="+m+"&"; 
      System.out.println("Al doilea numar");
      String n=URLEncoder.encode(scanner.next(),"UTF-8");
      param=param+"n="+n+"&"; 
      param=param+"tip="+URLEncoder.encode("text/plain","UTF-8");      
      String urlStr="http://localhost:8080/Cmmdc/resources/cmmdcquery"+param;
      System.out.println(urlStr);
      String rezultat=httpGetText(urlStr);
      System.out.println("Cmmdc = "+rezultat);
    }
    catch(Exception e){
      System.out.println("ErrorMessage : "+e.getMessage());
    }
    System.out.println();
  }  
    
  public static String httpGetText(String urlStr) throws IOException {
    URL url=new URL(urlStr);
    HttpURLConnection conn=(HttpURLConnection) url.openConnection();
  
    if (conn.getResponseCode() != 200) {
      throw new IOException(conn.getResponseMessage());
    }
  
    // Buffer the result into a string
    BufferedReader rd = new BufferedReader(
        new InputStreamReader(conn.getInputStream()));
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = rd.readLine()) != null) {
      sb.append(line+"\n");
    }
    rd.close();
  
    conn.disconnect();
    return sb.toString();
  }
}
