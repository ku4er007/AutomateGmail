import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.Assert.assertEquals;

public class Task1v2 extends BaseUiTests {
    String url = "https://rozetka.com.ua/";
    String goodsTitle = "//span[@class='goods-tile__price-value']";
    String goodsPic = "a.goods-tile__picture";
    String compareButton = "//button[@class='compare-button']";
    String productPrice = "//p[@class='product-prices__big product-prices__big_color_red']";
    String productTitle2 = "//h1[@class='product__title']";
    String computerNetbook = "//a[contains(@href,'computers-notebooks')][@class='menu-categories__link']";
    String monitors = "//a[@class='menu__link'][contains(@href,'monitors/c80089')][contains(text(),'Мониторы')]";
    String one = "//button//span[contains(text(), '1')]";
    String tow = "//button//span[contains(text(), '2')]";
    String pic = "//a[@class='goods-tile__picture']//img";
    String productPhoto = "//figure[@class='product-photo__large-inner']";
    String tab = "//a[@class='tabs__link tabs__link--active']";
    String compere = "//button[@class='header-actions__button header-actions__button_type_compare header-actions__button_state_active']";
    String compereModel = "//a[@class='comparison-modal__link']";
    String assertTow = "//a[@class='comparison-modal__link']//span[contains(text(), '2')]";
    String productPrice1 = "//ul[@class = 'products-grid']//li[1]//*[@class = 'product__prices']/div";
    String productPrice2 = "//ul[@class = 'products-grid']//li[2]//*[@class = 'product__prices']/div";
    String productBody = "//ul[@class = 'products-grid']//li[1]//*[@class = 'product__body']/div/a";
    String productBody2 = "//ul[@class = 'products-grid']//li[2]//*[@class = 'product__body']/div/a";
    String productPic = "//div[@class='product__picture']";


    @BeforeMethod
    public void navigateToUrl() {
        driver.get(url);
    }

    @Test
    public void positivEnterSearchTest() {
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebElement sideMenu = driver.findElement(By.xpath(computerNetbook));
        actions.moveToElement(sideMenu).perform();
        wait.until(visibilityOfElementLocated(By.xpath(monitors)));
        WebElement selectOptions = driver.findElement(By.xpath(monitors));
        selectOptions.click();
        wait.until(visibilityOfElementLocated(By.cssSelector(goodsPic)));
        List<WebElement> prices = driver.findElements(By.xpath(goodsTitle));
        int count;
        for (count = 1; count <= prices.size(); count++) {
            String price = driver.findElement(By.xpath("//ul[@class='catalog-grid']//li[" + count + "]//span[@class='goods-tile__price-value']")).getText().replaceAll("\\s", "");
            int priceFiltered = Integer.parseInt(price);
            if (priceFiltered < 3000) {
                driver.findElement(By.xpath("//ul[@class='catalog-grid']//li[" + count + "]//a[@class='goods-tile__picture']")).click();
                break;
            }
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tab)));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(compareButton))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productPhoto)));
        String firstProd = driver.findElement(By.xpath(productPrice)).getText().replaceAll("\\s", "").replaceAll("₴", "");
        int firstProdFiltered = Integer.parseInt(firstProd);
        driver.findElement(By.xpath(productTitle2)).getText();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(one)));
        driver.navigate().back();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(pic)));
        List<WebElement> pricesSecond = driver.findElements(By.xpath(goodsTitle));
        int countSecond;
        for (countSecond = 1; countSecond <= pricesSecond.size(); countSecond++) {
            String priceSecond = driver.findElement(By.xpath("//ul[@class='catalog-grid']//li[" + countSecond + "]//span[@class='goods-tile__price-value']")).getText().replaceAll("\\s", "");
            int priceFiltered = Integer.parseInt(priceSecond);
            if (priceFiltered < firstProdFiltered) {
                driver.findElement(By.xpath("//ul[@class='catalog-grid']//li[" + countSecond + "]//a[@class='goods-tile__picture']")).click();
                break;
            }
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(compareButton))).click();
        String secondProdElement = driver.findElement(By.xpath(productPrice)).getText().replaceAll("\\s", "").replaceAll("₴", "");
        int secondProdFiltered = Integer.parseInt(secondProdElement);
        driver.findElement(By.xpath(productTitle2)).getText();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tow)));
        driver.findElement(By.xpath(compere)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(assertTow)));
        driver.findElement(By.xpath(compereModel)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productPic)));
        String oneProdCompareMenu = driver.findElement(By.xpath(productPrice1)).getText().replaceAll(" +", "").replaceAll("₴", "");
        String first1 = oneProdCompareMenu.substring(5, 9);
        int first = Integer.parseInt(first1);
        driver.findElement(By.xpath(productBody)).getText();
        String secondProdCompareMenu = driver.findElement(By.xpath(productPrice2)).getText().replaceAll(" +", "").replaceAll("₴", "");
        String second1 = secondProdCompareMenu.substring(5, 9);
        int second = Integer.parseInt(second1);
        driver.findElement(By.xpath(productBody2)).getText();
        assertEquals(firstProdFiltered, first);
        assertEquals(secondProdFiltered, second);
    }
}


//        WebElement compareSecondItem = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='compare-button']")));
//        compareSecondItem.click();
//
//
//        String secondElementPrice = driver.findElement(By.xpath("//p[@class='product-prices__big product-prices__big_color_red']")).getText().replaceAll("\\s", "").replaceAll("₴", "");
//        int secondElementFiltered = Integer.parseInt(secondElementPrice);
//        String name2 = driver.findElement(By.xpath("//h1[@class='product__title']")).getText();
//
//        driver.findElement(By.xpath("//span[@class='goods-tile__title'] [contains(text(), '" + secondElementFiltered + "')]")).click();
//        wait.until(visibilityOfElementLocated(By.xpath("//*[@class='compare-button']"))).click();
//        wait.until(visibilityOfElementLocated(By.xpath("//*[@class='header-actions__button-counter'][contains(text(),'2')]")));
//        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='header-actions__button-counter'][contains(text(),'2')]")).getText().contains("2"));


//
////        for (count = 1; count <= prices.size(); count++) {
////            String price = driver.findElement(By.xpath("//ul[@class='catalog-grid']//li[" + count + "]//span[@class='goods-tile__price-value']")).getText().replaceAll("\\s", "");
////            int priceFiltered = Integer.parseInt(price);
////            if (priceFiltered < 3000) {
////                Price1Index = price.indexOf(ItemPrice);
////                for (WebElement firstItemPrice : priceList) {
////                    firstPriceWithoutSpaces = firstItemPrice.getText().replaceAll("\\s+", "");
////                    firstPrice = Integer.parseInt(firstPriceWithoutSpaces);
////
////                driver.findElement(By.xpath("//ul[@class='catalog-grid']//li[" + count + "]//a[@class='goods-tile__picture']")).click();
////                System.out.println(price);
////                break;
////            }
////        }
//
//
//        List<WebElement> itemList = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
//        String productName = itemList.get(price1Index).getText();
//
//        driver.findElement(By.xpath("//span[@class='goods-tile__title'] [contains(text(), '" + productName + "')]")).click();
//        wait.until(visibilityOfElementLocated(By.xpath("//*[@class='compare-button']"))).click();
//        wait.until(visibilityOfElementLocated(By.xpath("//*[@class='header-actions__button-counter'][contains(text(),'1')]")));
//        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='header-actions__button-counter'][contains(text(),'1')]")).getText().contains("1"));
//        driver.navigate().back();
//        wait.until(visibilityOfElementLocated(By.xpath("a.goods-tile__picture")));
//
//        int price2 = 0;
//        int price2Index = 0;
//        String price21;
//        int counter1 = 0;
//        List<WebElement> pricesList2 = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
//        for (WebElement itemPrice2 : pricesList2) {
//            price21 = itemPrice2.getText().replaceAll("\\s+", "");
//            price2 = Integer.parseInt(price21);
//
//            if (price2 < price1) {
//                price2Index = pricesList2.indexOf(itemPrice2);
//                counter1++;
//            }
//            if (counter1 > 0) {
//                break;
//            }
//        }
//        List<WebElement> itemList2 = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
//        String product2 = itemList2.get(price2Index).getText();
//
//        driver.findElement(By.xpath("//span[@class='goods-tile__title'] [contains(text(), '" + price2Index + "')]")).click();
//        wait.until(visibilityOfElementLocated(By.xpath("//*[@class='compare-button']"))).click();
//        wait.until(visibilityOfElementLocated(By.xpath("//*[@class='header-actions__button-counter'][contains(text(),'2')]")));
//        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='header-actions__button-counter'][contains(text(),'2')]")).getText().contains("2"));
//
//
//        driver.findElement(By.xpath("//*[@class='compare-button']")).click();
//        driver.findElement(By.cssSelector("compareLink")).click();
//        wait.until(visibilityOfElementLocated(By.cssSelector("h1.comparison__heading")));
//
//
//        List<WebElement> compare = driver.findElements(By.cssSelector("li.products-grid__cell"));
//        assertThat(2, equalTo(compare.size()));

//        List<WebElement> checkList = driver.findElements(By.cssSelector("div.product"));
//        assertThat(checkList.get(0).findElement(By.cssSelector(productTitleInCompare)).getText(), equalTo(price1Index));
//        assertThat(checkList.get(1).findElement(By.cssSelector(productTitleInCompare)).getText(), equalTo(price2Index));
//
//        String firstPriceInCompare = checkList.get(0).findElement(By.cssSelector("div.product__price.product__price--red")).getText().replaceAll("\\s+", "").substring(5, 9);
//        int intFirstPriceInCompare = Integer.parseInt(firstPriceInCompare);
//        String secondPriceInCompare = checkList.get(1).findElement(By.cssSelector("div.product__price.product__price--red")).getText().replaceAll("\\s+", "").substring(5, 9);
//        int intSecondPriceInCompare = Integer.parseInt(secondPriceInCompare);
//
//
//        assertThat(intFirstPriceInCompare, equalTo(price1));
////        assertThat(intSecondPriceInCompare, equalTo(price2));
//    }
//}
//

//
//        wait.until(visibilityOfElementLocated(By.xpath("//*[@class='buy-button__label']")));
//        driver.findElement(By.xpath("//*[@class='compare-button']")).click();
//        wait.until(visibilityOfElementLocated(By.xpath("//*[@class='header-actions__button-counter'][contains(text(),'1')]")));
//        driver.navigate().back();
//        wait.until(visibilityOfElementLocated(By.cssSelector("a.goods-tile__picture")));

//
//        int firstPrice = 0;
//        int firstPriceIndex = 0;
//        String firstPriceWithoutSpaces;
//        int counter = 0;
//        List<WebElement> priceList = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
//        for (WebElement firstItemPrice : priceList) {
//            firstPriceWithoutSpaces = firstItemPrice.getText().replaceAll("\\s+", "");
//            firstPrice = Integer.parseInt(firstPriceWithoutSpaces);
//
//            if (firstPrice < 3000) {
//                firstPriceIndex = priceList.indexOf(firstItemPrice);
//                counter++;
//            }
//            if (counter > 0) {
//                break;
//            }
//        }
//
//        List<WebElement> itemList = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
//        String firstName = itemList.get(firstPriceIndex).getText();
//
//        String productTitle = "//span[@class='goods-tile__title'] [contains(text(), '" + firstName + "')]";
//        wait.until(visibilityOfElementLocated(By.cssSelector("button.compare-button"))).click();
//        wait.until(visibilityOfElementLocated(By.xpath("//span[@class='header-actions__button-counter']")));
//        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='header-actions__button-counter']")).getText().contains("1"));
////        driver.navigate().back();
////        wait.until(visibilityOfElementLocated(By.cssSelector("a.goods-tile__picture")));
//
//
//        int secondPrice;
//        int secondPriceIndex = 0;
//        String secondPriceWithoutSpaces;
//        int counter1 = 0;
//        List<WebElement> secondPriceList = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
//        for (WebElement secondItemPrice : secondPriceList) {
//            secondPriceWithoutSpaces = secondItemPrice.getText().replaceAll("\\s+", "");
//            secondPrice = Integer.parseInt(secondPriceWithoutSpaces);
//
//            if (secondPrice < firstPrice) {
//                secondPriceIndex = secondPriceList.indexOf(secondItemPrice);
//                counter1++;
//            }
//            if (counter1 > 0) {
//                break;
//            }
//        }
//
//        List<WebElement> productList2 = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
//        String secondProductName = productList2.get(secondPriceIndex).getText();
//
//        driver.findElement(By.xpath("//span[@class='goods-tile__title'] [contains(text(), '" + secondProductName + "')]")).click();
//        wait.until(visibilityOfElementLocated(By.cssSelector("button.compare-button"))).click();
//        wait.until(visibilityOfElementLocated(By.xpath("//span[@class='header-actions__button-counter']")));
//        sleep(5000);
//        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='header-actions__button-counter']")).getText().contains("2"));
//
//        driver.findElement(By.cssSelector("button.header-actions__button")).click();
//        driver.findElement(By.cssSelector("a.comparison-modal__link")).click();
//        wait.until(visibilityOfElementLocated(By.cssSelector("h1.comparison__heading")));
//        sleep(5000);
//
//        WebElement stats = wait.until(visibilityOfElementLocated(By.xpath("//span[@class='header-actions__button-counter'][contains(text(),'2')]")));
//        assertTrue(stats.getText().contains("2"));
//
//
//
//    }
//}