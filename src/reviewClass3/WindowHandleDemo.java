package reviewClass3;

import class6.HandleAlertDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandleDemo {
     static String url="https://swagger.io/tools/swaggerhub/";
    public static void main(String[] args) throws InterruptedException {
       System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       // WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        Wait<WebDriver> wait= new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        String homePageHandle= driver.getWindowHandle();
        System.out.println("main page window handle is : "+homePageHandle);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class^='d-flex align-items-center']")));
        WebElement apiLink=driver.findElement(By.cssSelector("a[class^='d-flex align-items-center']"));
        apiLink.click();

        Set<String> windowHandles= driver.getWindowHandles();
        Iterator<String> iterator=windowHandles.iterator();
        homePageHandle= iterator.next();
        String apiWindowHandle=iterator.next();
        System.out.println("api widow handle is : "+apiWindowHandle);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Create Free Account']")));
        WebElement createFreeAccountBtn=driver.findElement(By.xpath("//a[text()='Create Free Account']"));
        boolean enabledBtnValue= createFreeAccountBtn.isEnabled();
        //createFreeAccountBtn.click();
        if (enabledBtnValue){
            System.out.println("Create Free Account Button is enabled : "+ enabledBtnValue);//true
        }else {
            System.out.println("Create Free button is not enabled : "+ enabledBtnValue);// false
        }

        driver.switchTo().window(apiWindowHandle);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Exploring')]")));
        WebElement startExploringBtn=driver.findElement(By.xpath("//a[contains(text(), 'Exploring')]"));
        if (startExploringBtn.isEnabled()){
            startExploringBtn.click();
        }else {
            System.out.println(" the start exploring button is not active");
        }
        Thread.sleep(2000);
        driver.switchTo().window(homePageHandle);
        driver.close();

        driver.switchTo().window(apiWindowHandle);
        driver.close();

    }
}
