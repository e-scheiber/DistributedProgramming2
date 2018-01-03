package websocket.cmmdc;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

public class MyApplicationConfig implements ServerApplicationConfig {

  @Override
  public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> set) {
    return new HashSet<ServerEndpointConfig>() {
      {
        add(ServerEndpointConfig.Builder
          .create(CmmdcWebSocketEndpoint.class, "/cmmdc")
          .build());
      }
    };
  }

  @Override
  public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> set) {
    return Collections.emptySet();
  }
}
