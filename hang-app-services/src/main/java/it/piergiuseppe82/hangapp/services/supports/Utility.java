package it.piergiuseppe82.hangapp.services.supports;


public class Utility {
	
	public static String getDataPath(){
		if(System.getenv("OPENSHIFT_DATA_DIR") != null)
			return System.getenv("OPENSHIFT_DATA_DIR");
		else
			return "/home/placava/devel/servers/neo4jHang/data/";
	}
}