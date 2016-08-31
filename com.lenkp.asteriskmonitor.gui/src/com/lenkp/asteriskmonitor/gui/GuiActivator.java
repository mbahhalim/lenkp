package com.lenkp.asteriskmonitor.gui;

import java.util.logging.Logger;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.lenkp.asteriskmonitor.api.BridgeService;
import com.lenkp.asteriskmonitor.api.ChannelService;
import com.lenkp.asteriskmonitor.api.EndpointService;
import com.lenkp.asteriskmonitor.gui.frame.Main;

public class GuiActivator implements BundleActivator {

	public final static Logger LOGGER =
			Logger.getLogger(GuiActivator.class.getName());
	
	private static BridgeService bridgeService;
	private static ChannelService channelService;
	private static EndpointService endpointService;
	
	@SuppressWarnings("rawtypes")
	private static ServiceReference bridgeServiceReference;
	@SuppressWarnings("rawtypes")
	private static ServiceReference channelServiceReference;
	@SuppressWarnings("rawtypes")
	private static ServiceReference endpointServiceReference;

	/**
	 * @return a bridge service
	 */
	public static BridgeService getBridgeService() {
		return bridgeService;
	}

	/**
	 * @return a channel service
	 */
	public static ChannelService getChannelService() {
		return channelService;
	}

	/**
	 * @return a endpoint service
	 */
	public static EndpointService getEndpointService() {
		return endpointService;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@SuppressWarnings("unchecked")
	public void start(BundleContext bundleContext) throws Exception {
		LOGGER.info("Starting gui bundle");
		
		LOGGER.info("Fetching service for bridge");
		bridgeServiceReference =
				bundleContext.getServiceReference(BridgeService.class.getName());
		bridgeService =
				(BridgeService) bundleContext.getService(
						bridgeServiceReference);
		
		LOGGER.info("Fetching service for channel");
		channelServiceReference =
				bundleContext.getServiceReference(ChannelService.class.getName());
		channelService =
				(ChannelService) bundleContext.getService(
						channelServiceReference);
		
		LOGGER.info("Fetching service for endpoint");
		endpointServiceReference =
				bundleContext.getServiceReference(EndpointService.class.getName());
		endpointService =
				(EndpointService) bundleContext.getService(
						endpointServiceReference);
		
		Main.main();
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		bundleContext.ungetService(bridgeServiceReference);
		bundleContext.ungetService(channelServiceReference);
		bundleContext.ungetService(endpointServiceReference);

		LOGGER.info("Stopping provider bundle");
	}

}
