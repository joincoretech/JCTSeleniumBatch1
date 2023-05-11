package class6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingIframe {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.uitestpractice.com/Students/Switchto");
        driver.manage().window().maximize();

       driver.switchTo().frame(0);
        WebElement textBox=driver.findElement(By.id("name"));
        textBox.sendKeys("Batch1 students are the best");

        driver.switchTo().defaultContent();// this will get us out of the iframe

        driver.switchTo().frame("iframe_a");
        textBox.clear();
        Thread.sleep(2000);
          textBox.sendKeys("Practice is the key to learn");
          driver.switchTo().defaultContent();

          WebElement iframeElement=driver.findElement(By.xpath("//iframe[@src='/Demo.html']"));

          driver.switchTo().frame(iframeElement);
          textBox.clear();
          textBox.sendKeys("this is iframeElement");


    }
}
