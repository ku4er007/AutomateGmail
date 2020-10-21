package pagesRozetka1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RozetkaGoodDetailsPage {
    WebDriver webDriver;
    WebDriverWait wait;

    public RozetkaGoodDetailsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 5);
    }

    By allProductTabElement = By.xpath("//a[@class='tabs__link tabs__link--active']");
    By compareButtonElement = By.xpath("//button[@class='compare-button']");
    By productPictureElement = By.xpath("//figure[@class='product-photo__large-inner']");
    By oneItemInCompare = By.xpath("//button//span[contains(text(), '1')]");
    By twoItemInCompare = By.xpath("//button//span[contains(text(), '2')]");
    By productPriseValue = By.xpath("//p[@class='product-prices__big product-prices__big_color_red']");
    By productNameValue = By.xpath("//h1[@class='product__title']");
    By compareButtonElementOnHeader = By.xpath("//button[@class='header-actions__button header-actions__button_type_compare header-actions__button_state_active']");
    By compareNumberInModalWindow = By.xpath("//a[@class='comparison-modal__link']//span[contains(text(), '2')]");
    By compareNameInModalWindow = By.xpath("//a[@class='comparison-modal__link']");


    public void rememberFirstNameAndPrice(){
        webDriver.findElement(productNameValue).getText();
    }
    public void rememberSecondNameAndPrice(){
        webDriver.findElement(productNameValue).getText();
    }
    public void compareButtonInHeader(){
        webDriver.findElement(compareButtonElementOnHeader).click();
    }
    public void nameOfCompareProduct(){
        webDriver.findElement(compareNameInModalWindow).click();
    }

    public void waitAllProductTabElenent() {
        wait.until(ExpectedConditions.presenceOfElementLocated(allProductTabElement));
    }
    public void waitCompareButtonElement() {
        wait.until(ExpectedConditions.presenceOfElementLocated(compareButtonElement)).click();
    }
    public void waitProductPictureElement(){
        wait.until(ExpectedConditions.presenceOfElementLocated(productPictureElement));
    }

    public void firstWaitProductPageElenent(){
        wait.until(ExpectedConditions.presenceOfElementLocated(oneItemInCompare));
    }
    public void secondWaitProductPageElenent(){
        wait.until(ExpectedConditions.presenceOfElementLocated(twoItemInCompare));
    }
    public void waitCompareNumberInModalWindow(){
        wait.until(ExpectedConditions.presenceOfElementLocated(compareNumberInModalWindow));
    }

    public void moveBack(){
        webDriver.navigate().back();
    }
}
