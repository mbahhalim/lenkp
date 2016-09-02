package com.lenkp.asteriskmonitor.service;

import java.util.List;
import java.util.logging.Logger;

import com.lenkp.asteriskmonitor.manager.AsteriskManager;

import ch.loway.oss.ari4java.generated.Channel;
import ch.loway.oss.ari4java.tools.RestException;

public interface ChannelService {

	/**
	 * @return a list of channel fetched from Asterisk
	 */
	public List<Channel> getChannels();
	
	/**
	 * Hanging up a channel
	 * 
	 * @param channelId
	 */
	public void hangUpChannel(String channelId);
	
}

class ChannelServiceImpl implements ChannelService {

	public final static Logger LOGGER =
			Logger.getLogger(ChannelServiceImpl.class.getName());
	
	/* (non-Javadoc)
	 * @see com.lenkp.asteriskmonitor.service.ChannelService#getChannels()
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

	/* (non-Javadoc)
	 * @see com.lenkp.asteriskmonitor.service.ChannelService#hangUpChannel(java.lang.String)
	 */
	@Override
	public void hangUpChannel(String channelId) {
		LOGGER.info("Hanging up a channel with id: " + channelId);
		try {
			AsteriskManager.getAri().channels().hangup(channelId, null);
		} catch (RestException e) {
			LOGGER.info("Failed hanging up a channel with id: " + channelId);
			e.printStackTrace();
		}
	}
	
}
