package pages;

import dto.Project;
import wrappers.Input;
import wrappers.TextArea;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class NewProjectModal extends ProjectsPage {

    private static final String CREATE_BUTTON = "Create project";

    public void createProject(Project project) {
        new Input("project-name").write(project.getProjectName());
        new TextArea("description-area").write(project.getDescription());
        new Input("private").select();
        new Input("none").select();
    }

    public void clickCreateButton() {
        $(byText(CREATE_BUTTON)).click();
    }
}
