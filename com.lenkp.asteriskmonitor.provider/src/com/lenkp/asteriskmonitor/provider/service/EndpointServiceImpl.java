package com.lenkp.asteriskmonitor.provider.service;

import java.util.List;
import java.util.logging.Logger;

import com.lenkp.asteriskmonitor.api.EndpointService;
import com.lenkp.asteriskmonitor.provider.manager.AsteriskManager;

import ch.loway.oss.ari4java.generated.Endpoint;
import ch.loway.oss.ari4java.tools.RestException;

public class EndpointServiceImpl implements EndpointService {

	public final static Logger LOGGER =
			Logger.getLogger(EndpointServiceImpl.class.getName());
	
	/* (non-Javadoc)
	 * @see com.lenkp.asteriskmonitor.api.EndpointService#getEndpoints()
	 */
	@Override
	public List<Endpoint> getEndpoints() {
		LOGGER.info("Fetching endpoints from Asterisk");
		try {
			return AsteriskManager.getAri().endpoints().list();
		} catch (RestException e) {
			LOGGER.severe("Failed fetching endpoints from Asterisk");
			e.printStackTrace();
			return null;
		}
	}

}
