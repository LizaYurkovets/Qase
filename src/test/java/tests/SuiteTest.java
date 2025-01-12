package tests;

import dto.Case;
import dto.Suite;
import org.testng.annotations.Test;

public class SuiteTest extends BaseTest {

    Case case1 = Case.builder()
            .title("My Case")
            .status("Draft")
            .suite("My Suite")
            .severity("Major")
            .priority("Low")
            .type("Smoke")
            .layer("API")
            .isFlaky("Yes")
            .behavior("Positive")
            .automationStatus("Automated")
            .build();

    Suite suite = Suite.builder()
            .title("My Suite")
            .build();

    @Test
    public void checkCreateSuiteWithTestCases() {
        loginPage.openPage();
        loginPage.login("lizayurkovets@gmail.com", "Lliza1997$$$");
        projectsPage.openPage();
        projectsPage.waitTillOpened();
        projectsPage.openProject();
        projectsPage.isProjectOpened();
        projectPage.clickCreateSuite();
        suiteModal.createSuite(suite);
        suiteModal.clickCreate();
        suiteModal.isSuiteCreated();
        projectPage.clickCreateCase();
        caseModal.createCase(case1);
        caseModal.clickSaveButton();
        caseModal.isCaseCreated();
    }
 }
