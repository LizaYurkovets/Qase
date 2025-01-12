package tests;

import com.github.javafaker.Faker;
import dto.Case;
import dto.Project;
import org.testng.annotations.Test;


public class ProjectTest extends BaseTest {

    Faker faker = new Faker();

    Project project1 = Project.builder()
            .projectName("Test Project")
            .description(faker.lorem().sentence(15))
            .projectAccessType("private")
            .memberAccess("none")
            .build();

    Case case1 = Case.builder()
            .title("My Case")
            .status("Draft")
            .suite("Test cases without suite")
            .severity("Major")
            .priority("Low")
            .type("Smoke")
            .layer("API")
            .isFlaky("Yes")
            .behavior("Positive")
            .automationStatus("Automated")
            .build();

    @Test
    public void checkCreateProject() {
        loginPage.openPage();
        loginPage.login("lizayurkovets@gmail.com", "Lliza1997$$$");
        projectsPage.openPage();
        projectsPage.waitTillOpened();
        projectsPage.clickCreateNewProject();
        projectModal.createProject(project1);
        projectModal.clickCreateButton();
        projectPage.waitTillOpened();
        projectsPage.openPage();
        projectsPage.removeProject("Test Project");
    }
}

