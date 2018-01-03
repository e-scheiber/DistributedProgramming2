package resources;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private ServiceRegistration<CmmdcResource> registration;

	public void start(BundleContext bundleContext) throws Exception {
		registration = bundleContext.registerService(CmmdcResource.class, new CmmdcResource(), null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		registration.unregister();
	}

}