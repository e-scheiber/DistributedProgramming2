package resources;
import java.net.URL;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.activation.DataSource;
import javax.activation.FileDataSource; 

@Path("imagine")
public class ImageResource {

  public ImageResource() {}
  
  @GET
  @Produces("image/jpg")
  public DataSource getImageRep() {
        URL jpgURL = this.getClass().getResource("forest.jpg");
        return new FileDataSource(jpgURL.getFile()); 
  } 
}