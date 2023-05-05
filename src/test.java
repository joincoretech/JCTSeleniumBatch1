import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class test {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // launch the browser
        String url="https://www.saucedemo.com/";
        driver.get(url);
        Thread.sleep(3000);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(3000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        WebElement daysDD= driver.findElement(By.cssSelector("select.product_sort_container"));
        Select select=new Select(daysDD);
       //select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Price (low to high)");
        Thread.sleep(3000);
        select.selectByValue("Name (Z to A)");

    }
}
