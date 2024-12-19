package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;


public class BaseTest {

    LoginPage loginPage;
    ProjectsPage projectsPage;
    NewProjectModal projectModal;
    ProjectPage projectPage;
    NewCaseModal caseModal;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        Configuration.browserCapabilities = options;
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://app.qase.io/";
        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
        projectModal = new NewProjectModal();
        projectPage = new ProjectPage();
        caseModal = new NewCaseModal();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        closeWebDriver();
    }
}
