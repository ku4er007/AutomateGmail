package pagesRozetka1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RozetkaComparePage {
    WebDriver webDriver;
    WebDriverWait wait;


    public RozetkaComparePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 5);
    }

    By productPictureOnCompareList = By.xpath("//div[@class='product__picture']");
    By firstProductPriceValue = By.xpath("//ul[@class = 'products-grid']//li[1]//*[@class = 'product__prices']/div");
    By secondProductPriceValue = By.xpath("//ul[@class = 'products-grid']//li[2]//*[@class = 'product__prices']/div");
    By firstProductNameValue = By.xpath("//ul[@class = 'products-grid']//li[1]//*[@class = 'product__body']/div/a");
    By secondProductNameValue = By.xpath("//ul[@class = 'products-grid']//li[2]//*[@class = 'product__body']/div/a");

    public void comparisonOfTwoProducts() {
        String oneProdCompareMenu = webDriver.findElement(firstProductPriceValue).getText().replaceAll(" +", "").replaceAll("₴", "");
        String first1 = oneProdCompareMenu.substring(5, 9);
        int first = Integer.parseInt(first1);
        webDriver.findElement(firstProductNameValue).getText();
        String secondProdCompareMenu = webDriver.findElement(secondProductPriceValue).getText().replaceAll(" +", "").replaceAll("₴", "");
        String second1 = secondProdCompareMenu.substring(5, 9);
        int second = Integer.parseInt(second1);
        webDriver.findElement(secondProductNameValue).getText();
    }
    public void waitProductPicture() {
        wait.until(ExpectedConditions.presenceOfElementLocated(productPictureOnCompareList));
    }
}
