package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage {

    private WebDriver driver;
    private By CheckOutButton = By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button");


    public AddToCartPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Click on check out button
    public CheckOutPage clickCheckOut() throws InterruptedException
    {
        driver.findElement(CheckOutButton).click();
        //Wait for the checkout page to load
        Thread.sleep(7000);
        return new CheckOutPage(driver);
    }
}
