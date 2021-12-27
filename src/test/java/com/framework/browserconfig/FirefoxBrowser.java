
package com.framework.browserconfig;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

/*******************************************************************************************************
* @author  Shafkat Mustafa
* @since   2016-04-15
********************************************************************************************************/

public class FirefoxBrowser {
	
	public Capabilities getFirefoxCapabilities() {
		DesiredCapabilities firefox = DesiredCapabilities.firefox();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);
		firefox.setCapability(FirefoxDriver.PROFILE, profile);
		firefox.setCapability("marionette", true);
		return firefox;
	}
	
	@SuppressWarnings("deprecation")
	public WebDriver getFirefoxDriver(Capabilities cap) {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver(cap);
	}
	


}
