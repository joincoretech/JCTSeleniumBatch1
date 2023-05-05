package class2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethod {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe" );
        WebDriver driver=new ChromeDriver();
        String url="https://www.facebook.com";
        driver.navigate().to(url);
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        Thread.sleep(1000);
        driver.navigate().back();// this method will move one step back
        Thread.sleep(1000);
        driver.navigate().forward();// this method will move one step farword
        driver.close();// this will close only one tab
        //driver.quit(); // will close the window / all tabs
    }
}
