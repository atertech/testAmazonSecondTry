package tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class DriverStarter {
    public static WebDriver driver;

    public static WebDriver getDriver() throws IOException {
        Properties properties = new Properties();
        BufferedReader reader = Files.newBufferedReader(Path.of("config.properties"));
        properties.load(reader);
        String driverName = properties.getProperty("driver");
        File file = new File(properties.getProperty("path"));
        System.setProperty(driverName, file.getAbsolutePath());
        driver = new ChromeDriver();
        return driver;
    }
}
