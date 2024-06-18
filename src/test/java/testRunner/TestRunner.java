package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"features"}
    ,glue = {"steps"}
//	,plugin = {"pretty","html:report1","json:report2","junit:report3"
	,plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","html:target/cucumber-html-report"}
	
	,strict=true
	,dryRun = false
	,monochrome = true
	,tags = "@Smoke"
//	,name = {" valid credential"}
		)
public class TestRunner {
	

}
