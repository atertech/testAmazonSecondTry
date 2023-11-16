package tests;

import org.testng.annotations.AfterClass;

import static tools.DriverStarter.driver;

public class BaseTest {
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
