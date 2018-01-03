package agentn;

public interface IntroNMBean {
    // Operatii
    public String sayHello();
    public long cmmdc(long m, long n);

    // Atribute
    // read-only 
    public String getLabel();
    // read-write 
    public double getCursEuro();
    public void setCursEuro(double cursEuro);
}
