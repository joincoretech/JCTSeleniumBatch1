package class11;

import Utiles.CommonMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSExecuterDemo extends CommonMethod {
       static   String url="https://amazon.com/";
    public static void main(String[] args) throws InterruptedException {
         openDriver(url);

        JavascriptExecutor js=(JavascriptExecutor) driver;
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-500)");

        Thread.sleep(2000);
        WebElement backToTop=driver.findElement(By.id("navBackToTop"));
        js.executeScript("arguments[0].scrollIntoView(true)", backToTop);
    }
}
