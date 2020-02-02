package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForgotPassZeroBank {
    public static void main(String[] args) {
        //TC #4: Zero Bank header verification
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // 2.Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");
        // 3.Get attribute value of href from the “forgot your password” link
        String att=driver.findElement(By.linkText("Forgot your password ?")).getAttribute("href");


        // 4.Verify attribute value contains Expected: “/forgot-password.html”
       // String actualAttributeValue=driver.

        System.out.println(att);

        String expectedAtt="/forgot-password.html";

        if(att.contains(expectedAtt)){
            System.out.println("Attribute verification PASSED!");
        }else{
            System.out.println("Attribute verification FAILED");
        }
    }
}
