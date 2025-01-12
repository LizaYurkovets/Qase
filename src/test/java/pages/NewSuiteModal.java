package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import dto.Suite;
import lombok.extern.log4j.Log4j2;
import wrappers.Input;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class NewSuiteModal {

    private static final String CREATE_BUTTON = "Create";
    private static final SelenideElement MESSAGE = $x("//span[text() = 'Suite was successfully created.']");

    public void createSuite(Suite suite) {
        log.info("Creating suite '{}', ", suite.getTitle());
        new Input("title").write(suite.getTitle());
    }

    public void clickCreate() {
        $(byText(CREATE_BUTTON)).click();
    }

    public void isSuiteCreated() {
        MESSAGE.shouldBe(Condition.exist);
    }
}
