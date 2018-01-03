import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.CloseableHttpClient; 
import org.apache.http.impl.client.DefaultHttpClient; 
import org.apache.http.client.HttpClient; 
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import org.apache.http.NameValuePair; 
import org.apache.http.message.BasicNameValuePair; 

import org.apache.http.client.entity.UrlEncodedFormEntity;
import java.io.*;

public class Client{
  private static String uri="http://localhost:8080/Hello/resources/hello";
  
  public static void main(String[] args) {  
    Scanner scanner=new Scanner(System.in);
    System.out.println("Numele");
    String nume=scanner.nextLine().trim();
   
    //CloseableHttpClient httpclient = HttpClients.createDefault();
    HttpClient client = new DefaultHttpClient();
    List<NameValuePair> qparams = new ArrayList<NameValuePair>();
    qparams.add(new BasicNameValuePair("nume", nume));
    qparams.add(new BasicNameValuePair("tip", "text/plain"));
    try{
      UrlEncodedFormEntity params = new UrlEncodedFormEntity(qparams, "UTF-8");
      HttpPost httppost=new HttpPost(uri);
      httppost.setEntity(params);
      HttpResponse response=client.execute(httppost);
      HttpEntity entity=response.getEntity();
      if(entity!=null){
        InputStream is=entity.getContent();
        int l;
        byte[] tmp=new byte[2048];
        while((l=is.read(tmp))!=-1){}
        System.out.println((new String(tmp).trim()));
      }		
    }
    catch(Exception e){
      System.out.println("Exception : "+e.getMessage());
    }
  }
}
