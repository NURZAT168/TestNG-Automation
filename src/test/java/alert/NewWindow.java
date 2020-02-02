package alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NewWindow {
   // 1.Create	a	new	class	called:	WindowHandlePractice
    // 2.Create	new	test	and	make	set	ups
    // 3.Go	to	:	http://practice.cybertekschool.com/windows
   WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/windows");
    }
    @Test
    public void title() {
        // 4.Assert:	Title	is	“Practice”
        String mainHandle = driver.getWindowHandle();
        System.out.println(mainHandle);

        String actualTitle = driver.getTitle();
        String expected ="Practice";
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, expected,"Titles are not matching!!!");

        // 5.Click	to:	“Click	Here”text
        WebElement clickHereLink= driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();
       // System.out.println(driver.getTitle());
         for(String handle: driver.getWindowHandles()){
             if(!handle.equals(mainHandle)){
                 driver.switchTo().window(handle);

             }
         }

        System.out.println(driver.getTitle());

         String expectedTitleAfterCheck="New Window";
         String actualTitleAfterCheck= driver.getTitle();
         Assert.assertEquals(actualTitleAfterCheck,expectedTitleAfterCheck, "Titles are not matching!!!");


    }
    // 5.Click	to:	“Click	Here”text
    // 6.Switch	to	new	Window.
    // 7.Assert:	Title	is	“New	Window”
}
