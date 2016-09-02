package com.lenkp.asteriskmonitor.service;

import java.util.List;
import java.util.logging.Logger;

import com.lenkp.asteriskmonitor.manager.AsteriskManager;

import ch.loway.oss.ari4java.generated.Bridge;
import ch.loway.oss.ari4java.tools.RestException;

public interface BridgeService {

	/**
	 * @return a list of bridge fetched from Asterisk
	 */
	public List<Bridge> getBridges();
	
}

class BridgeServiceImpl implements BridgeService {

	public final static Logger LOGGER =
			Logger.getLogger(BridgeServiceImpl.class.getName());
	
	/* (non-Javadoc)
	 * @see com.lenkp.asteriskmonitor.service.BridgeService#getBridges()
	 */
	@Override
	public List<Bridge> getBridges() {
		LOGGER.info("Fetching bridges from Asterisk");
		try {
			return AsteriskManager.getAri().bridges().list();
		} catch (RestException e) {
			LOGGER.severe("Failed fetching bridges from Asterisk");
			e.printStackTrace();
			return null;
		}
	}
	
}
