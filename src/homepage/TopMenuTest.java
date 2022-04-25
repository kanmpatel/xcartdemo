package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";
    @Before
    public void setUpOpenBrowser(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully() {
        //click on shipping page
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[3]/child::a"));
        //Verify the text "Shipping"
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Shipping')]"));
        //verify the text using Assert method
        verifyTextMessage("Shipping",actualText);
    }
    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully(){
        //click on shipping page
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[4]/child::a"));
        //Verify the text "Shipping"
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'New arrivals')]"));
        //verify the text using Assert method
        verifyTextMessage("New arrivals",actualText);
    }
    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully(){
        //click on shipping page
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[5]/child::a"));
        //Verify the text "Shipping"
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Coming soon')]"));
        //verify the text using Assert method
        verifyTextMessage("Coming soon",actualText);
    }

    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully(){
        //click on shipping page
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[6]/child::a"));
        //Verify the text "Shipping"
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Contact us')]"));
        //verify the text using Assert method
        verifyTextMessage("Contact us",actualText);
    }

    @After
    public void SetUpCloseBrowser(){
        closeBrowser();
    }

}
