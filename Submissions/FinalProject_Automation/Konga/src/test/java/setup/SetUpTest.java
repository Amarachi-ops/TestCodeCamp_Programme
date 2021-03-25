package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.HomePage;

public class SetUpTest {

    //Create a WebDriver Object
    private WebDriver driver;
    //Create HomePage
    public HomePage homePage;

    @BeforeTest
    public void setUp() {
        //Browser setup for Chrome
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //Instantiate WebDriver object
        driver = new ChromeDriver();
        //Maximize window size
        driver.manage().window().maximize();
        //Launch the application
        driver.get("https://www.konga.com/");
        //Instantiate login page after launching the browser - Handle
        homePage = new HomePage(driver);
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}