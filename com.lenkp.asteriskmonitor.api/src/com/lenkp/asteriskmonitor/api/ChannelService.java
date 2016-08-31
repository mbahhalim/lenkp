package com.lenkp.asteriskmonitor.api;

import java.util.List;

import ch.loway.oss.ari4java.generated.Channel;

public interface ChannelService {

	/**
	 * @return
	 */
	public List<Channel> getChannels();
	
}
