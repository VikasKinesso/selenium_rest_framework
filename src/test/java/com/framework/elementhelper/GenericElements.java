
package com.framework.elementhelper;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.settings.ObjectRepo;

/*******************************************************************************************************
* @author  Vikas Sangwan
* @since   2020-04-15
********************************************************************************************************/

public class GenericElements extends ObjectRepo {
	
	public static void waitForElementToBeDisplayed(By elementLocator) {
		WebDriverWait wait = new WebDriverWait(ObjectRepo.driver, ObjectRepo.reader.getExplicitWait());
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
	}
	

}
