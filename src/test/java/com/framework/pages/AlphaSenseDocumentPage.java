package com.framework.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/*******************************************************************************************************
* @author  Vikas Sangwan
* @since   2016-04-15
********************************************************************************************************/

public class AlphaSenseDocumentPage extends PageBase {

	private WebDriver driver;
	//WaitHelper wHelper = new WaitHelper(ObjectRepo.driver, null);
	

	public AlphaSenseDocumentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	/** Web Elements */

	@FindBy(xpath = "//*[@class = ' CodeMirror-line ']")
	@CacheLookup
	public  WebElement AdditionalKeywordSearch;
	
	
	@FindBy(xpath = "(//*[@class = 'snippetItem__content'])[last()]")
	@CacheLookup
	public  WebElement lastResult;
	
	@FindBy(xpath = "(//*[@class = 'snippetItem__content'])[last()]//span/span")
	@CacheLookup
	public  WebElement lastResultStatement;
	
	@FindBy(xpath = "//*[contains(@class, 'x-grid3-row-blue')]//parent::p")
	@CacheLookup
	public  WebElement documentHighlightedStatement;
	
	@FindBy(id = "content-1")
	@CacheLookup
	public  WebElement documentFrame;
	
	/** CSS selectors for javascript  **/
	public String txtAdditionalKeywordSearch = ".CodeMirror-line > span";
	public String resultsSection = "[aria-label='grid']";
	
	
	
	public void validatePageTitle(String title) {
		Assert.assertEquals(driver.getTitle(), title);
	}
	
	public void searchAdditionalKeyword(String keyword) throws AWTException{
		StringSelection selection = new StringSelection(keyword);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, selection);
		//JavascriptExecutor js = (JavascriptExecutor)ObjectRepo.driver;
		AdditionalKeywordSearch.click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		//String jsQuery = "document.querySelector(\""+txtAdditionalKeywordSearch+"\").innerText = '"+keyword+"';";
		//js.executeScript(jsQuery);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void scrolleResultsToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String jsQuery = "document.querySelector(\""+resultsSection+"\").scrollTop = document.querySelector(\""+resultsSection+"\").scrollHeight;";
		js.executeScript(jsQuery);
	}
	
	
}
