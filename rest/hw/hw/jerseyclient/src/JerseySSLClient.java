package hw;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation; 
//import javax.ws.rs.client.SyncInvoker;
import javax.ws.rs.core.Configuration;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLContext;
import javax.net.ssl.HostnameVerifier;
import org.glassfish.jersey.client.ClientConfig;

public class JerseySSLClient {
  public static void main(String args[]) {
    //Client client = ClientBuilder.newClient();
    ClientConfig clientConfig = new ClientConfig();
    Client client=null;
    try{
      client=initClient(clientConfig);
    }
    catch(Exception e){}
 // ============================================ 
    System.out.println("SSL");
 
    String rootURL="https://localhost:8443/HelloWorld/resources/helloworld"; 
    String response="";
    WebTarget webTarget=null;
    Invocation.Builder invocationBuilder=null;
    //SyncInvoker invocationBuilder=null;
    
    webTarget=client.target(rootURL);
    invocationBuilder=webTarget.request();
    response=invocationBuilder.get(String.class);
    System.out.println("PLAIN TEXT");
    System.out.println(response+"\n");
      
    //webTarget=client.target(rootURL+"/html");
    invocationBuilder=webTarget
      .path("html")
      .request();//(MediaType.TEXT_PLAIN_TYPE);
    response=invocationBuilder.get(String.class);
    System.out.println("HTML");
    System.out.println(response+"\n");
      
    //webTarget=client.target(rootURL+"/xml");
    invocationBuilder=webTarget
      .path("xml")
      .request();//(MediaType.TEXT_PLAIN_TYPE);
    response=invocationBuilder.get(String.class);
    System.out.println("XML");
    System.out.println(response);
  }
  // ================================================
  public static Client initClient(Configuration config) throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext ctx = SSLContext.getInstance("SSL");
        ctx.init(null, certs, new SecureRandom());

        return ClientBuilder.newBuilder()
                .withConfig(config)
                .hostnameVerifier(new TrustAllHostNameVerifier())
                .sslContext(ctx)
                .build();
    }

    static TrustManager[] certs = new TrustManager[]{
            new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType)
                        throws CertificateException {
                }

                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType)
                        throws CertificateException {
                }
            }
    };

    public static class TrustAllHostNameVerifier implements HostnameVerifier {

        public boolean verify(String hostname, SSLSession session) {
            return true;
        }

    }

}
