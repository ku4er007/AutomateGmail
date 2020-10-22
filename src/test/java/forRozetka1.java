import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesRozetka1.RozetkaComparePage;
import pagesRozetka1.RozetkaGoodDetailsPage;
import pagesRozetka1.RozetkaMainPage;
import pagesRozetka1.RozetkaProductListPage;
import static org.testng.Assert.assertEquals;

public class forRozetka1 extends BaseUiTests {
    String url = "https://rozetka.com.ua/";
    String productPrice = "//p[@class='product-prices__big product-prices__big_color_red']";

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(url);
    }

    @Test
    public void positivEnterSearchTest() {
        //RozetkaMainPage
        RozetkaMainPage rozetkaMainPage = new RozetkaMainPage(driver);
        rozetkaMainPage.maximaseScreen();
        rozetkaMainPage.selectingSideMenuItem();
        rozetkaMainPage.waitMonitorItem();
        rozetkaMainPage.selectMonitorInList();

        //RozetkaProductListPage
        RozetkaProductListPage rozetkaProductListPage = new RozetkaProductListPage(driver);
        rozetkaProductListPage.waitProductPictures();
        rozetkaProductListPage.selectProductLess3000Grn();

        //RozetkaGoodDetailsPage
        RozetkaGoodDetailsPage rozetkaGoodDetailsPage = new RozetkaGoodDetailsPage(driver);
        rozetkaGoodDetailsPage.waitAllProductTabElenent();
        rozetkaGoodDetailsPage.waitCompareButtonElement();
        rozetkaGoodDetailsPage.waitProductPictureElement();
        rozetkaGoodDetailsPage.rememberFirstNameAndPrice();
        rozetkaGoodDetailsPage.firstWaitProductPageElenent();
        rozetkaGoodDetailsPage.moveBack();
        String firstProd = driver.findElement(By.xpath(productPrice)).getText().replaceAll("\\s", "").replaceAll("₴", "");
        int firstProdFiltered = Integer.parseInt(firstProd);

        //RozetkaProductListPage
        rozetkaProductListPage.waitProductPictures();
        rozetkaProductListPage.selectProductLessThanFirstProduct();

        //RozetkaGoodDetailsPage
        rozetkaGoodDetailsPage.waitCompareButtonElement();
        rozetkaGoodDetailsPage.rememberSecondNameAndPrice();
        rozetkaGoodDetailsPage.secondWaitProductPageElenent();
        rozetkaGoodDetailsPage.compareButtonInHeader();
        rozetkaGoodDetailsPage.waitCompareNumberInModalWindow();
        rozetkaGoodDetailsPage.nameOfCompareProduct();
        String secondProdElement = driver.findElement(By.xpath(productPrice)).getText().replaceAll("\\s", "").replaceAll("₴", "");
        int secondProdFiltered = Integer.parseInt(secondProdElement);

        //RozetkaComparePage
        RozetkaComparePage rozetkaComparePage = new RozetkaComparePage(driver);
        rozetkaComparePage.waitProductPicture();
        rozetkaComparePage.comparisonOfTwoProducts();
        assertEquals(firstProdFiltered, first);
        assertEquals(secondProdFiltered, second);
    }
}

