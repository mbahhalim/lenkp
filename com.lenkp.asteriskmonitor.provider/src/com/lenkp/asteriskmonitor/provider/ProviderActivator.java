package com.lenkp.asteriskmonitor.provider;

import java.util.logging.Logger;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.lenkp.asteriskmonitor.api.BridgeService;
import com.lenkp.asteriskmonitor.api.ChannelService;
import com.lenkp.asteriskmonitor.api.EndpointService;
import com.lenkp.asteriskmonitor.provider.manager.AsteriskManager;
import com.lenkp.asteriskmonitor.provider.service.BridgeServiceImpl;
import com.lenkp.asteriskmonitor.provider.service.ChannelServiceImpl;
import com.lenkp.asteriskmonitor.provider.service.EndpointServiceImpl;

public class ProviderActivator implements BundleActivator {
	
	public final static Logger LOGGER =
			Logger.getLogger(ProviderActivator.class.getName());
	
	@SuppressWarnings("rawtypes")
	private static ServiceRegistration bridgeServiceRegistration;
	@SuppressWarnings("rawtypes")
	private static ServiceRegistration channelServiceRegistration;
	@SuppressWarnings("rawtypes")
	private static ServiceRegistration endpointServiceRegistration;

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		LOGGER.info("Starting provider bundle");
		AsteriskManager.createConnection(
				"127.0.0.1",
				"8088",
				"mbahhalim",
				"wasd");
		
		BridgeService bridgeService = new BridgeServiceImpl();
		ChannelService channelService = new ChannelServiceImpl();
		EndpointService endpointService = new EndpointServiceImpl();
		
		LOGGER.info("Registring service for bridge");
		bridgeServiceRegistration =
				bundleContext.registerService(
						BridgeService.class.getName(),
						bridgeService,
						null);
		LOGGER.info("Registring service for channel");
		channelServiceRegistration =
				bundleContext.registerService(
						ChannelService.class.getName(),
						channelService,
						null);
		LOGGER.info("Registring service for endpoint");
		endpointServiceRegistration =
				bundleContext.registerService(
						EndpointService.class.getName(),
						endpointService,
						null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		LOGGER.info("Unregistring service for bridge");
		bridgeServiceRegistration.unregister();
		LOGGER.info("Unregistring service for channel");
		channelServiceRegistration.unregister();
		LOGGER.info("Unregistring service for endpoint");
		endpointServiceRegistration.unregister();
		
		LOGGER.info("Stopping provider bundle");
	}

}
