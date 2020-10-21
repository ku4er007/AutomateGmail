package pagesRozetka2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class RozetkaProductListPage {
    WebDriver webDriver;
    WebDriverWait wait;

    public RozetkaProductListPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 5);
    }

    By minProductPrice = By.xpath("//input[@formcontrolname='min']");
    By maxProductPrice = By.xpath("//input[@formcontrolname='max']");
    String min2 = "5000";
    String max2 = "15000";
    By findAndClickOnButton = By.xpath("//button[@type='submit']");
    By filterPriceValue = By.xpath("//a[@class='catalog-selection__link'][contains(text(),' 5000-15000 ')]");
    By ram8GBProductFilter = By.xpath("//label[contains(text(), ' 8 ГБ')]");
    By ram6GBProductFilter = By.xpath("//label[contains(text(), ' 6 ГБ')]");
    By selectorProductFilter = By.xpath("//a[@class='catalog-selection__link']");
    By productTitle = By.cssSelector("span.goods-tile__title");



    public void checkAndSelectProductFilter(){
        webDriver.findElement(minProductPrice).clear();
        webDriver.findElement(minProductPrice).sendKeys(min2);
        webDriver.findElement(maxProductPrice).clear();
        webDriver.findElement(maxProductPrice).sendKeys(max2);
        webDriver.findElement(findAndClickOnButton).click();
    }
    public void waitPriceFilter(){
        wait.until(visibilityOfElementLocated(filterPriceValue));
    }
    public void waitAndClickOnRam8GBFilter(){
        wait.until(visibilityOfElementLocated(ram8GBProductFilter)).click();
        wait.until(visibilityOfElementLocated(ram8GBProductFilter));
    }
    public void waitAndClickOnRam6GBFilter(){
        wait.until(visibilityOfElementLocated(ram6GBProductFilter)).click();
        wait.until(visibilityOfElementLocated(ram6GBProductFilter));
    }
    public void waitSelectorProductFilter(){
        wait.until(visibilityOfElementLocated(selectorProductFilter));

    }
    public void checkProductFilter(){
        List<WebElement> itemsRam = webDriver.findElements(By.cssSelector("productTitle"));

    }


    }
