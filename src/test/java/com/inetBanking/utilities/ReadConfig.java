package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	public ReadConfig() {
		File src=new File("./Configuration//config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
					
		} catch (Exception e) {
			System.out.println("Exeception is"+e.getMessage());
		}
	}
	public String getWebURL() {
		return prop.getProperty("baseURL");
	}
	public String getUserName() {
		return prop.getProperty("userName");
	}
	public String getPassword() {
		return prop.getProperty("password");
	}
	public String getChromePath() {
		return prop.getProperty("chromePath");
	}
	public String getEdgePath() {
		return prop.getProperty("EdgePath");
	}

}
