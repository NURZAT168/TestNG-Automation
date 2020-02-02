package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmartBearLogin {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        String actualTitle=driver.getTitle();
        String expectedTitle= "Web Orders Login";

        if(actualTitle.equals(actualTitle)){
            System.out.println("Login page title verification PASSED");
        }else{
            System.out.println("Login page title verification FAILED");
        }
//4-Enter	username:	Tester
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");

//5-Enter	password: test

        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");

//6-Click	“Sign	In”	button
       driver.findElement(By.name("ctl00$MainContent$login_button")).click();

       //7-Verify	title equals:     Expected:	Web	Orders

        String actualTitleOrder=driver.getTitle();
        String expectedTitleOrder="Web Orders";

        if(actualTitleOrder.equals(expectedTitleOrder)){
            System.out.println("Web Order title verification PASSED");
        }else{
            System.out.println("Web Order title verification FAILED");
        }

    }
}
