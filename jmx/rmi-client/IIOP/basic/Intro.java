package basic;

public class Intro implements IntroMBean {

  //Atribute
  private final String label = "Fac. Matematica si Informatica";
  private double cursEuro = 4.50;

  public String getLabel() {
    return label;
  }

  public double getCursEuro() {
    return cursEuro;
  }

  public synchronized void setCursEuro(double cursEuro) {
    this.cursEuro = cursEuro;
  }
  
  //Operatii
  public String sayHello() {
    String message="Hello World !";
    System.out.println(message);
    return message;
  }

  public long cmmdc(long m,long n){   
    long r,c;
    do{
      c=n;
      r=m%n;
      m=n;
      n=r;
    }
    while(r!=0);
    return c;
  }
}
