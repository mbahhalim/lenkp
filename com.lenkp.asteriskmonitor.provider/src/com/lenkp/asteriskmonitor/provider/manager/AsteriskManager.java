package com.lenkp.asteriskmonitor.provider.manager;

import java.util.logging.Logger;

import ch.loway.oss.ari4java.ARI;
import ch.loway.oss.ari4java.AriFactory;
import ch.loway.oss.ari4java.AriVersion;

public final class AsteriskManager {
	
	public final static Logger LOGGER =
			Logger.getLogger(AsteriskManager.class.getName());
	
	private static ARI ari = null;
	
	public static ARI getAri() {
		if (ari == null) LOGGER.warning("Asterisk connection is null");
		return ari;
	}
	
	public static void createConnection(
			String host,
			String port,
			String username,
			String password) {
		LOGGER.info("Creating a connection to Asterisk");
		try {
			ari = AriFactory.nettyHttp(
					"http://" + host + ":" + port + "/",
					username,
					password,
					AriVersion.ARI_1_9_0);
		} catch (Throwable t) {
			LOGGER.severe("Failed creating connection to Asterisk");
			t.printStackTrace();
		}
	}

}
