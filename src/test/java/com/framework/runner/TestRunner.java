package com.framework.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        monochrome = true,
        features = "src/test/resources/features",
        glue = "com.framework.StepDefinition",
//        tags = "@UI",
        plugin = {
                "pretty",
                "html:target/cucumber-reports",
                "json:target/cucumber.json",
        }
)

// mvn verify -Dcucumber.filter.tags="@API"

public class TestRunner extends AbstractTestNGCucumberTests {
	
}
