import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Task11 extends BaseUiTests {

    private String rozetkaUrl = "https://rozetka.com.ua/";
    String itemComputersAndLaptops = "//sidebar-fat-menu//a[contains(text(), 'Ноутбуки и компьютеры')]";
    String itemMonitors = "//fat-menu/div/ul/li[1]/div/div[2]/div[1]/div[2]/ul[2]/li/ul/li[1]";

    //    String itemMonitors = "//a[contains(text(),'Мониторы')]";
//    String itemMonitors1 = "//fat-menu//a[[text()=' Мониторы ']";
    String goodPicture = "a.goods-tile__picture";
    String prices = "span.goods-tile__price-value";
    String products = "span.goods-tile__title";
//  String menuCatalog = "//a[contains(text(), 'Ноутбуки и компьютеры')]";

    @BeforeMethod
    public void getUrl() {
        driver.get(rozetkaUrl);
    }

    @Test
    public void comparison() throws InterruptedException {
        Actions actions = new Actions(driver);

        wait.until(presenceOfElementLocated(By.xpath(itemComputersAndLaptops)));
        actions.moveToElement(driver.findElement(By.xpath(itemComputersAndLaptops))).build().perform();
        wait.until(visibilityOfElementLocated(By.xpath(itemMonitors)));
        driver.findElement(By.xpath(itemMonitors)).click();
        wait.until(visibilityOfElementLocated(By.cssSelector(goodPicture)));

        int firstPrice = 0;
        int firstPriceIndex = 0;
        String firstPriceWithoutSpaces;
        int counter = 0;
        List<WebElement> priceList = driver.findElements(By.cssSelector(prices));
        for (WebElement firstItemPrice : priceList) {
            firstPriceWithoutSpaces = firstItemPrice.getText().replaceAll("\\s+", "");
            firstPrice = Integer.parseInt(firstPriceWithoutSpaces);

            if (firstPrice < 3000) {
                firstPriceIndex = priceList.indexOf(firstItemPrice);
                counter++;
            }
            if (counter > 0) {
                break;
            }
        }

        System.out.println(firstPrice);


        List<WebElement> productList = driver.findElements(By.cssSelector(products));
        System.out.println(firstPriceIndex);
        String firstProductName = productList.get(firstPriceIndex).getText();
        System.out.println(firstProductName);

        driver.findElement(By.xpath("//span[@class='goods-tile__title'] [contains(text(), '" + firstProductName + "')]")).click();
        wait.until(visibilityOfElementLocated(By.cssSelector("button.compare-button"))).click();
        wait.until(visibilityOfElementLocated(By.xpath("//span[@class='header-actions__button-counter']")));
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='header-actions__button-counter']")).getText().contains("1"));
        driver.navigate().back();
        wait.until(visibilityOfElementLocated(By.cssSelector("a.goods-tile__picture")));


        int secondPrice;
        int secondPriceIndex = 0;
        String secondPriceWithoutSpaces;
        int counter1 = 0;
        List<WebElement> secondPriceList = driver.findElements(By.cssSelector(prices));
        for (WebElement secondItemPrice : secondPriceList) {
            secondPriceWithoutSpaces = secondItemPrice.getText().replaceAll("\\s+", "");
            secondPrice = Integer.parseInt(secondPriceWithoutSpaces);

            if (secondPrice < firstPrice) {
                secondPriceIndex = secondPriceList.indexOf(secondItemPrice);
                counter1++;
            }
            if (counter1 > 0) {
                break;
            }
        }

        List<WebElement> productList2 = driver.findElements(By.cssSelector(products));
        System.out.println(secondPriceIndex);
        String secondProductName = productList2.get(secondPriceIndex).getText();
        System.out.println(secondProductName);

        driver.findElement(By.xpath("//span[@class='goods-tile__title'] [contains(text(), '" + secondProductName + "')]")).click();
        wait.until(visibilityOfElementLocated(By.cssSelector("button.compare-button"))).click();
        wait.until(visibilityOfElementLocated(By.xpath("//span[@class='header-actions__button-counter']")));
//      wait.until(visibilityOfElementLocated(By.xpath("//span[@class='header-actions__button-counter']")));
        sleep(5000);
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='header-actions__button-counter']")).getText().contains("2"));

        driver.findElement(By.cssSelector("button.header-actions__button")).click();
        driver.findElement(By.cssSelector("a.comparison-modal__link")).click();
        wait.until(visibilityOfElementLocated(By.cssSelector("h1.comparison__heading")));
        sleep(5000);


        List<WebElement> compareList = driver.findElements(By.cssSelector("li.products-grid__cell"));
        assertThat(2, equalTo(compareList.size()));

        Assert.assertEquals(driver.findElement(By.linkText(firstProductName)).getText(), firstProductName);
        Assert.assertEquals(driver.findElement(By.linkText(secondProductName)).getText(), secondProductName);
//
//        System.out.println(driver.findElement(By.xpath("//rz-products-section/ul/li[1]/rz-compare-tile/div/div[2]/div[2]/div[1]/div")).getText());
//        System.out.println(driver.findElement(By.xpath("//rz-products-section/ul/li/rz-compare-tile/div/div/div/div/div[contains(., '999')]")).getText());


    }
}

