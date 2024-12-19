package tests;

import com.github.javafaker.Faker;
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
        projectPage.clickCreateCase();

        caseModal.createCase();
        caseModal.clickSaveButton();
        caseModal.waitTillOpened();
    }
}

