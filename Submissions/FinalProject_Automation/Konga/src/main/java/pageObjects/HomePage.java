package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    private WebDriver driver;
    private By loginButton = By.xpath("//a[@class='_7ad32_SD12Y _16536_xxIKG']");
    private By categoryBarElement = By.className("ef511_2c5_i");
    private By subcategory = By.xpath(".//a[contains(text(),'Macbooks')]");

    int categoryNumber = 1;
    //Subcategory number where 0 = Mini Laptops and Netbooks and  4 = Macbooks
    int loginButtonElementID = 3;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Click the login/sign up button on the landing page
    public LoginPage clickLoginSignUpButton()
    {
        driver.findElements(loginButton).get(loginButtonElementID).click();
        return new LoginPage(driver);
    }


    public SubCategoryPage clickCategoryAndSub() throws InterruptedException
    {
        Actions executeAction = new Actions(driver);

        //choose the category to mouse hover
        WebElement selectedCategory = driver.findElements(categoryBarElement).get(categoryNumber);
        //Mouse hover on the selected category
        executeAction.moveToElement(selectedCategory).perform();
        Thread.sleep(7000);

        //Click on the MacBook
        driver.findElement(subcategory).click();
        Thread.sleep(5000);

        return new SubCategoryPage(driver);
    }
}
