package class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathPractice {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"))
                .sendKeys("Tester");
        driver.findElement(By.xpath("//input[@type='password']"))
                .sendKeys("test");
        driver.findElement(By.xpath("//input[@class='button']")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
       driver.close();

        ////h3[contains(text(), 'Product' )]// use contains method to locate the element with partial text
        // //a[contains(@id, 'InsertButton')] use attribute partial value.
        ////table[@id='ctl00_MainContent_orderGrid']/tbody/tr/ // get to table data

        // //table[@id='ctl00_MainContent_orderGrid']/ancestor::form // to locate the grand parent



    }
}
