import java.net.URL;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Client{
  public static void main(String args[]){
    System.out.println("Rezultat / \'text/plain\'");
    String urlStr="http://localhost:8080/HelloWorld/resources/helloworld";
    try{
      String rezultat=httpGetText(urlStr);
      System.out.println(rezultat);
    }
    catch(Exception e){
      System.out.println("Exception message : "+e.getMessage());
    }
    System.out.println();
    
    System.out.println("Rezultat / \'text/html\'");
    urlStr="http://localhost:8080/HelloWorld/resources/helloworld/html";
    try{
      String rezultat=httpGetText(urlStr);
      System.out.println(rezultat);
    }
    catch(Exception e){
      System.out.println("Exception message : "+e.getMessage());
    }
    System.out.println();
    
    System.out.println("Rezultat / \'application/xml\'");
    urlStr="http://localhost:8080/HelloWorld/resources/helloworld/xml";
    try{
      String rezultat=httpGetText(urlStr);
      System.out.println(rezultat);
    }
    catch(Exception e){
      System.out.println("Exception message : "+e.getMessage());
    }
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
