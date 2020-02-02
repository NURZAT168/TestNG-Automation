package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class NonSelectDropdown {
    public static void main(String[] args) {
        //TC #3: Selecting value from non-select dropdown
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // 2.Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
        // 3.Click to non-select dropdown
        WebElement nonSelectDropdown= driver.findElement(By.id("dropdownMenuLink"));
        nonSelectDropdown.click();

        // 4.Select Facebook from dropdown
      WebElement facebookLink=driver.findElement(By.xpath("//a[.='Facebook']"));
      facebookLink.click();

        // 5.Verify title is “Facebook - Log In or Sign Up”
        String expectedTitle="Facebook - Log In or Sign Up";
        String actualTitle=driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED");
        }else{
            System.out.println("Title verification FAILED");
        }
    }
}
