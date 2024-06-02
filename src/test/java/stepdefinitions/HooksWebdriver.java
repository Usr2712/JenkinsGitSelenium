package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static DriverFactory.DriverInitialization.driver;

public class HooksWebdriver {


    @Before
    public void log4j(){

        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        File file = new File("C:/Users/DELL/Sai/Ecommerce_Testing/src/test/resources/properties/log42j.xml");
        context.setConfigLocation(file.toURI());


    }

    @After(order = 1)
    public void addScreenshot(Scenario scenario) throws IOException {

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
        scenario.attach(fileContent, "image/png", "screenshot");

    }

    @After(order = 2)
    public void takeScraenshotOnFailure(Scenario scenario) throws IOException {

        if (scenario.isFailed()) {

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
            scenario.attach(fileContent, "image/png", "screenshot");
        }
    }

    @After(order = 0)
    public void QuitBrowser() {

        driver.quit();


    }

}
