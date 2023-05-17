package class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WeborderTask {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");

       // driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");

        WebElement userName=driver.findElement(By.id("ctl00_MainContent_username"));
        userName.sendKeys("Tester");

        WebElement password= driver.findElement(By.name("ctl00$MainContent$password"));
        password.sendKeys("test");

        WebElement loginBT=driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginBT.click();

      String title= driver.getTitle();
      if (title.equals("Web Orders")){
          System.out.println("the title is correct");
      }else {
          System.out.println("The title is not correct");
      }

      driver.findElement(By.partialLinkText("Log")).click();
      driver.quit();




    }
}
