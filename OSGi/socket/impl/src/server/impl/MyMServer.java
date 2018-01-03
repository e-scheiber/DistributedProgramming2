package server.impl;
import server.AppThread;
import iserver.IMyMServer;
import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class MyMServer implements IMyMServer{
  
  public ServerSocket getServerSocket(int port){
    ServerSocket serverSocket = null;
    try{
      serverSocket = new ServerSocket(port);
    }
    catch (IOException e) {
      System.err.println("Could not listen on port: "+port);
      System.err.println(e.getMessage());
      System.exit(1);
    }
    System.out.println("ServerSocket is ready ...");
    return serverSocket;
  }
  
  public void myAction(ServerSocket serverSocket){
    int NTHREADS=100;
    ExecutorService exec=Executors.newFixedThreadPool(NTHREADS);
    while(true){
      try{
        AppThread obj=new AppThread(serverSocket.accept());
        exec.execute(obj);
      }
      catch(IOException e){
        System.err.println("MyActionException : "+e.getMessage());
      }        
    }
  }
}
