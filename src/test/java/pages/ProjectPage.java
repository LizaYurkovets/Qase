package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {

    private static final String CASE_BUTTON = "Case",
            SUITE_BUTTON = "Suite";



    public void waitTillOpened() {
        $(byText(SUITE_BUTTON)).shouldBe(Condition.visible);
    }

    public void clickCreateCase() {
        $(byText(CASE_BUTTON)).click();
    }

    public void clickCreateSuite() {
        $(byText(SUITE_BUTTON)).click();
    }
}