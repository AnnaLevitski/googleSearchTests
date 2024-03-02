package ui;

import org.testng.annotations.Test;
import pages.GooglePage;



public class GooglePageTest extends BaseTest{

    @Test
    public void searchTest_success() {
        new GooglePage().search("ok google").assertTrue().assertResults();
    }
    @Test
    public void searchTest_negative() {
        new GooglePage().search("-_-").assertFalse().assertResults();

    }
}
