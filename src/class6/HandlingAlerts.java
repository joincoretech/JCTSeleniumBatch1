package class6;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.uitestpractice.com/Students/Switchto");
        driver.manage().window().maximize();

        WebElement simpleAlertButton=driver.findElement(By.xpath("//button[@id='alert']"));
        simpleAlertButton.click();
        Alert simpleAlert=driver.switchTo().alert();
        Thread.sleep(2000);
        simpleAlert.accept();
        Thread.sleep(2000);

        WebElement confirmAlertButton=driver.findElement(By.cssSelector("button#confirm"));
        confirmAlertButton.click();
        Alert confirmAlert=driver.switchTo().alert();
        Thread.sleep(2000);
        String alertText=confirmAlert.getText();
        if (alertText.equals("Hello Alert")){
            System.out.println("the alert text is as expected "+alertText);
        } else {
            System.out.println("the alert text is not same as expected "+alertText);
        }
        confirmAlert.dismiss();
        Thread.sleep(2000);

        WebElement promptAlertButton=driver.findElement(By.id("prompt"));
        promptAlertButton.click();
        Thread.sleep(2000);
        Alert promptAlert=driver.switchTo().alert();
        promptAlert.sendKeys("JoinCoreTech");
        Thread.sleep(2000);
        promptAlert.accept();

    }
}
