package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackAndForth {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        driver.findElement(By.linkText("Gmail")).click();
               String actualTitle=driver.getTitle();
                String expectedTitle= "Gmail";
                if(actualTitle.contains(expectedTitle)){
                    System.out.println("Gmail title verification is PASSED!");
                }else{
                    System.out.println("Gmail title verification is FAILED!");
                }

        Thread.sleep(2000);

                driver.navigate().back();

                String actualTitle2="Google";
                String expectedTitle2=driver.getTitle();
        if(actualTitle2.equals(expectedTitle2)){
            System.out.println("Google title verification is PASSED!");
        }else{
            System.out.println("Google title verification is FAILED!");
        }

        Thread.sleep(2000);

        driver.navigate().forward();

        String actualTitle3=driver.getTitle();
        String expectedTitle3= "Gmail";
        if(actualTitle.contains(expectedTitle)){
            System.out.println("Gmail title verification is PASSED!");
        }else{
            System.out.println("Gmail title verification is FAILED!");
        }

    }
}
//	Back	and	forth	navigation
//	1-Open	a	chrome	browser
//	2-Go	to:	https://google.com
//	3-Click	to	Gmail	from	top	right.
//	4-Verify	title	contains:Expected:	Gmail
//	5-Go	back	to	Google	by	using	the	.back();
//	6-Verify	title	equals:Expected:	Google
//	7-Go	back	to	Gmail	using	the	Forward	button
//	8-Verify	title	contains:Expected:	Gmail