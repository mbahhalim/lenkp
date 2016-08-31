package com.lenkp.asteriskmonitor.api;

import java.util.List;

import ch.loway.oss.ari4java.generated.Endpoint;

public interface EndpointService {

	/**
	 * @return
	 */
	public List<Endpoint> getEndpoints();
	
}
