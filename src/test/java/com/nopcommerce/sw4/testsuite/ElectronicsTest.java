package com.nopcommerce.sw4.testsuite;

import com.nopcommerce.sw4.pages.*;
import com.nopcommerce.sw4.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElectronicsTest extends BaseTest {
    ElectronicsPage electronicsPage=new ElectronicsPage();
    CellPhonePage cellPhonesPage=new CellPhonePage();
    NokiaLumia1020Page nokiaLumia1020Page=new NokiaLumia1020Page();
    BuildYourOwnComputer buildYourOwnComputer=new BuildYourOwnComputer();
    ShoppingCartPage shoppingCartPage=new ShoppingCartPage();
    LoginPage loginPage=new LoginPage();
    RegisterPage registerPage=new RegisterPage();
    CheckoutPage checkoutPage=new CheckoutPage();
    HomePage homePage=new HomePage();
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){
        //1.1 Mouse Hover on “Electronics” Tab
        electronicsPage.hoverOnElectronics();
        //1.2 Mouse Hover on “Cell phones” and click
        electronicsPage.hoverOnCellPhoneAndClick();
        //1.3 Verify the text “Cell phones”
        String actualText= cellPhonesPage.getCellPhoneText();
        Assert.assertEquals(actualText,"Cell phones","Text not Displayed");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        electronicsPage.hoverOnElectronics();
        //2.2 Mouse Hover on “Cell phones” and click
        electronicsPage.hoverOnCellPhoneAndClick();
        //2.3 Verify the text “Cell phones”
        String actualText= cellPhonesPage.getCellPhoneText();
        Assert.assertEquals(actualText,"Cell phones","Text not Displayed");
        //2.4 Click on List View Tab
        cellPhonesPage.clickOnListViewTab();
        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(1000);
        cellPhonesPage.clickOnNokiaLumia1020();
        //2.6 Verify the text “Nokia Lumia 1020”
        String actualNokiaLumiaText=nokiaLumia1020Page.getNokiaLumiaText();
        Assert.assertEquals(actualNokiaLumiaText,"Nokia Lumia 1020","Text not Displayed");
        //2.7 Verify the price “$349.00”
        String actualNokiaPriceText=nokiaLumia1020Page.getNokiaPriceText();
        Assert.assertEquals(actualNokiaPriceText,"$349.00","Text not Displayed");
        //2.8 Change quantity to 2
        nokiaLumia1020Page.changeQuantity();
        //2.9 Click on “ADD TO CART” tab
        nokiaLumia1020Page.clickOnAddToCartButton();
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar  After that close the bar clicking on the cross button.
        String actualTextShoppingCart=nokiaLumia1020Page.getTextFromProductAddedToCart();
        Assert.assertEquals(actualTextShoppingCart,"The product has been added to your shopping cart","Text not Displayed");
        nokiaLumia1020Page.closeTheBarByClickingOnTheCrossButton();
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        nokiaLumia1020Page.mouseHoverOnShoppingCart();
        nokiaLumia1020Page.clickOnShoppingCart();
        //2.12 Verify the message "Shopping cart"
        String actualShoppingCartMessage = shoppingCartPage.getShoppingCartText();
        Assert.assertEquals(actualShoppingCartMessage,"Shopping cart","error");
        Thread.sleep(2000);
        //2.13 Verify the quantity is 2
        String actualQuantity=shoppingCartPage.getVerifyQuantity();
        Assert.assertEquals(actualQuantity,"(2)","Error");
        //2.14 Verify the Total $698.00
        String actualTotal=shoppingCartPage.getVerifyTotal();
        Assert.assertEquals(actualTotal,"$698.00","Error");
        //2.15 click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnTermsOfServiceCheckBox();
        //2.16 Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckOutButton();
        //2.17 Verify the Text “Welcome, Please Sign In!”
        String actualWelcomeText=loginPage.getWelcomePageSignInText();
        Assert.assertEquals(actualWelcomeText,"Welcome, Please Sign In!","Error");
        //2.18 Click on “REGISTER” tab
        loginPage.clickOnRegisterButton();
        //2.19 Verify the text “Register”
        String actualRegisterText=registerPage.getRegisterText();
        Assert.assertEquals(actualRegisterText,"Register","Error");
        //2.20 Fill the mandatory fields
        registerPage.inputFirstname("Ramesh");
        registerPage.inputLastname("Patel");
        registerPage.inputEmail("PatelRamesh7891@gmail.com");
        registerPage.inputPassword("Temp123");
        registerPage.inputConfirmPassword("Temp123");
        //2.21 Click on “REGISTER” Button
        registerPage.clickOnRegisterButton();
        //2.22 Verify the message “Your registration completed”
        String actualRegisterSuccessMessage = registerPage.getRegisterSuccessText();
        Assert.assertEquals(actualRegisterSuccessMessage,"Your registration completed","error");
        //2.23 Click on “CONTINUE” tab
        registerPage.clickOnContinueButton();
        //2.24 Verify the text “Shopping card”
        shoppingCartPage.getShoppingCartText();
        //2.25 click on checkbox “I agree with the terms of service”
        // Doesn't work after this due to the Bug in the Website
        //shoppingCartPage.clickOnTermsOfServiceCheckBox();
        //2.26 Click on “CHECKOUT”
        //shoppingCartPage.clickOnCheckOutButton();

        //2.27 Fill the Mandatory fields
        // checkoutPage.inputFirstname("Ramesh");
        //checkoutPage.inputLastname("Patel");
        // checkoutPage.inputEmail("PatelRamesh1234@gmail.com");
        checkoutPage.selectCountry("United Kingdom");
        checkoutPage.inputCity("London");
        checkoutPage.inputAddress1("123 HighStreet");
        checkoutPage.inputPostalCode("EC15YQ");
        checkoutPage.inputPhoneNumber("12345678");
        //2.28 Click on “CONTINUE”
        checkoutPage.clickOnContinueButton();
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        checkoutPage.clickOnRadioButton2ndDayAir();
        // 2.30 Click on “CONTINUE”
        checkoutPage.clickOnContinueButton1();
        // 2.31 Select Radio Button “Credit Card”
        checkoutPage.clickOnCreditCard();
        checkoutPage.clickOnPaymentContinueButton();
        // 2.32 Select “Visa” From Select credit card dropdown
        checkoutPage.selectCreditCard("Visa");
        //2.33 Fill all the details
        checkoutPage.inputCardHolderName("Mr Ramesh Patel");
        checkoutPage.inputCardNumber("5356 6548 1418 5420");
        checkoutPage.selectExpireMonth("12");
        checkoutPage.selectExpireYear("2025");
        checkoutPage.inputCardCode("789");
        //2.34 Click on “CONTINUE”CHECKOUT
        checkoutPage.clickOnContinueButton2();
        // 2.35 Verify “Payment Method” is “Credit Card”
        String actualCreditCardMessage = checkoutPage.getCreditCardText();
        Assert.assertEquals(actualCreditCardMessage,"Credit Card","error");
        // 2.36 Verify “Shipping Method” is “2nd Day Air”
        String actual02DayMessage = checkoutPage.get02ndDayText();
        Assert.assertEquals(actual02DayMessage,"2nd Day Air","error");
        // 2.37 Verify Total is “$698.00”
        String actualTotalAmountNokiaMessage = checkoutPage.getTotalAmountNokiaText();
        Assert.assertEquals(actualTotalAmountNokiaMessage,"$698.00","error");
        // 2.38 Click on “CONFIRM”
        checkoutPage.clickOnConfirmButton();
        //2.39 Verify the Text “Thank You”
        String actualThankYouMessage = checkoutPage.getThankYouText();
        Assert.assertEquals(actualThankYouMessage,"Thank you","error");
        //2.40 Verify the message “Your order has been successfully processed!”
        String actualOrderSuccessProcessedMessage = checkoutPage.getOrderSuccessProcessText();
        Assert.assertEquals(actualOrderSuccessProcessedMessage,"Your order has been successfully processed!","error");
        // 2.41 Click on “CONTINUE”
        checkoutPage.clickOnContinueButton3();
        // 2.42 Verify the text “Welcome to our store”
        String actualWelcomeOurStoreMessage = homePage.getWelcomeOurStoreText();
        Assert.assertEquals(actualWelcomeOurStoreMessage,"Welcome to our store","error");
        // 2.43 Click on “Logout” link
        homePage.clickOnLogOutButton();
        // 2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String actualURL = driver.getCurrentUrl();
        // org.junit.Assert.assertEquals(actualURL, "https://demo.nopcommerce.com/" );
        Assert.assertEquals(actualURL,"https://demo.nopcommerce.com/","error");

    }
}


