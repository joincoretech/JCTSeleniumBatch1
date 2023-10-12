package class11;

import Utiles.CommonMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSExecutorDemo2  extends CommonMethod {
    public static void main(String[] args) {
        String url="http://google.com";
         openDriver(url);

        JavascriptExecutor  js= (JavascriptExecutor) driver;
        js.executeScript("window.open();");
        WebElement searchBox= driver.findElement(By.name("q"));
        searchBox.sendKeys("help");
    }
}
