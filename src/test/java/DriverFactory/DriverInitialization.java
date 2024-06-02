package DriverFactory;

import ConfigReader.ConfigSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

public class DriverInitialization {


    public static WebDriver driver;
   static ConfigSetup configSetup= new ConfigSetup();
   static Properties usr = configSetup.propload();

    public static void   Init_driver(String BrowserName){

        if(BrowserName.equalsIgnoreCase("Chrome")){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe" );
        driver = new ChromeDriver();

        }else
            System.out.println("Edge");


    }

    public static  WebDriver Passbrowser() {

        Init_driver(usr.getProperty("Browser"));

        return driver;
    }


}
