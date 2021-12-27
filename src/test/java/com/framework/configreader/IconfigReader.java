package com.framework.configreader;

/*******************************************************************************************************
* @author  Vikas Sangwan
* @since   2016-04-15
********************************************************************************************************/


 public interface IconfigReader {
	 
	public String getWebsite();
	public int getPageLoadTimeOut();
	public int getImplicitWait();
	public int getExplicitWait();
	public String getRemoteExecutionEnvURL();
	public String getBrowser();
	public String getBaseURI();
	
}
 