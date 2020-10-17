import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class task3049 extends BaseUiTests {
    String url = "https://rozetka.com.ua/";



    @Test
    public void positiveCompressionMonitorsTest() {
        driver.manage().window().maximize();
        driver.get(url);
        WebElement menu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//aside//a[contains(@href,'computers-notebooks')]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).build().perform();

        WebElement linkText = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Мониторы")));
        linkText.click();

        WebElement image = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='goods-tile__picture']//img")));

        List<WebElement> prices = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
        int count;

        for (count = 1; count <= prices.size(); count++) {
            String price = driver.findElement(By.xpath("//ul[@class='catalog-grid']//li[" + count + "]//span[@class='goods-tile__price-value']")).getText().replaceAll("\\s", "");
            int priceFiltered = Integer.parseInt(price);
            if (priceFiltered < 3000) {
                driver.findElement(By.xpath("//ul[@class='catalog-grid']//li[" + count + "]//a[@class='goods-tile__picture']")).click();
                break;
            }
        }

        WebElement tab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='tabs__link tabs__link--active']")));


        WebElement compare = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='compare-button']")));
        compare.click();

        WebElement figure = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//figure[@class='product-photo__large-inner']")));


        String firstElementPrice = driver.findElement(By.xpath("//p[@class='product-prices__big product-prices__big_color_red']")).getText().replaceAll("\\s", "").replaceAll("₴", "");
        int firstPriceFiltered = Integer.parseInt(firstElementPrice);
        String name1 = driver.findElement(By.xpath("//h1[@class='product__title']")).getText();

        WebElement icon = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button//span[contains(text(), '1')]")));


        driver.navigate().back();

        WebElement image2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='goods-tile__picture']//img")));


        List<WebElement> pricesSecond = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
        int countSecond;


        for (countSecond = 1; countSecond <= pricesSecond.size(); countSecond++) {
            String priceSecond = driver.findElement(By.xpath("//ul[@class='catalog-grid']//li[" + countSecond + "]//span[@class='goods-tile__price-value']")).getText().replaceAll("\\s", "");
            int priceFiltered = Integer.parseInt(priceSecond);
            if (priceFiltered < firstPriceFiltered) {
                driver.findElement(By.xpath("//ul[@class='catalog-grid']//li[" + countSecond + "]//a[@class='goods-tile__picture']")).click();
                break;
            }
        }

        WebElement compareSecondItem = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='compare-button']")));
        compareSecondItem.click();


        String secondElementPrice = driver.findElement(By.xpath("//p[@class='product-prices__big product-prices__big_color_red']")).getText().replaceAll("\\s", "").replaceAll("₴", "");
        int secondElementFiltered = Integer.parseInt(secondElementPrice);
        String name2 = driver.findElement(By.xpath("//h1[@class='product__title']")).getText();


        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button//span[contains(text(), '2')]")));

        driver.findElement(By.xpath("//button[@class='header-actions__button header-actions__button_type_compare header-actions__button_state_active']")).click();
        WebElement checkCountMonitors = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='comparison-modal__link']//span[contains(text(), '2')]")));
        driver.findElement(By.xpath("//a[@class='comparison-modal__link']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='product__picture']")));


        String priceInCompareMenufirst = driver.findElement(By.xpath("//ul[@class = 'products-grid']//li[1]//*[@class = 'product__prices']/div")).getText().replaceAll(" +", "").replaceAll("₴", "");
        String first1 = priceInCompareMenufirst.substring(5, 9);
        int first = Integer.parseInt(first1);


        String nameComparePage1 = driver.findElement(By.xpath("//ul[@class = 'products-grid']//li[1]//*[@class = 'product__body']/div/a")).getText();


        String priceInCompareMenusecond = driver.findElement(By.xpath("//ul[@class = 'products-grid']//li[2]//*[@class = 'product__prices']/div")).getText().replaceAll(" +", "").replaceAll("₴", "");
        String second1 = priceInCompareMenusecond.substring(5, 9);
        int second = Integer.parseInt(second1);

        String nameComparePage2 = driver.findElement(By.xpath("//ul[@class = 'products-grid']//li[2]//*[@class = 'product__body']/div/a")).getText();

        assertEquals(name1, nameComparePage1);
        assertEquals(name2, nameComparePage2);


        assertEquals(firstPriceFiltered, first);
        assertEquals(secondElementFiltered, second);


    }

}
