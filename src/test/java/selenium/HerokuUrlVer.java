package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HerokuUrlVer {
    public static void main(String[] args) {
        //TC #3: HerokuApp URL verification
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1.Open Chrome browser
        // 2.Go to https://the-internet.herokuapp.com/forgot_password

        driver.get("https://the-internet.herokuapp.com/forgot_password");
        // 3.Enter any email into input box
  driver.findElement(By.id("email")).sendKeys("anytext");


        // 4.Click on Retrieve password
driver.findElement(By.id("form_submit")).click();
        // 5.Verify URL contains: Expected: “email_sent”
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="email_sent";

        if(actualUrl.contains(expectedUrl)){
            System.out.println("Url verification PASSED");
        }else{
            System.out.println("Url verification FAILED");
        }
        //6. Verify that text box displayed has the text as expected
       // Expected: "Your e-mail's been sent!"

        String actualTextBoxValue=driver.findElement(By.id("content")).getText();
String expected="Your e-mail's been sent!";

if(actualTextBoxValue.equals(expected)){
    System.out.println("Text box value verification PASSED!");
}else{
    System.out.println("Text box value verification FAILED");
}





    }
}
