package wrappers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProseWidgetInput {
    String value;
    String context;

    public ProseWidgetInput(String value) {
        this.value = value;
    }

    public ProseWidgetInput(String context, String value) {
        this(value);
        this.context = context;
    }

    public SelenideElement getElement() {
        String xpath = String.format("//span[@class='placeholder ProseMirror-widget'][text()='%s']/ancestor::div[@class='ProseMirror toastui-editor-contents']", value);
        return context == null ? $x(xpath) : $x(context + xpath);
    }

    //    //div[@class='case-create-block steps-block']/following-sibling::*[1]/div/div[1]//span[@class='placeholder ProseMirror-widget'][text()='Step Action']/ancestor::div[@class='ProseMirror toastui-editor-contents']
    public void write(String text) throws InterruptedException {
        var element = getElement();
        Thread.sleep(5000);
        element.shouldBe(Condition.exist);
        Thread.sleep(5000);
        element.$x("p").append(text);
    }

}
