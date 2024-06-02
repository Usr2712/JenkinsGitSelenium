package Testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src\\test\\resources\\Features\\launchpage.feature",
       glue = {"stepdefinitions"},
        tags = "@Smoke1",
        plugin = { "pretty", "json:target/cucumber-reports/cucumber.json",
                "html:target/cucumber-reports/cucumberreport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        ,monochrome = true

)

public class MyTestRunner extends AbstractTestNGCucumberTests {
/*
  @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }*/

}



