package com.sina.weibo.examples.oauth2;

import org.apache.commons.logging.LogFactory;

public class Log {

	static org.apache.commons.logging.Log log = LogFactory.getLog(Log.class.getName());

    public static void logDebug(String message) {
			log.debug(message);
	}

	public static void logInfo(String message) {
			log.info(message);
	}


}
