package com.demo.core.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.demo.core.allure.AllureLogger;
import com.demo.core.config.SelenideConfig;
import com.demo.core.utils.Constants;
import com.demo.core.utils.SelenideTools;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import static java.awt.AWTEventMulticaster.add;
import static javax.swing.UIManager.put;

//@Listeners({TestListener.class})
//public class BaseTest extends AllureLogger {
public class BaseTest extends SelenideConfig {

    @BeforeClass(alwaysRun = true, description = "Opening web browser...")
    public void setUp() throws MalformedURLException {
        //logInfo("Creating web driver configuration...");
        //Selenide.open("https://www.amazon.com/");
        //SelenideTools.getDriver();
        //SelenideConfig.createBrowserConfig(System.getProperty("selenide.browser", "chrome"));
        //configLog(this.getClass().getSimpleName());
        //Selenide.open("https://www.amazon.com/");
        //ChromeOptions options = new ChromeOptions();

        createBrowserConfig("chrome");
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.baseUrl = Constants.URL;
        Selenide.open(Configuration.baseUrl);
        Configuration.browserCapabilities.setCapability("enableVNC", true);        ///RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

    }


}

    /*@AfterMethod(alwaysRun = true, description = "Closing web browser...")
    public void tearDown() {
        Selenide.closeWebDriver();
        //logInfo("Web driver closed!");
    }*/

