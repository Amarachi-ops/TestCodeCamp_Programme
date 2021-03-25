package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By EmailAddress = By.id("username");
    private By Password = By.id("password");
    private By loginButton = By.xpath("//button[@class='_0a08a_3czMG _988cf_1aDdJ']");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Enter Username
    public void enterUsername(String uName) {
        driver.findElement(EmailAddress).sendKeys(uName);
    }

    //Enter Password
    public void enterPassword(String uPassword) {
        driver.findElement(Password).sendKeys(uPassword);
    }

    //Click on the Login button
    public HomePage clickLoginButton() throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(5000);
        return new HomePage(driver);
    }
}