package com.city.promall.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class ClientIPUtils
{

	private static Logger logger = Logger.getLogger(ClientIPUtils.class);
	
	public static String getClientIp(HttpServletRequest request) {

        String ip = request.getHeader("x-forwarded-for");

        //String ip = request.getHeader("X-real-ip");

         logger.debug("x-forwarded-for = {}");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP"); 
            logger.debug("Proxy-Client-IP = {}"); 
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            logger.debug("WL-Proxy-Client-IP = {}");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            logger.debug("RemoteAddr-IP = {}"); 
        }
        if(ip!=null) {
            ip = ip.split(",")[0];
        }
        return ip;

    }
}
