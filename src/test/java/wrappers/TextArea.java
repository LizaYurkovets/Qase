package wrappers;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class TextArea {

    String value;

    public TextArea(String label) {
        this.value = label;
    }

    public void write(String text) {
        log.info("Writing '{}' in the '{}', ", value, text);
        $x(String.format("//textarea[@id='%s']", value)).sendKeys(text);
    }
}
