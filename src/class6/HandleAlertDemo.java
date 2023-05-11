package class6;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlertDemo {
    public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.uitestpractice.com/Students/Switchto");
        driver.manage().window().maximize();

        WebElement confirmButton=driver.findElement(By.id("confirm"));
        confirmButton.click();
        Thread.sleep(2000);
        Alert confirmAlert=driver.switchTo().alert();
        String alertText=confirmAlert.getText();
        System.out.println(alertText);
        confirmAlert.dismiss();

    }
}
