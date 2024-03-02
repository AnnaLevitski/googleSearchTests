package pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;


import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static config.ConfigurationReader.getProperty;

public class GooglePage extends LoadableComponent<GooglePage> {

    public GooglePage search(String val){
        $(By.name("q")).setValue(val);
        SelenideElement btn = $(By.name("btnK"));
        if(btn.isDisplayed())
            btn.click();
        $(By.name("q")).pressEnter();
        return this;
    }
    public GooglePage assertTrue(){
        $(By.id("rso")).shouldHave(partialText("Google Assistant"));
        return this;
    }
    public GooglePage assertFalse(){
        $(By.id("rso")).shouldNotHave(partialText("Google Assistant"));
        return this;
    }
    public GooglePage assertResults(){
        ElementsCollection results = $$(".g").shouldHave(sizeGreaterThanOrEqual(10));
        return this;
    }
    @Override
    protected void load() {
        Selenide.open(getProperty("url"));
    }

    @Override
    protected void isLoaded() throws Error {
        $(".RNNXgb").shouldBe(visible);
    }


}
