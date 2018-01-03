package unitbv.cs.td.client;

import unitbv.cs.td.shared.FieldVerifier;
import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class CmmdcClientTest extends GWTTestCase {

  public String getModuleName() {
    return "unitbv.cs.td.CmmdcClientJUnit";
  }
  
  public void testCmmdcService() {
    // Crearea unui obiect de apelare.
    CmmdcServiceAsync cmmdcService = (CmmdcServiceAsync)GWT.create(CmmdcService.class);
    ServiceDefTarget target = (ServiceDefTarget) cmmdcService;
    target.setServiceEntryPoint(GWT.getModuleBaseURL() +"cmmdcclient/cmmdcrpc");
    delayTestFinish(100);

    // Apel server.
    cmmdcService.cmmdc(56,48, new AsyncCallback<Long>() {
      public void onFailure(Throwable caught) {
        fail("Request failure: " + caught.getMessage());
      }

      public void onSuccess(Long result) {
        assertTrue(result.longValue()==8);
        finishTest();
      }
    });
  }
}
