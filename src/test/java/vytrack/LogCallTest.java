package vytrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.SeleniumUtils;

public class LogCallTest {
    public static void main(String[] args) {

        WebDriver driver;

        String userNameLocator="prependedInput";
        String passwordLocator="prependedInput2";
        String tabLocatorXpath="//span[contains(text(), 'Activities') and @class= 'title title-level-1']";
        String  moduleLocatorXpath="//span[.= 'Calls']";
        String logCallBtnLocatorCss="a[title='Log call']";

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa2.vytrack.com/user/login");

        driver.findElement(By.id(userNameLocator)).sendKeys("storemanager85");
        driver.findElement(By.id(passwordLocator)).sendKeys("UserUser123"+ Keys.ENTER);

        SeleniumUtils.pause(5);
        driver.findElement(By.xpath(tabLocatorXpath)).click();
        SeleniumUtils.pause(2);
        driver.findElement(By.xpath(moduleLocatorXpath)).click();
        SeleniumUtils.pause(5);

        if(driver.findElement(By.cssSelector(logCallBtnLocatorCss)).isDisplayed()){
            System.out.println("Test 1 Passed");
        }else{
            System.out.println("Test 1 Failed");
        }








    }
}
