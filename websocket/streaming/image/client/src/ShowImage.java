import java.awt.Canvas;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.BorderLayout;
import javax.swing.JFrame;

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
  Image image=null;
  MyCanvas mc=null;

  ShowImage(Image image){
    this.image=image;
    mc=new MyCanvas(image);
  }

  public void show(){
    // Interfata swing
    JFrame jframe = new JFrame("The received image");
    jframe.addNotify();
    jframe.getContentPane().setLayout(new BorderLayout()); 
    jframe.getContentPane().add(mc,BorderLayout.CENTER);
    jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
    jframe.setSize(200,200);
    jframe.setVisible(true);
  }
}
