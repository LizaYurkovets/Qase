package pages;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage {

    private static final String USER = "[name=email]",
            PASSWORD = "[name=password]",
            BUTTON_SIGN_IN = "Sign in";

    public void openPage() {
        log.info("Open LoginPage");
        open("login");
    }

    public void login(String user, String password) {
        log.info("Log into the system using credentials '{}', '{}'", user, password);
        $(USER).setValue(user);
        $(PASSWORD).setValue(password);
        $(byText(BUTTON_SIGN_IN)).click();
    }
}
