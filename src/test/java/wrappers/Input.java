package wrappers;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class Input {

    String value;

    public Input(String value) {
        this.value = value;
    }

    public void write(String text) {
        log.info("Writing '{}' in the '{}', ", value, text);
        $x(String.format("//input[@id='%s']", value)).sendKeys(text);
    }

    public void select() {
        log.info("Selecting '{}' ", value);
        $x(String.format("//label/span/input[@value='%s']", value)).click();
    }
}
