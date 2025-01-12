package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import dto.Case;
import lombok.extern.log4j.Log4j2;
import wrappers.Dropdown;
import wrappers.Input;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class NewCaseModal {

    private static final String SAVE_BUTTON = "Save",
            EDIT_FORM = "Edit test case";
    private static final SelenideElement DELETE_BUTTON = $x("//button/span[text()=' Delete']"),
            ADD_STEP_BUTTON = $x("//button//span[text() = ' Add step']"),
            MESSAGE_TEXT = $x("//span[text()='Test case was created successfully!']"),
            CONFIRM_DELETE = $x("//button//span[text()='Delete']"),
            MESSAGE_DELETE = $x("//span[contains(text(), 'was successfully deleted')]"),
            EDIT_BUTTON = $x("//span[contains(text(), ' Edit')]");

    public void createCase(Case case1) {
        log.info("Creating case '{}', ", case1.getTitle());
        new Input("title").write(case1.getTitle());
        new Dropdown("Status").select(case1.getStatus());
        new Dropdown("Suite").select(case1.getSuite());
        new Dropdown("Severity").select(case1.getSeverity());
        new Dropdown("Priority").select(case1.getPriority());
        new Dropdown("Type").select(case1.getType());
        new Dropdown("Layer").select(case1.getLayer());
        new Dropdown("Is flaky").select(case1.getIsFlaky());
        new Dropdown("Behavior").select(case1.getBehavior());
        new Dropdown("Automation status").select(case1.getAutomationStatus());
/*        clickAddButton();
        new ProseWidgetInput(getCaseStepXpath(1)).write("test");*/
    }

    public void clickSaveButton() {
        $(byText(SAVE_BUTTON)).click();
    }

    public void isCaseCreated() {
        MESSAGE_TEXT.shouldBe(Condition.exist);
    }

    public void clickDelete() {
        DELETE_BUTTON.click();
    }

    public void clickConfirm() {
        CONFIRM_DELETE.click();
    }

    public void clickAddButton() {
        ADD_STEP_BUTTON.click();
    }

    public void isCaseDeleted() {
        MESSAGE_DELETE.shouldBe(Condition.exist);
    }

    public void clickEdit() {
        EDIT_BUTTON.click();
    }

    public void isEditModalOpened() {
        $(byText(EDIT_FORM)).shouldBe(Condition.visible);
    }

    public String getCaseStepXpath(int number) {
        //SelenideElement stepsBlock = $x("//div[@class='case-create-block steps-block']");
        //return stepsBlock.sibling(0).$x(String.format("div/div[%s]", number));
        return String.format("//div[@class='case-create-block steps-block']/following-sibling::*[1]/div/div[%s]", number);
    }
}
