package com.framework.StepDefinition;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.browserconfig.BrowserType;
import com.framework.browserconfig.InitializeWebDriver;
import com.framework.elementhelper.GenericElements;
import com.framework.pages.AlphaSenseDocumentPage;
import com.framework.settings.ObjectRepo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Document_Steps extends InitializeWebDriver {
	AlphaSenseDocumentPage DOCUMENT;
	
	@Given("I am on Alpha Sense Document page")
	public void i_am_on_alpha_sense_document_page() {
		try {
		    setUpDriver(BrowserType.Chrome);
			ObjectRepo.driver.get(ObjectRepo.url);
		}catch(Exception e) {
			JavascriptExecutor js = (JavascriptExecutor)ObjectRepo.driver;
			js.executeScript("window.stop();");
		}
		DOCUMENT = new AlphaSenseDocumentPage(ObjectRepo.driver);
		DOCUMENT.validatePageTitle("AlphaSense");
	}

	@When("I search for additional keyword {string}")
	public void i_search_for_additional_keyword(String keyword) throws InterruptedException, AWTException {
		DOCUMENT.searchAdditionalKeyword(keyword);
	}

	@When("I click on the last found result")
	public void i_click_on_the_last_found_result() {
		WebDriverWait wait = new WebDriverWait(ObjectRepo.driver, ObjectRepo.reader.getExplicitWait());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DOCUMENT.resultsSection)));
		DOCUMENT.scrolleResultsToBottom();
		DOCUMENT.lastResult.click();
	}

	@Then("I should see the chosen statement is highligted in the document viewer")
	public void i_should_see_the_chosen_statement_is_highligted_in_the_document_viewer() {
		String highlightText = DOCUMENT.lastResult.getText();
		ObjectRepo.driver.switchTo().frame(DOCUMENT.documentFrame);
		String CheckText = DOCUMENT.documentHighlightedStatement.getText();
		Assert.assertEquals(highlightText.trim(), CheckText.trim());
	}

}
