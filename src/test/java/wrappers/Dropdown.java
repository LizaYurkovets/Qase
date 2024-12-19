package wrappers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Dropdown {
    String name;

    public Dropdown(String name) {
        this.name = name;
    }

    public void select(String value) {
        getDropdown().click();

        var dropdownOptions = $x("//div[@role='listbox']");
        dropdownOptions.shouldBe(Condition.visible);
        dropdownOptions.$x(String.format("div[text()='%s']", value)).click();
    }

    public String selectedValue() {
        return getDropdown().$x("div[2]").getText();
    }

    private SelenideElement getDropdown() {
        var label = $x(String.format("//label[text()='%s']", name));
        return label.sibling(0);
    }
}
