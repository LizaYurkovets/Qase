package wrappers;

import static com.codeborne.selenide.Selenide.$x;

public class TextArea {

    String value;

    public TextArea(String label) {
        this.value = label;
    }

    public void write(String text) {
        $x(String.format("//textarea[@id='%s']", value)).sendKeys(text);
    }
}
