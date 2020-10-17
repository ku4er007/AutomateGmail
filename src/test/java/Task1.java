import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.AssertJUnit.assertTrue;

public class Task1 extends BaseUiTests {
    String url = "https://rozetka.com.ua/";
    
    @BeforeMethod
    public void navigateToUrl() {
        driver.get(url);
    }

    @Test
    public void positivEnterSearchTest() {
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

        WebElement sideMenu = driver.findElement(By.xpath("//a[contains(@href,'computers-notebooks')][@class='menu-categories__link']"));
        actions.moveToElement(sideMenu).perform();
        wait.until(visibilityOfElementLocated(By.xpath("//a[@class='menu__link'][contains(@href,'monitors/c80089')][contains(text(),'Мониторы')]")));
        WebElement selectOptions = driver.findElement(By.xpath("//a[@class='menu__link'][contains(@href,'monitors/c80089')][contains(text(),'Мониторы')]"));
        selectOptions.click();
        wait.until(visibilityOfElementLocated(By.cssSelector("a.goods-tile__picture")));

        List<WebElement> prices = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
        int count;
        for (count = 1; count <= prices.size(); count++) {
            String price = driver.findElement(By.xpath("//ul[@class='catalog-grid']//li[" + count + "]//span[@class='goods-tile__price-value']")).getText().replaceAll("\\s", "");
            int priceFiltered = Integer.parseInt(price);
            if (priceFiltered < 3000) {
                driver.findElement(By.xpath("//ul[@class='catalog-grid']//li[" + count + "]//a[@class='goods-tile__picture']")).click();
                System.out.println(price);
                break;
            }
        }
        wait.until(visibilityOfElementLocated(By.xpath("//*[@class='buy-button__label']")));
        driver.findElement(By.xpath("//*[@class='compare-button']")).click();
        wait.until(visibilityOfElementLocated(By.xpath("//*[@class='header-actions__button-counter'][contains(text(),'1')]")));
        driver.navigate().back();
        wait.until(visibilityOfElementLocated(By.cssSelector("a.goods-tile__picture")));

        List<WebElement> prices2 = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
        int count2;
        for (count2 = 1; count2 <= prices2.size(); count2++) {
            String price = driver.findElement(By.xpath("//ul[@class='catalog-grid']//li[" + count2 + "]//span[@class='goods-tile__price-value']")).getText().replaceAll("\\s", "");
            int priceFiltered = Integer.parseInt(price);
            if (priceFiltered < 2998) {
                driver.findElement(By.xpath("//ul[@class='catalog-grid']//li[" + count2 + "]//a[@class='goods-tile__picture']")).click();
                System.out.println(price);
                break;

            }
        }

        wait.until(visibilityOfElementLocated(By.xpath("//*[@class='buy-button__label']")));
        driver.findElement(By.xpath("//*[@class='compare-button']")).click();
        wait.until(visibilityOfElementLocated(By.xpath("//*[@class='header-actions__button-counter'][contains(text(),'2')]")));
        driver.findElement(By.xpath("//*[@class='header-actions__button-wrapper']//i")).click();
        wait.until(visibilityOfElementLocated(By.xpath("//h3[@class='modal__heading']")));
        driver.findElement(By.xpath("//a[@class='comparison-modal__link']")).click();
        WebElement stats = wait.until(visibilityOfElementLocated(By.xpath("//span[@class='header-actions__button-counter'][contains(text(),'2')]")));
        assertTrue(stats.getText().contains("2"));
        driver.findElement(By.xpath("//a[contains(@href,'samsung_c24f396f/p10592250')][@class='product__heading']"));


//        assertTrue(stats.getText().contains("//a[contains(@href,'samsung_c24f396f/p10592250')][@class='product__heading']"));


        ////a[contains(@href,'samsung_c24f396f/p10592250')][@class='product__heading']













//        List<WebElement> prices = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
//        int count;
//
//        for (count = 1; count <= prices.size(); count++) {
//            String price = driver.findElement(By.xpath("//ul[@class='catalog-grid']//li[" + count + "]//span[@class='goods-tile__price-value']")).getText().replaceAll("\\s", "");
//            int priceFiltered = Integer.parseInt(price);
//            if (priceFiltered < 3000) {
//                driver.findElement(By.xpath("//ul[@class='catalog-grid']//li[" + count + "]//a[@class='goods-tile__picture']")).click();
//                break;
//            }
//        }
//        wait.until(visibilityOfElementLocated(By.xpath("//*[@class='buy-button__label']")));
//        System.out.println(count);
//        driver.findElement(By.xpath(compare)).click();
//        wait.until(presenceOfElementLocated(By.xpath("//*[@class='header-actions__button-counter'][contains(text(),'1')]")));
//        System.out.println("test");
//
//


//        String firstElementPrice = driver.findElement(By.xpath("//p[@class='product-prices__big product-prices__big_color_red']")).getText().replaceAll("\\s","");


    }
}