package tests;
import dto.Case;
import org.testng.annotations.Test;

public class TestCaseTest extends BaseTest {

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

    Case case2 = Case.builder()
            .title("Test Case")
            .status("Actual")
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
    public void checkEditCase() {
        loginPage.openPage();
        loginPage.login("lizayurkovets@gmail.com", "Lliza1997$$$");
        projectsPage.openPage();
        projectsPage.waitTillOpened();
        projectsPage.openProject();
        projectsPage.isProjectOpened();
        projectPage.clickCreateCase();
        caseModal.createCase(case2);
        caseModal.clickSaveButton();
        caseModal.isCaseCreated();
        caseModal.clickEdit();
        caseModal.isEditModalOpened();
        //TODO:Дописать тест
    }

    @Test
    public void checkRemoveCase() {
        loginPage.openPage();
        loginPage.login("lizayurkovets@gmail.com", "Lliza1997$$$");
        projectsPage.openPage();
        projectsPage.waitTillOpened();
        projectsPage.openProject();
        projectsPage.isProjectOpened();

        projectPage.clickCreateCase();
        caseModal.createCase(case1);
        caseModal.clickSaveButton();
        caseModal.isCaseCreated();
        caseModal.clickDelete();
        caseModal.clickConfirm();
        caseModal.isCaseDeleted();
    }
}