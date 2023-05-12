package reviewClass2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");

        driver.findElement(By.xpath("//input[@name='alert']")).click();
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

       driver.findElement(By.xpath("//input[@name='confirmation']")).click();
       Alert confirmAlert=driver.switchTo().alert();
       System.out.println("this is confirm alert text : "+confirmAlert.getText());
       confirmAlert.dismiss();

       driver.findElement(By.xpath("//input[@name='prompt']")).click();
       Alert promptAlert=driver.switchTo().alert();
       Thread.sleep(2000);
       String promptAlertText=promptAlert.getText();
       System.out.println(promptAlertText);
        promptAlert.sendKeys("Hello");
        Thread.sleep(2000);
        promptAlert.accept();

    }
}
