package class8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FluentWaitDemo {

    public static String url = "http://the-internet.herokuapp.com/dynamic_loading/1";
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Wait<WebDriver> wait=new  FluentWait<>(driver).pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchFieldException.class).withTimeout(Duration.ofSeconds(20));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
        driver.findElement(By.xpath("//button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(), 'Hello')]")));
        WebElement textElement = driver.findElement(By.xpath("//h4[contains(text(), 'Hello')]"));

        String text = textElement.getText();
        if (text.equals("Hello World!")) {
            System.out.println("the text is as expected : " + text);
        } else {
            System.out.println("text is not same as expected : " + text);
        }
    }
}