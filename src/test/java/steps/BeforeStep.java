package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;

public class BeforeStep {
    @Given("open {string}")
    public void open(String link) {
        Configuration.timeout = 50000;
        Selenide.open(link);
    }
}
