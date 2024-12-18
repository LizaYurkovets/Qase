package tests;

import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test
    public void checkCreateProject() {
        loginPage.openPage();
        loginPage.login("lizayurkovets@gmail.com", "Lliza1997$$$");
    }
}

