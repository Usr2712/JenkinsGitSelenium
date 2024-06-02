package ConfigReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigSetup {
     Properties properties;

    /**
     * This method is used to load the properties from config.properties file
     */
    public Properties propload() {

        properties = new Properties();
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\DELL\\Sai\\Ecommerce_Testing\\src\\test\\resources\\properties\\config.properties");
            properties.load(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;

    }



}
