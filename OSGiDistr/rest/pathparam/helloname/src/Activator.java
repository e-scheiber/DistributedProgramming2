package resources;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private ServiceRegistration<HelloResource> registration;

	public void start(BundleContext bundleContext) throws Exception {
		registration = bundleContext.registerService(HelloResource.class, new HelloResource(), null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		registration.unregister();
	}

}