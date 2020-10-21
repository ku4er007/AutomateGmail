package pagesRozetka2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class RozetkaMainPage {
    WebDriver webDriver;
    WebDriverWait wait;

    public RozetkaMainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 5);
    }
    String query = "samsung";
    By searchInputField = By.xpath("//input");
    By productPictures = By.cssSelector("a.goods-tile__picture");
    By mobilePhoneElement = By.xpath("//a[contains(@href,'mobile-phones')]//span[contains(text(),'Мобильные телефоны')]");
    By appleFilterElement = By.xpath("//label[contains(text(), 'Apple')]");
    By honorFilterElement = By.xpath("//label[contains(text(), 'Honor')]");
    By productTitle = By.className("span.goods-tile__title");

    public void enterSearchQuery() {
        webDriver.findElement(searchInputField).sendKeys(query + Keys.ENTER);
    }
    public void findeMobileElementAndClick(){
        webDriver.findElement(mobilePhoneElement).click();
    }
    public void showHonorFilterElementAndClick(){
        webDriver.findElement(honorFilterElement).click();
    }
    public void checkSelectedFilters(){
        List<WebElement> items = webDriver.findElements(productTitle);
    }
    public void waitProductPictures(){
        wait.until(visibilityOfElementLocated(productPictures));
    }
    public void showAppleFilterElementAndClick(){
        wait.until(visibilityOfElementLocated(appleFilterElement)).click();
        wait.until(visibilityOfElementLocated(appleFilterElement));
    }
    public void waitHonorFilterElementAndClick(){
        wait.until(visibilityOfElementLocated(honorFilterElement));
    }
}
