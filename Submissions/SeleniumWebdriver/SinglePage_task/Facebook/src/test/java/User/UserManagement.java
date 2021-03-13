package User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserManagement {
    //import selenium WebDriver
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        //Add the chromeDriver.exe file
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        //Launch the chromeDriver.exe
        driver = new ChromeDriver();
        //input the website URL
        driver.get("https://web.facebook.com/");
        //Wait for the website to load in 5 seconds
        Thread.sleep(5000);
        //Maximize the browser
        driver.manage().window().maximize();
        //Get Page title
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void LogInTest() throws InterruptedException {
        //Click on the emailAddress field and input a valid emailAddress "amarachiobaji@gmail.com"
        driver.findElement(By.id("email")).sendKeys("amarachiobaji@gmail.com");
        //Click on the password field and input a valid password "heavenonearth"
        driver.findElement(By.id("pass")).sendKeys("heavenonearth");
        //Click on the login button
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).click();
        //Wait for the Page to Load in 5 seconds
        Thread.sleep(5000);
        if (driver.getCurrentUrl().contains("https://web.facebook.com/")) {
            System.out.println("FAILED - User was unable to login");
        }else{
            System.out.println("PASSED - User has successfully logged in");
        }
        Thread.sleep(5000);
    }

    @Test
    public void LogOutTest() throws InterruptedException {
        //Click on the Dropdown icon to join
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[1]/span/div/div[1]")).click();
        //Wait to ensure the dropdown list is displayed
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/div[4]/div/div[1]/div[2]/div/div/div/div/span")).click();
        if (driver.getCurrentUrl().contains("https://web.facebook.com/?_rdc=1&_rdr")) {
            System.out.println("FAILED - User is still logged in");
        }else{
            System.out.println("PASSED - User has successfully logged out");
        }
        Thread.sleep(5000);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
