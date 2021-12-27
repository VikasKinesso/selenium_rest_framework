package com.framework.configreader;


import java.io.FileInputStream;
import java.util.Properties;

/*******************************************************************************************************
* @author  Vikas Sangwan
* @since   2016-04-15
********************************************************************************************************/

public class PropertyFileReader implements IconfigReader {
	
	private static Properties prop = null;

	public PropertyFileReader() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/configfile/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getWebsite() {
		return prop.getProperty("url");
	}
	
	public String getBaseURI() {
		return prop.getProperty("baseURI");
	}
	
	public String getBrowser() {
		return prop.getProperty("browser");
	}
	
	
	public String getRemoteExecutionEnvURL() {
		return prop.getProperty("RemoteExecutionEnvURL");
	}


	public int getPageLoadTimeOut() {
		return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
	}

	public int getImplicitWait() {
		return Integer.parseInt(prop.getProperty("ImplcitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(prop.getProperty("ExplicitWait"));
	}

	
	

}
