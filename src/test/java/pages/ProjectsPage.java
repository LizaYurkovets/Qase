package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectsPage {

    public void openPage() {
        open("projects");
    }

    public void waitTillOpened() {
        $(byText("Create new project")).shouldBe(Condition.visible);
    }

    public void removeProject(String projectName) {
        $(byText(projectName))
                .ancestor("tr")
                .find("button[aria-label='Open action menu']")
                .click();
        $("[data-testid=remove]").click();
        $(byText("Delete project")).click();
    }
}
