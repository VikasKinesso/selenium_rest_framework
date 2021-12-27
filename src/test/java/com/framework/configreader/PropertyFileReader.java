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
	
	public String getExecutionEnv() {
		return prop.getProperty("ExecutionEnv");
	}
	
	public String getRemoteExecutionEnvURL() {
		return prop.getProperty("RemoteExecutionEnvURL");
	}
	
	public String getReportOverwrite() {
		return prop.getProperty("ReportOverWrite");
	}

	public int getPageLoadTimeOut() {
		return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
	}
	
	public String getWaitTime() {
		String time = prop.getProperty("wait.explicit.seconds");
		if (time != null)
			return time;
		else
			throw new RuntimeException("Time  is  not specified in the Configuration.properties file.");
	
	}

	public int getImplicitWait() {
		return Integer.parseInt(prop.getProperty("ImplcitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(prop.getProperty("ExplicitWait"));
	}
	
	public int getWaitForAnswer() {
		return Integer.parseInt(prop.getProperty("WaitForAnswer"));
	}
	
	
	
	public static String getDownloadsFolder() {
		return prop.getProperty("DownloadsFolder");
	}
	
	
	

}
