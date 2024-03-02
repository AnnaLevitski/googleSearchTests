package ui;



import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.*;
import static config.ConfigurationReader.getProperty;

public class BaseTest  {
    @BeforeTest
    public void setUp(){
        String browser = System.getProperty("browser", Browser.CHROME.browserName());
        Configuration.browser = browser;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.baseUrl = getProperty("url");
        open(getProperty("url"));
    }
    @AfterSuite
    public void tearDown(){
        Selenide.closeWebDriver();
    }

}
