import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.AssertJUnit.assertEquals;

public class test2 extends BaseUiTests {
    String url = "https://rozetka.com.ua/";

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(url);
    }

    @Test

    public void Task2Part1() {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input")).sendKeys("samsung" + Keys.ENTER);
        wait.until(visibilityOfElementLocated(By.cssSelector("a.goods-tile__picture")));
        driver.findElement(By.xpath("//a[contains(@href,'mobile-phones')]//span[contains(text(),'Мобильные телефоны')]")).click();

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
        }

            @Test

            public void Task2Parr3() {
                driver.manage().window().maximize();
                driver.findElement(By.xpath("//input")).sendKeys("samsung" + Keys.ENTER);
                wait.until(visibilityOfElementLocated(By.cssSelector("a.goods-tile__picture")));
                driver.findElement(By.xpath("//a[contains(@href,'mobile-phones')]//span[contains(text(),'Мобильные телефоны')]")).click();



            }

}
