package com.sr2.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:target/cucumber-html-report","json:target/basicreport.json" }, 
		glue = { "com.sr2.steps" },
		features = { "classpath:featureFiles/"}
		,tags ={"@regression"}
		,monochrome=true
)

public class TestRunner {
	
}
