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

public class Task2 extends BaseUiTests {
    String input = "//input";
    String url = "https://rozetka.com.ua/";
    String query = "samsung";
    String pictures = "a.goods-tile__picture";
    String mobPhone = "//a[contains(@href,'mobile-phones')]//span[contains(text(),'Мобильные телефоны')]";
    String apple = "//label[contains(text(), 'Apple')]";
    String honor = "//label[contains(text(), 'Honor')]";
    String productTitle = "span.goods-tile__title";
    String samsung = "Samsung";
    String honor1 = "Honor";
    String apple1 = "Apple";
    String min = "//input[@formcontrolname='min']";
    String min2 = "5000";
    String max2 = "15000";
    String max = "//input[@formcontrolname='max']";
    String ram8Gb = "//label[contains(text(), ' 8 ГБ')]";
    String ram6Gb = "//label[contains(text(), ' 6 ГБ')]";
    String gb8 = "8 ГБ";
    String gb6 = "6 ГБ";
    String okButton = "//button[@type='submit']";
    String productValue = "span.goods-tile__price-value";
    String valueFilter = "//a[@class='catalog-selection__link'][contains(text(),' 5000-15000 ')]";
    String selector = "//a[@class='catalog-selection__link']";

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
        wait.until(visibilityOfElementLocated(By.xpath(apple))).click();
        wait.until(visibilityOfElementLocated(By.xpath(apple)));
        driver.findElement(By.xpath(honor)).click();
        wait.until(visibilityOfElementLocated(By.xpath(honor)));
        List<WebElement> items = driver.findElements(By.cssSelector(productTitle));
        for (WebElement lable : items) {

            if (!lable.getText().contains(samsung)) {
                if (!lable.getText().contains(honor1)) {
                    if (!lable.getText().contains(apple1)) {
                        assertTrue(false);
                    }
                }
            }
        }
    }

    @Test

    public void Task2Part2() {
        driver.manage().window().maximize();
        driver.findElement(By.xpath(input)).sendKeys(query + Keys.ENTER);
        wait.until(visibilityOfElementLocated(By.cssSelector(pictures)));
        driver.findElement(By.xpath(mobPhone)).click();
        wait.until(visibilityOfElementLocated(By.cssSelector(pictures)));
        driver.findElement(By.xpath(min)).clear();
        driver.findElement(By.xpath(min)).sendKeys(min2);
        driver.findElement(By.xpath(max)).clear();
        driver.findElement(By.xpath(max)).sendKeys(max2);
        driver.findElement(By.xpath(okButton)).click();
        wait.until(visibilityOfElementLocated(By.xpath(valueFilter)));
    }


    @Test

    public void Task2Parr3() {
        driver.manage().window().maximize();
        driver.findElement(By.xpath(input)).sendKeys(query + Keys.ENTER);
        wait.until(visibilityOfElementLocated(By.cssSelector(pictures)));
        driver.findElement(By.xpath(mobPhone)).click();
        wait.until(visibilityOfElementLocated(By.xpath(ram8Gb))).click();
        wait.until(visibilityOfElementLocated(By.xpath(ram8Gb)));
        wait.until(visibilityOfElementLocated(By.xpath(ram6Gb))).click();
        wait.until(visibilityOfElementLocated(By.xpath(ram6Gb)));
        wait.until(visibilityOfElementLocated(By.xpath(selector)));


        List<WebElement> itemsRam = driver.findElements(By.xpath(productTitle));
        for (WebElement lable : itemsRam) {

            if (!lable.getText().contains(samsung)) {
                if (!lable.getText().contains(gb8)) {
                    if (!lable.getText().contains(gb6)) {
                        assertTrue(false);
                    }
                }
            }
        }
    }
}
