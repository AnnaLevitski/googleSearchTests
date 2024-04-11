package steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;

public class AfterStep {
    @After
    public void tearDown(){
        Selenide.screenshot("step"+System.currentTimeMillis());
        Selenide.closeWebDriver();
    }

}
