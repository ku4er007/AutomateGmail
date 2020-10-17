import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.AssertJUnit.assertEquals;

public class FitrLoginTest extends forFitr {
    String mainPageURL = "https://get.fitr.training";
    String loginUrl = "https://app.fitr.training/onboarding/sign_in?_ga=2.78318100.180159438.1602760489-1546163525.1602760489";


    @BeforeMethod
    public void navigateToUrl() {
        driver.get(mainPageURL);
        driver.manage().window().maximize();

    }

    @Test
    public void negativeLoginTestWrongPassword() {
        driver.findElement(By.xpath("//a[@class='nav-link portrait-hide white']")).sendKeys(Keys.CONTROL + "t");
        driver.get(loginUrl);
        wait.until(visibilityOfElementLocated(By.xpath("//h1")));
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ku4er007@gmail.com");
        driver.findElement(By.name("current-password")).sendKeys("zaq123");
        driver.findElement(By.xpath("//button")).click();
        wait.until(visibilityOfElementLocated(By.xpath("//div[@class='custom-template-close']")));
        driver.findElement(By.xpath("//div[@class='custom-template-close']")).click();
        assertEquals(driver.getCurrentUrl(), loginUrl);
    }
}