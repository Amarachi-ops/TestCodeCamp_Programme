package User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserManagementTest {

    //import selenium WebDriver
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        //Add the chromeDriver.exe file
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //Launch the chromeDriver.exe
        driver = new ChromeDriver();
        //input the website URL
        driver.get("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login");
        //Wait fot the page to load in 5 seconds
        Thread.sleep(5000);
        //Maximize the browser
        driver.manage().window().fullscreen();
        //Get Page title
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void SignInTest() throws InterruptedException {
        //Click on the username field and input a valid username"amarachiobaji@gmail.com"
        driver.findElement(By.id("username")).sendKeys("amarachiobaji@gmail.com");
        //Click on the password field and input a valid password"heaven01&"
        driver.findElement(By.id("password")).sendKeys("heaven01&");
        //Click on the login button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        //Wait for the page to load in 5 seconds
        Thread.sleep(5000);
        if (driver.getCurrentUrl().contains("https://dev.d2rxvhrryr2bkn.amplifyapp.com/app/feed")) {
            System.out.println("PASSED - User has successfully logged in");
        }else{
            System.out.println("User was unable to login");
        }
        Thread.sleep(5000);
    }

    @Test
    public void SignOutTest() throws InterruptedException {
        //Click on the UserProfile
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[1]/div[1]/div/div[2]/div[3]/button")).click();
        //Wait to ensure the dropdown list is displayed
        Thread.sleep(5000);
        driver.findElement(By.linkText("Log Out")).click();
        if (driver.getCurrentUrl().contains("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login")) {
            System.out.println("PASSED - User has successfully logged out");
        }else{
            System.out.println("User is still logged in");
        }
        Thread.sleep(5000);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
