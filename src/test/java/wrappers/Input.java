package wrappers;

import static com.codeborne.selenide.Selenide.$x;

public class Input {

    String value;

    public Input(String value) {
        this.value = value;
    }

    public void write(String text) {
        $x(String.format("//input[@id='%s']", value)).sendKeys(text);
    }

    public void select() {
        $x(String.format("//label/span/input[@value='%s']", value)).click();
    }
}
