package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CybertekEx {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.cybertekschool.com");

        String expectedTitle="Cybertek";
        String actualTitle=driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Google title verification is PASSED!");
        }else{
            System.out.println("Google title verification is FAILED!");
        }

        String expectedUrl="cybertekschool";
        String actualUrl=driver.getCurrentUrl();

       if(actualUrl.contains(expectedUrl)){
           System.out.println("Google URL verification is PASSED!");
       }else{
           System.out.println("Google URL verification is FAILED!");
       }




    }
}
