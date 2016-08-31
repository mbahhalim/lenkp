package com.lenkp.asteriskmonitor.provider.service;

import java.util.List;
import java.util.logging.Logger;

import com.lenkp.asteriskmonitor.api.ChannelService;
import com.lenkp.asteriskmonitor.provider.manager.AsteriskManager;

import ch.loway.oss.ari4java.generated.Channel;
import ch.loway.oss.ari4java.tools.RestException;

public class ChannelServiceImpl implements ChannelService {

	public final static Logger LOGGER =
			Logger.getLogger(ChannelServiceImpl.class.getName());
	
	/* (non-Javadoc)
	 * @see com.lenkp.asteriskmonitor.api.ChannelService#getChannels()
	 */
	@Override
	public List<Channel> getChannels() {
		LOGGER.info("Fetching channels from Asterisk");
		try {
			return AsteriskManager.getAri().channels().list();
		} catch (RestException e) {
			LOGGER.severe("Failed fetching channels from Asterisk");
			e.printStackTrace();
			return null;
		}
	}

}
