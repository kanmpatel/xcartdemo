package hotdeals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotDealsTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUpOpenBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifySaleProductsArrangeAlphabetically() {
        //1.1
        //Mouse hover on the “Hot deals” link
        mouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::span"));
        //1.2
        //Mouse hover on the “sales”  link and click
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::ul/descendant::a[@href='sale_products/']"));
        //Verify the text “sales”
        String actualTextOfsales = getTextFromElement(By.xpath("//h1[contains(text(),'Sale')]"));
        //verify the text using Assert method
        verifyTextMessage("Sale", actualTextOfsales);
        //1.3
        //Mouse hover on “Sort By”
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        //select “Name A-Z”
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='display-sort sort-crit grid-list']/child::li/child::a[contains(text(),'Name A - Z')]"));
        //1.4
        //find the name of products
        String actualProductName = getTextFromElement(By.xpath("//a[contains(text(),'Avengers: Fabrikations Plush [Related Products]')]"));
        String actualProductAlphabet = actualProductName.substring(0, 1);
        //verify the arrage in alphabetics
        if (actualProductAlphabet.startsWith("A") || actualProductAlphabet.startsWith("a")) {
            verifyTextMessage("A", actualProductAlphabet);
        }
    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() {
        //1.1
        //Mouse hover on the “Hot deals” link
        mouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::span"));
        //1.2
        //Mouse hover on the “sales”  link and click
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::ul/descendant::a[@href='sale_products/']"));
        //Verify the text “sales”
        String actualTextOfsales = getTextFromElement(By.xpath("//h1[contains(text(),'Sale')]"));
        //verify the text using Assert method
        verifyTextMessage("Sale", actualTextOfsales);
        //1.3
        //Mouse hover on “Sort By”
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        //select “Name A-Z”
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='display-sort sort-crit grid-list']/child::li/child::a[contains(text(),'Price Low - High')]"));
    }

    @Test
    public void verifySaleProductsArrangeByRates() {
        //1.1
        //Mouse hover on the “Hot deals” link
        mouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::span"));
        //1.2
        //Mouse hover on the “sales”  link and click
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::ul/descendant::a[@href='sale_products/']"));
        //Verify the text “sales”
        String actualTextOfsales = getTextFromElement(By.xpath("//h1[contains(text(),'Sale')]"));
        //verify the text using Assert method
        verifyTextMessage("Sale", actualTextOfsales);
        //1.3
        //Mouse hover on “Sort By”
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        //select “Name A-Z”
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='display-sort sort-crit grid-list']/child::li/child::a[contains(text(),'Rates')]"));
    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {
        //1.1
        //Mouse hover on the “Hot deals” link
        mouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::span"));
        //1.2
        //Mouse hover on the “Bestsellers”  link and click
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::ul/descendant::a[@href='bestsellers/']"));
        //Verify the text “Bestsellers”
        String actualTextOfBestsellers = getTextFromElement(By.xpath("//h1[contains(text(),'Bestsellers')]"));
        //verify the text using Assert method
        verifyTextMessage("Bestsellers", actualTextOfBestsellers);
        //reverse the actual product list
        List<WebElement> originalProdctList = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/child::li/descendant::h5/child::a"));
        //create the list object
        List reverseProdtcutList = new ArrayList();
        //covert web element object to List Object
        //add all web element value to list object
        for (WebElement element : originalProdctList) {
            reverseProdtcutList.add(element.getText());
        }
        //sorting on descending order all list elements value
        Collections.sort(reverseProdtcutList, Collections.reverseOrder());
        //thread sleep
        Thread.sleep(1000);
        //1.3
        //Mouse hover on “Sort By”
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        //select “Name Z-A”
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='display-sort sort-crit grid-list']/child::li/child::a[contains(text(),'Name Z - A')]"));
        Thread.sleep(1000);
        List<WebElement> actualProductListElements = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/child::li/descendant::h5/child::a"));
        //create the list object
        List actualProductList = new ArrayList();
        //covert web element object to List Object
        //add all web element value to list object
        for (WebElement element : actualProductListElements) {
            actualProductList.add(element.getText());
        }
        //1.5
        //verify the arrange on Z to A
        Assert.assertArrayEquals(reverseProdtcutList.toArray(), actualProductList.toArray());
    }

    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {
        //1.1
        //Mouse hover on the “Hot deals” link
        mouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::span"));
        //1.2
        //Mouse hover on the “Bestsellers”  link and click
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::ul/descendant::a[@href='bestsellers/']"));
        //Verify the text “Bestsellers”
        String actualTextOfBestsellers = getTextFromElement(By.xpath("//h1[contains(text(),'Bestsellers')]"));
        //verify the text using Assert method
        verifyTextMessage("Bestsellers", actualTextOfBestsellers);
        //short the actual product list
        List<WebElement> originalProductList = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/child::li/child::div/descendant::span[@class='price product-price']"));
        //create the list object
        List<Double> shortPriceList = new ArrayList();
        //remove $ sign and add the shortpricelist
        //add all web element value to list object
        for (WebElement element : originalProductList) {
            shortPriceList.add(Double.valueOf(element.getText().replace("$", "")));
        }
        Collections.sort(shortPriceList, Collections.reverseOrder());
        //1.3
        //Mouse hover on “Sort By”
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        //select “Name A-Z”
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='display-sort sort-crit grid-list']/child::li/child::a[contains(text(),'Price High - Low')]"));
        Thread.sleep(1000);
        List<WebElement> actualProductListElements = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/child::li/child::div/descendant::span[@class='price product-price']"));
        //create the list object
        List<Double> actualPriceList = new ArrayList();
        //remove $ sign and add the shortpricelist
        //add all web element value to list object
        for (WebElement element : actualProductListElements) {
            actualPriceList.add(Double.valueOf(element.getText().replace("$", "")));
        }
        //Assert.assertArrayEquals(shortPriceList.toArray(),actualPriceList.toArray());
        Assert.assertEquals(shortPriceList, actualPriceList);
    }
    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {
        //1.1
        //Mouse hover on the “Hot deals” link
        mouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::span"));
        //1.2
        //Mouse hover on the “Bestsellers”  link and click
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::ul/descendant::a[@href='bestsellers/']"));
        //Verify the text “Bestsellers”
        String actualTextOfBestsellers = getTextFromElement(By.xpath("//h1[contains(text(),'Bestsellers')]"));
        //1.3
        //Mouse hover on “Sort By”
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        //select “rate”
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='display-sort sort-crit grid-list']/child::li/child::a[contains(text(),'Rates')]"));

    }




    @After
    public void SetUpCloseBrowser() {
        // closeBrowser();
    }

}
