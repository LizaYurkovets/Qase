package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage {

    private static final String CREATE_NEW_CASE = "Create new case";

    public void waitTillOpened() {
        $x("//button/span[text() = 'Create new suite']").shouldBe(Condition.visible);
    }

    public void clickCreateCase() {
        $(byText(CREATE_NEW_CASE)).click();
    }
}