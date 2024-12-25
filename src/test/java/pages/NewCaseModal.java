package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import wrappers.Dropdown;
import wrappers.Input;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class NewCaseModal {

    private static final String SAVE_BUTTON = "Save";
    private static final SelenideElement DELETE_BUTTON =  $x("//button/span[text()=' Delete']");

    public void createCase() {
        new Input("title").write("Test case");
        new Dropdown("Status").select("Draft");
        new Dropdown("Severity").select("Major");
        new Dropdown("Priority").select("Low");
        new Dropdown("Type").select("Smoke");
        new Dropdown("Layer").select("API");
        new Dropdown("Is flaky").select("Yes");
        new Dropdown("Behavior").select("Positive");
        new Dropdown("Automation status").select("Automated");
    }

    public void clickSaveButton() {
        $(byText(SAVE_BUTTON)).click();
    }

    public void isCaseCreated() {
        DELETE_BUTTON.shouldBe(Condition.exist);
    }
}
