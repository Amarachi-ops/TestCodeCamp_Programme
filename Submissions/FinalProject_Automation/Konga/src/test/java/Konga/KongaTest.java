package Konga;

import org.testng.annotations.Test;
import pageObjects.*;
import setup.SetUpTest;

public class KongaTest extends SetUpTest {

    @Test
    public void testLoginPage() {
        int addToCartButtonID = 1, numberOfItems = 4;

        try {//Sign in to Konga Website
            LoginPage loginPage = homePage.clickLoginSignUpButton();
            loginPage.enterUsername("amarachiobaji@gmail.com");
            loginPage.enterPassword("heaven01&");
            homePage = loginPage.clickLoginButton();
            //select any categories and the subcategory
            SubCategoryPage subCategoryPage = homePage.clickCategoryAndSub();
            //Use the search box, search for an item
            subCategoryPage.searchForAnItem("Macbook");
            SearchPage searchPage = subCategoryPage.clickSearchButton();
            //Click on the add to cart button
            searchPage.clickOnAddToCart(addToCartButtonID);
            //Click on the My Cart Menu
            AddToCartPage addToCartPage = searchPage.clickMyCartButton();
            //Click on checkout
            CheckOutPage checkOutPage = addToCartPage.clickCheckOut();
            //Select the Pay Now Option to activate the “Continue to Payment” button - the user must have preselected pick up method
            checkOutPage.clickOnPayNow();
            //Click on the “Continue to Payment” button
            checkOutPage.clickContinueToPayment();
            //Select the “CARD” payment method
            checkOutPage.clickOnPaymentType();
            //Input a wrong card number, date, CVV and pin
            checkOutPage.enterCardDetails("5334567822334456");
            //print the error message for the card number field
            System.out.println(checkOutPage.error_message());

        } catch (InterruptedException e) {
            //Todo Auto-Generated catch block
            e.printStackTrace();
        }

        }
    }
