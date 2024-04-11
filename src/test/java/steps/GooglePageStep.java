package steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.testng.asserts.Assertion;

import java.util.function.BooleanSupplier;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.partialText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GooglePageStep {
    private final SelenideElement inputSearch = $(By.name("q"));
    private final SelenideElement buttonSearch = $(By.name("btnK"));
    private final SelenideElement resultItem = $(By.id("rso"));
    private final ElementsCollection resultsList = $$(".g");

    @When("Enter the search {string}")
    public void enterTheSearch(String str) {
        inputSearch.setValue(str);
    }

    @And("Press the search button")
    public void pressTheSearchButton() {
        if(buttonSearch.isDisplayed())
            buttonSearch.click();
        inputSearch.pressEnter();
    }

    @Then("Checking the results contains {string}")
    public void checkingTheResultsContains(String str) {
        resultItem.shouldHave(partialText(str));
    }

    @Then("Checking that the number of search results is greater than {int}")
    public void checkingThatTheNumberOfSearchResultsIsGreaterThan(int num) {
        System.out.println(resultsList.size());
        resultsList.shouldHave(sizeGreaterThanOrEqual(num));
        Assertions.assertTrue( resultsList.size()> num,
                "The size of results list was smaller "+num);
    }
}
