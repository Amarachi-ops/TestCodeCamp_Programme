package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class SetupTest {

    //Create a WebDriver Object
    private WebDriver driver;
    //Create LoginPage object
    protected LoginPage loginPage;
    //Create DashboardPage object
    protected DashboardPage dashboardPage;

    @BeforeTest
    public void setUp(){
        //Browser setup for Chrome
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        //Instantiate WebDriver object
        driver = new ChromeDriver();
        //Maximize window size
        driver.manage().window().maximize();
        //Launch the application
        driver.get("https://opensource-demo.orangehrmlive.com/");
        //Instantiate login page after launching the browser - Handle
        loginPage = new LoginPage(driver);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
