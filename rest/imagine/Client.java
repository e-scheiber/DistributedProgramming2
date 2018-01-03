import java.net.URL;
import java.io.IOException;
import java.awt.Image;
import java.awt.Toolkit;

public class Client{
  public static void main(String args[]){
    String urlStr="http://localhost:8080/Imagine/resources/imagine";
    try{
      Image image=httpGetImage(urlStr);
      ShowImage s=new ShowImage(image);
      s.show();
    }
    catch(Exception e){
      System.out.println("Exception message : "+e.getMessage());
    }
  }
    
  public static Image httpGetImage(String urlStr) throws IOException {
    URL url=new URL(urlStr);
    Image image=Toolkit.getDefaultToolkit().getImage(url);
    return image;
  }
}
