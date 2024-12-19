package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectsPage {

    private static final String CREATE_NEW_PROJECT = "Create new project";

    public void openPage() {
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
        $x("//button/span[contains(text(), 'Delete project')]").click();
    }
}
