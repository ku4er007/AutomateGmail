
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesRozetka2.RozetkaMainPage;
import pagesRozetka2.RozetkaProductListPage;

import static org.testng.AssertJUnit.assertTrue;

public class forRozetka2 extends BaseUiTests {
    String url = "https://rozetka.com.ua/";
    String samsung = "Samsung";
    String honor1 = "Honor";
    String apple1 = "Apple";
    String gb8 = "8 ГБ";
    String gb6 = "6 ГБ";
    @BeforeMethod
    public void navigateToUrl() {
        driver.get(url);
    }

    @Test

    public void Task2Part1() {
        RozetkaMainPage rozetkaMainPage = new RozetkaMainPage(driver);
        rozetkaMainPage.maximaseScreen();
        rozetkaMainPage.enterSearchQuery();
        rozetkaMainPage.waitProductPictures();
        rozetkaMainPage.findeMobileElementAndClick();
        rozetkaMainPage.showAppleFilterElementAndClick();
        rozetkaMainPage.showHonorFilterElementAndClick();
        rozetkaMainPage.waitHonorFilterElementAndClick();
        rozetkaMainPage.checkSelectedFilters();
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
        RozetkaMainPage rozetkaMainPage = new RozetkaMainPage(driver);
        rozetkaMainPage.maximaseScreen();
        rozetkaMainPage.enterSearchQuery();
        rozetkaMainPage.waitProductPictures();
        rozetkaMainPage.findeMobileElementAndClick();
        RozetkaProductListPage rozetkaProductListPage = new RozetkaProductListPage(driver);
        rozetkaProductListPage.checkAndSelectProductFilter();
        rozetkaProductListPage.waitPriceFilter();
    }


    @Test

    public void Task2Parr3() {
        RozetkaMainPage rozetkaMainPage = new RozetkaMainPage(driver);
        rozetkaMainPage.maximaseScreen();
        rozetkaMainPage.enterSearchQuery();
        rozetkaMainPage.waitProductPictures();
        rozetkaMainPage.findeMobileElementAndClick();
        RozetkaProductListPage rozetkaProductListPage = new RozetkaProductListPage(driver);
        rozetkaProductListPage.waitAndClickOnRam8GBFilter();
        rozetkaProductListPage.waitAndClickOnRam6GBFilter();
        rozetkaProductListPage.waitSelectorProductFilter();
        rozetkaProductListPage.checkProductFilter();
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
