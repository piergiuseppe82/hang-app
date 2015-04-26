package it.piergiuseppe82.hangapp.services.supports;

import java.io.File;
import java.security.MessageDigest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class Utility {
	private static final Log log = LogFactory.getLog(Utility.class);

	public static String getDataPath(){
		if(System.getenv("OPENSHIFT_DATA_DIR") != null)
			return System.getenv("OPENSHIFT_DATA_DIR");
		else
			return System.getProperty("user.home")+File.separator;
	}
	
	
	public static String passwordEncode(String password){
			try {
			 return	new String(MessageDigest.getInstance("MD5").digest(password.getBytes()));
			} catch (Throwable e) {
				log.error("Error during encoding",e);
			}
			return null;
		
	}
}
