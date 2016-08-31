package com.lenkp.asteriskmonitor.api;

import java.util.List;

import ch.loway.oss.ari4java.generated.Bridge;

public interface BridgeService {

	/**
	 * @return
	 */
	public List<Bridge> getBridges();
	
}
