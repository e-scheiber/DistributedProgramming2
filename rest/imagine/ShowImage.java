
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.net.*;

class MyCanvas extends Canvas{
  Image image=null;
  
  MyCanvas(Image image){
    this.image=image;
  }

  public void paint(Graphics g){
    g.drawImage(image,0,0,this);
  }
}

public class ShowImage{
  MyCanvas mc=null;
  
  ShowImage(Image image){
    mc=new MyCanvas(image);
  }
  
  public void show(){
  // Interfata swing
    JFrame jframe = new JFrame("The received image");
    jframe.addNotify();
    jframe.getContentPane().setLayout(new BorderLayout()); 
    jframe.getContentPane().add(mc,BorderLayout.CENTER);
    jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
    jframe.setSize(600,600);
    jframe.setVisible(true);
  }    
}
