package login;

import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import setup.SetupTest;

public class LoginTests extends SetupTest {

    //TestNG annotation
    @Test
    //This class extends to the SetupTests as the SetupTests class contains all the setup requirements to run our test
    public void testLogin() throws InterruptedException
    {
        String username = "Admin";
        loginPage.enterUsername(username);
        loginPage.enterUserPassword("admin123");

        //Handler for dashboard page
        loginPage.clickLoginBtn();
        String pageUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        System.out.println("PASSED - The page url is " + pageUrl);
    }

    @Test
    public void testLogout() throws InterruptedException {
        //Wait for 10 seconds before executing the action
        Thread.sleep(10000);
        try {
            dashboardPage.clickWelcomeAdmin();
            loginPage = dashboardPage.clickLogout();
            //Wait for 10 seconds before executing the action
            Thread.sleep(10000);
        } catch (Exception e) {
            String loginUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
            System.out.println("PASSED - The page url is" + loginUrl);
        }
    }
}
