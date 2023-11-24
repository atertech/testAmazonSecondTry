package com.demo.core.base;

import com.codeborne.selenide.Selenide;
import com.demo.core.allure.AllureLogger;
import com.demo.core.config.SelenideConfig;
import com.demo.core.utils.Constants;
import com.demo.core.utils.SelenideTools;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
//public class BaseTest extends AllureLogger {
public class BaseTest{

    @BeforeClass(alwaysRun = true, description = "Opening web browser...")
    public void setUp() {
        //logInfo("Creating web driver configuration...");
        Selenide.open("https://www.amazon.com/");
        SelenideTools.getDriver();
        SelenideConfig.createBrowserConfig(System.getProperty("selenide.browser", "chrome"));
        //configLog(this.getClass().getSimpleName());

        //logInfo("Open browser...");
    }

    /*@AfterMethod(alwaysRun = true, description = "Closing web browser...")
    public void tearDown() {
        Selenide.closeWebDriver();
        //logInfo("Web driver closed!");
    }*/
}
