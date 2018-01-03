import java.io.InputStream;
import java.io.BufferedInputStream;
import javazoom.jl.player.Player;

public class MP3Player extends Thread{
  private Player player; 
  
  public MP3Player(InputStream is) {
    try {
      BufferedInputStream bis=new BufferedInputStream(is);
      player=new Player(bis);
    }
    catch(Exception e){
      System.out.println(e.getMessage());
      System.exit(1);
    }
  }
 
  public void run(){
    try{
      player.play();
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
    if (player != null) player.close(); 
  }
} 
