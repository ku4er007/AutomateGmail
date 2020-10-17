//2) Verification of 3 filters (manufacturer, price, your own choice)
//
//1. Navigate to https://rozetka.com.ua/
//2. Search by "samsung"
//3. Click "Мобильные телефоны" in the product filters panel
//4. Add to filters "Apple" and "Honor"
//5. Verify all filtered products are products made by Samsung, Apple or Honor
//
//1. Navigate to https://rozetka.com.ua/
//2. Search by "samsung"
//3. Click "Мобильные телефоны" in the product filters panel
//4. Add to price filter: 5000<price<15000
//5. Verify all filtered products are products with price from range
//
//1. Navigate to https://rozetka.com.ua/
//2. Search by "samsung"
//3. Click "Мобильные телефоны" in the product filters panel
//4. Add filter value (your choice)
//5. Verify all filtered products are products according to filter

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.AssertJUnit.assertTrue;

public class test2 extends BaseUiTests {
    String input = "//input";
    String url = "https://rozetka.com.ua/";
    String query = "samsung";
    String pictures = "a.goods-tile__picture";
    String mobPhone = "//a[contains(@href,'mobile-phones')]//span[contains(text(),'Мобильные телефоны')]";
    String iphone = "//label[contains(text(), 'Apple')]";
    String honor = "//label[contains(text(), 'Honor')]";
    String productTitle = "span.goods-tile__title";
    String productPrice = "span.goods-tile__price-value";
    String a = "Samsung";
    String b = "Honor";
    String c = "Apple";
    String min = "//input[@class='slider-filter__input ng-pristine ng-valid ng-touched']";


    @BeforeMethod
    public void navigateToUrl() {
        driver.get(url);
    }

    @Test

    public void Task2Part1() {
        driver.manage().window().maximize();
        driver.findElement(By.xpath(input)).sendKeys(query + Keys.ENTER);
        wait.until(visibilityOfElementLocated(By.cssSelector(pictures)));
        driver.findElement(By.xpath(mobPhone)).click();
        wait.until(visibilityOfElementLocated(By.xpath(iphone))).click();
        wait.until(visibilityOfElementLocated(By.xpath(iphone)));
        driver.findElement(By.xpath(honor)).click();
        wait.until(visibilityOfElementLocated(By.xpath(honor)));
        List<WebElement> items = driver.findElements(By.cssSelector(productTitle));
        for (WebElement lable : items) {

            if (!lable.getText().contains(a)) {
                if (!lable.getText().contains(b)) {
                    if (!lable.getText().contains(c)) {
                        assertTrue(false);
                    }
                }
            }
        }


//        wait.until(visibilityOfElementLocated(By.xpath("//*[@class='catalog-selection__link catalog-selection__link_type_reset']"))).click();
//        assertEquals(driver.getCurrentUrl(), "https://rozetka.com.ua/mobile-phones/c80003/");
////        wait.until(visibilityOfElementLocated(By.xpath("//input[@type='checkbox' and @id='Apple']"))).click();
//        wait.until(visibilityOfElementLocated(By.xpath("https://rozetka.com.ua/mobile-phones/c80003/producer=apple/"))).click();
//        assertEquals(driver.getCurrentUrl(), "https://rozetka.com.ua/mobile-phones/c80003/producer=apple/");


        //a[@class='catalog-selection__link'][contains(@href,'c80003')]
    }

    @Test

    public void Task2Part2() {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input")).sendKeys("samsung" + Keys.ENTER);
        wait.until(visibilityOfElementLocated(By.cssSelector("a.goods-tile__picture")));
        driver.findElement(By.xpath("//a[contains(@href,'mobile-phones')]//span[contains(text(),'Мобильные телефоны')]")).click();
        driver.findElement(By.xpath("//input[@class='slider-filter__input ng-pristine ng-valid ng-touched']")).sendKeys("5000" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@class='slider-filter__input ng-untouched ng-pristine ng-valid']")).sendKeys("15000" + Keys.ENTER);
//
//        List<WebElement> filter2 = driver.findElements(By.cssSelector(productPrice));
//        for (WebElement lable : filter2) {
//
//            if (!lable.getText().contains(a)) {
//                if (!lable.getText().contains(b)) {
//                    if (!lable.getText().contains(c)) {
//                        assertTrue(false);
//                    }
//                }
//            }
//        }

    }

    @Test

    public void Task2Parr3() {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input")).sendKeys("samsung" + Keys.ENTER);
        wait.until(visibilityOfElementLocated(By.cssSelector("a.goods-tile__picture")));
        driver.findElement(By.xpath("//a[contains(@href,'mobile-phones')]//span[contains(text(),'Мобильные телефоны')]")).click();


    }

}
