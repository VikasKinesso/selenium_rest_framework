
package com.framework.settings;

import org.openqa.selenium.WebDriver;

import com.framework.browserconfig.BrowserType;
import com.framework.configreader.IconfigReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/*******************************************************************************************************
* @author  Vikas Sangwan
* @since   2016-04-15
********************************************************************************************************/

public class ObjectRepo {
	public static WebDriver driver;
	public static IconfigReader reader;
	public static String url;
	public static BrowserType browser;
}

