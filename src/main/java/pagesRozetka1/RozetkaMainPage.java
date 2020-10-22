package pagesRozetka1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class RozetkaMainPage {
    WebDriver webDriver;
    WebDriverWait wait;

    public RozetkaMainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 5);
    }

    By sideMenuElementComputerNetbook = By.xpath("//a[contains(@href,'computers-notebooks')][@class='menu-categories__link']");
    By sideMenuElementMonitors = By.xpath("//a[@class='menu__link'][contains(@href,'monitors/c80089')][contains(text(),'Мониторы')]");

    public void maximaseScreen(){
        webDriver.manage().window().maximize();
    }
    public void selectingSideMenuItem() {
        Actions actions = new Actions(webDriver);
        WebElement sideMenu = webDriver.findElement(sideMenuElementComputerNetbook);
        actions.moveToElement(sideMenu).perform();
    }

    public void selectMonitorInList() {
        WebElement selectItemMonitor = webDriver.findElement(sideMenuElementMonitors);
        selectItemMonitor.click();
    }

    public void waitMonitorItem() {
        wait.until(visibilityOfElementLocated(sideMenuElementMonitors));

    }

}
