package pages;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ProjectsPage {

    private static final String CREATE_NEW_PROJECT = "Create new project";

    public void openPage() {
        log.info("Open Projects page");
        open("projects");
    }

    public void waitTillOpened() {
        $(byText("Create new project")).shouldBe(Condition.visible);
    }

    public void clickCreateNewProject() {
        $(byText(CREATE_NEW_PROJECT)).click();
    }


    public void removeProject(String projectName) {
        $(byText(projectName))
                .ancestor("tr")
                .find("button[aria-label='Open action menu']")
                .click();
        $("[data-testid=remove]").click();
        $x("//button//span[contains(text(), 'Delete project')]").click();
    }

    public void openProject() {
        log.info("Open project MYPROJECT");
        open("project/MYPROJECT");
    }

    public void isProjectOpened() {
        $(byText("MYPROJECT")).shouldBe(Condition.visible);
    }
}
