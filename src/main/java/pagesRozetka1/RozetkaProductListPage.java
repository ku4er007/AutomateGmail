package pagesRozetka1;

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

    By findGoodsTitle = By.xpath("//span[@class='goods-tile__price-value']");
    By productPictures = By.cssSelector("a.goods-tile__picture");

    public void selectProductLess3000Grn(){
        List<WebElement> prices = webDriver.findElements(findGoodsTitle);
        int count;
        for (count = 1; count <= prices.size(); count++) {
            String price = webDriver.findElement(By.xpath("//ul[@class='catalog-grid']//li[" + count + "]//span[@class='goods-tile__price-value']")).getText().replaceAll("\\s", "");
            int priceFiltered = Integer.parseInt(price);
            if (priceFiltered < 3000) {
                webDriver.findElement(By.xpath("//ul[@class='catalog-grid']//li[" + count + "]//a[@class='goods-tile__picture']")).click();
                break;
            }
        }
    }

    public void selectProductLessThanFirstProduct(){
        List<WebElement> pricesSecond = webDriver.findElements(findGoodsTitle);
        int countSecond;
        for (countSecond = 1; countSecond <= pricesSecond.size(); countSecond++) {
            String priceSecond = webDriver.findElement(By.xpath("//ul[@class='catalog-grid']//li[" + countSecond + "]//span[@class='goods-tile__price-value']")).getText().replaceAll("\\s", "");
            int priceFiltered = Integer.parseInt(priceSecond);
            if (priceFiltered < countSecond) {
                webDriver.findElement(By.xpath("//ul[@class='catalog-grid']//li[" + countSecond + "]//a[@class='goods-tile__picture']")).click();
                break;
            }
        }
    }

    public void waitProductPictures(){
        wait.until(visibilityOfElementLocated(productPictures));
    }

}
