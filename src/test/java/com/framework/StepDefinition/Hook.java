package com.framework.StepDefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.util.Strings;

import com.framework.browserconfig.BrowserType;
import com.framework.browserconfig.InitializeWebDriver;
import com.framework.configreader.PropertyFileReader;
import com.framework.settings.ObjectRepo;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook extends InitializeWebDriver {
    public static String baseURL = System.getProperty("url");
    Logger logger = LoggerFactory.getLogger(Hook.class);

    @Before
    public void openBrowser() throws Exception {
    	ObjectRepo.reader = new PropertyFileReader();
        if (ObjectRepo.reader.getBrowser().equalsIgnoreCase("firefox")) {
        	 ObjectRepo.browser = BrowserType.Firefox;
        }else if (ObjectRepo.reader.getBrowser().equalsIgnoreCase("remote")) {
       	 ObjectRepo.browser = BrowserType.RemoteChrome;
       }else {
        	// default browser
            ObjectRepo.browser = BrowserType.Chrome;
        }
        if (Strings.isNullOrEmpty(baseURL)) {
            ObjectRepo.url = ObjectRepo.reader.getWebsite();
        }else {
        	ObjectRepo.url = "https://"+baseURL+"/doc/PR-386ea743f2a90399fb0e4300ddf37d0697abc743";
        }
       logger.info("Test Started");
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) ObjectRepo.driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        } finally {
        	if(ObjectRepo.driver!=null)
        		ObjectRepo.driver.quit();
            logger.info("Test Ended");
        }
    }
}
