package shopping;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class ShoppingTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";
    @Before
    public void setUpOpenBrowser(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {
        //1.1
        //Mouse hover on the “Hot deals” link
        mouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::span"));
        //1.2
        //Mouse hover on the “Bestsellers”  link and click
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::ul/descendant::a[@href='bestsellers/']"));
        //Verify the text “Bestsellers”
        String actualTextOfBestsellers = getTextFromElement(By.xpath("//h1[contains(text(),'Bestsellers')]"));
        //verify the text using Assert method
        verifyTextMessage("Bestsellers",actualTextOfBestsellers);
        //1.3
        //Mouse hover on “Sort By”
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        //select “Name A-Z”
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='display-sort sort-crit grid-list']/child::li/child::a[contains(text(),'Name A - Z')]"));
        //1.5
        //mouse hover on “Ollie - The App Controlled
        mouseHoverOnElement(By.xpath("//ul[@class='products-grid grid-list']/li[1]"));
        //click on add to cart button
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='products-grid grid-list']/li[1]/descendant::button[@class='btn  regular-button add-to-cart product-add2cart productid-42']"));
        //1.6
        //find the actual add to cart text
        String actualAddToCartText = getTextFromElement(By.xpath("//li[contains(text(),'Product has been added to your cart')]"));
        //verify the text using assert
        verifyTextMessage("Product has been added to your cart",actualAddToCartText);
        //1.7
        //click on "close" sign
        clickOnElement(By.cssSelector(".close"));
        //1.8
        //click on "your cart icon
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        //click on "view cart" button
        Thread.sleep(10000);
        clickOnMouseHoverOnElement(By.xpath("//span[contains(text(),'View cart')]/parent::a"));
        //driver.navigate().to("https://mobile.x-cart.com/?target=cart");
        //1.9
        //find the element of Your Shopping cart - 1 item
        String actualTextMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Your shopping cart - 1 item')]"));
        //verify the test "Your shopping cart - 1 item"
        verifyTextMessage("Your shopping cart - 1 item",actualTextMessage);
        //1.10
        //find the list of total
        List<WebElement> actualPriceList = driver.findElements(By.xpath("//ul[@class='totals']/li[1]/child::span/descendant::span[@class='surcharge-cell']/child::span"));
        //create the object of stringbuilder
        StringBuilder strbul = new StringBuilder();
        for(WebElement str : actualPriceList)
        {
            //append all the list in strbul
            strbul.append(str.getText());
        }
        //coverted the stringbuilder to string
        String actualPrice = strbul.toString();
        //verify the price
        verifyTextMessage("$299.00",actualPrice);
        //1.11
        //find the list of total
        List<WebElement> actualTotalList = driver.findElements(By.xpath("//ul[@class='totals']/li[4]/child::span/descendant::span[@class='surcharge-cell']/child::span"));
        //create the object of stringbuilder
        StringBuilder strbulTotal = new StringBuilder();
        for(WebElement totalList : actualTotalList)
        {
            //append all the list in strbul
            strbulTotal.append(totalList.getText());
        }
        //coverted the stringbuilder to string
        String actualTotal = strbulTotal.toString();
        //verify the price
        verifyTextMessage("$309.73",actualTotal);
        //1.12
        //click on "go to checkout" button
        clickOnElement(By.xpath("//li[@class=\"button main-button\"]/child::button"));
        //1.13
        //find the element of login text
        String actualTextLogin = getTextFromElement(By.xpath("//h3[contains(text(),'Log in to your account')]"));
        //verify the login page text
        verifyTextMessage("Log in to your account",actualTextLogin);
        //1.14
        //enter the email address
        sendTextToElement(By.id("email"),"patel333333@gmail.com");
        //1.15
        //click on continue
        clickOnElement(By.xpath("//td[@class='buttons-row']/child::button"));
        //1.16
        //find the element of secure checkout
        String actualCheckOutMessage = getTextFromElement(By.xpath("//h1[contains(text(),' Secure Checkout')]"));
        //verify the checkout text
        verifyTextMessage("Secure Checkout",actualCheckOutMessage);
        //1.17
        //enter the first name
        sendTextToElement(By.id("shippingaddress-firstname"),"john");
        //enter the last name
        sendTextToElement(By.id("shippingaddress-lastname"),"sena");
        //enter the address
        sendTextToElement(By.id("shippingaddress-street"),"katheirn road");
        //enter the country
       selectByValueFromDropDown(By.id("shippingaddress-country-code"),"GB");
        //enter the state
        sendTextToElement(By.id("shippingaddress-custom-state"),"england");
        //1.18
        //check the check box
        clickOnElement(By.id("create_profile"));
        //1.19
        //enter the password
        sendTextToElement(By.id("password"),"patel12345");
        //1.20
        //Select the Delivery Method to “Local Shipping
        WebElement LocalShipping = findElementsOnBrowser(By.id("method128"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", LocalShipping);
        //1.21
        //Select Payment Method “COD”
        Thread.sleep(1000);
        clickOnElement(By.id("pmethod6"));
        //1.22
        //1.10
        //find the list of total
        List<WebElement> actualPriceList1 = driver.findElements(By.xpath("//div[@class=\"total clearfix\"]/descendant::span[@class=\"value\"]/descendant::span[@class=\"surcharge-cell\"]/child::span"));
        //create the object of stringbuilder
        StringBuilder strbul1 = new StringBuilder();
        for(WebElement str : actualPriceList1)
        {
            //append all the list in strbul
            strbul1.append(str.getText());
        }
        //coverted the stringbuilder to string
        String actualPrice1 = strbul1.toString();
        //verify the price
        verifyTextMessage("$311.03",actualPrice1);
        //1.11
        //find the list of total
        Thread.sleep(10000);
        //1.23
        //click on place order
        clickOnMouseHoverOnElement(By.xpath("//button[contains(@class,'btn regular-button regular-main-button place-order submit')]"));
        //1.24
        //verify the place order text
        String actualOrderText = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you for your order')]"));
        verifyTextMessage("Thank you for your order",actualOrderText);
    }
    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        //1.1
        //Mouse hover on the “Hot deals” link
        mouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::span"));
        //1.2
        //Mouse hover on the “Bestsellers”  link and click
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::ul/descendant::a[@href='bestsellers/']"));
        //Verify the text “Bestsellers”
        String actualTextOfBestsellers = getTextFromElement(By.xpath("//h1[contains(text(),'Bestsellers')]"));
        //verify the text using Assert method
        verifyTextMessage("Bestsellers",actualTextOfBestsellers);
        //1.3
        //Mouse hover on “Sort By”
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        //select “Name A-Z”
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='display-sort sort-crit grid-list']/child::li/child::a[contains(text(),'Name A - Z')]"));
        //1.5
        //mouse hover on “Vinyl Idolz: Ghostbusters
        Thread.sleep(1000);
        mouseHoverOnElement(By.xpath("//ul[@class='products-grid grid-list']/li[3]"));
        //click on add to cart button
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='products-grid grid-list']/li[3]/descendant::button[@class='btn  regular-button add-to-cart product-add2cart productid-16']"));
        //1.6
        //find the actual add to cart text
        String actualAddToCartText = getTextFromElement(By.xpath("//li[contains(text(),'Product has been added to your cart')]"));
        //verify the text using assert
        verifyTextMessage("Product has been added to your cart",actualAddToCartText);
        //1.7
        //click on "close" sign
        clickOnElement(By.cssSelector(".close"));
        //1.8
        //click on "your cart icon
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        //click on "view cart" button
        //clickOnElement(By.xpath("//span[contains(text(),'View cart')]/parent::a"));
        driver.navigate().to("https://mobile.x-cart.com/?target=cart");
        //1.9
        //find the element of Your Shopping cart - 1 item
        String actualTextMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Your shopping cart - 1 item')]"));
        //verify the test "Your shopping cart - 1 item"
        verifyTextMessage("Your shopping cart - 1 item",actualTextMessage);
        //1.10
        //click on empty your cart
        clickOnElement(By.xpath("//a[contains(text(),'Empty your cart')]"));
        //1.11
        //verify the alert text
        String actualAlertMessage = getAlertMessage();
        verifyTextMessage("Are you sure you want to clear your cart?",actualAlertMessage);
        //1.12
        //click ok on alert
        acceptToAlert();
        //1.13
        //find the actual delete cart item text
        String actualCartDeleteText = getTextFromElement(By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]"));
        //verify the text using assert
        verifyTextMessage("Item(s) deleted from your cart",actualCartDeleteText);
        //1.14
        //click on "close" sign
        clickOnElement(By.cssSelector(".close"));
        //1.15
        //find the element of your cart is empty
        String actualyouCartEmptyMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Your cart is empty')]"));
        //verify the empty cart message
        verifyTextMessage("Your cart is empty",actualyouCartEmptyMessage);
    }

    @After
    public void SetUpCloseBrowser(){
       // closeBrowser();
    }

}
