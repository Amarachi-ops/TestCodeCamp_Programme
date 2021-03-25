package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {

    private WebDriver driver;
    private By selectDeliveryAddressButton = By.xpath("//*[@id=\"mainContent\"]/form/div/div/section[1]/div[2]/div/div[1]/div/div[1]/form/div/div/a");
    private By selectDeliveryAddress = By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div/form/button");
    private By payNowButton = By.xpath("//*[@id=\"mainContent\"]/form/div/section/div/div[4]/form/ul/li/div/button");
    private By continueToPaymentButton = By.name("placeOrder");
    private By checkOut_iFrame = By.xpath("//*[@id='kpg-frame-component']");
    private By cardButton = By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[2]/button");
    private By cardNumberField = By.xpath("//*[@id=\"card-number\"]");
    private By dateField = By.id("expiry");
    private By cvvField = By.id("cvv");
    private By errorMessage = By.xpath("//*[@id=\"card-number_unhappy\"]");
    private By cardModal_iframe = By.xpath("/html/body/section/section/section/div[2]/div[1]/aside");


    public CheckOutPage(WebDriver driver)
    {
        this.driver = driver;
    }


    //Click on Select Delivery Address Button
    public void clickOnSelectDeliveryAddressButton()
    {
        driver.findElement(selectDeliveryAddressButton).click();
    }

    //Click on Select Delivery Address
    public void clickOnSelectDeliveryAddress()
    {
        driver.findElement(selectDeliveryAddress).click();
    }

    //Click on PayNow
    public void clickOnPayNow()
    {
        driver.findElement(payNowButton).click();
    }

    public void clickContinueToPayment() throws InterruptedException
    {
        driver.findElements(continueToPaymentButton).get(1).click();
        Thread.sleep(10000);
    }

    //Select the Payment Type
    public void clickOnPaymentType() throws InterruptedException
    {
        WebElement checkOutFrame = driver.findElement(checkOut_iFrame);
        //Switch to iFrame
        driver.switchTo().frame(checkOutFrame);
        driver.findElement(cardButton).click();
        Thread.sleep(3000);
    }

    //Enter card details
    public void enterCardDetails(String cardNumber)
    {
        driver.findElement(cardNumberField).sendKeys("5334567822334456");
        driver.findElement(dateField).sendKeys("02/20");
        driver.findElement(cvvField).sendKeys("254");
    }

    //Return User invalid message
    public String error_message()
    {
        return driver.findElement(errorMessage).getText();
    }
}
