package server;
import java.net.*;
import java.io.*;

public class AppThread extends Thread{
  Socket socket=null;

  public AppThread(Socket socket){
    this.socket=socket;
  }

  public void run(){
    try{
      DataOutputStream out = new DataOutputStream(
         socket.getOutputStream());
      DataInputStream in = new DataInputStream(
         socket.getInputStream());
    
      long m=0,n=0,r;
      App app=new App();
    
      m=in.readLong();
      n=in.readLong();
      r=app.cmmdc(m,n);
      out.writeLong(r);
      out.close();
      in.close();
      socket.close();
    }
    catch(IOException e){
       System.err.println("Server comunication error : "+e.getMessage());
    }  
  }
}
