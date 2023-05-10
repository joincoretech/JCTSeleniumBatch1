package class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClearMethod {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");

        WebElement userName=driver.findElement(By.cssSelector("input#ctl00_MainContent_username"));
        userName.sendKeys("Tester");

        WebElement password=driver.findElement(By.cssSelector("input[name$='password']"));
        password.sendKeys("test");

        userName.clear();
        password.clear();





    }
}
