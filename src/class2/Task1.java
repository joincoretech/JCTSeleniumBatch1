package class2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com");
        String url=driver.getCurrentUrl();
        String title=driver.getTitle();
        System.out.println(url + "  "+ title);
        if (title.equals("Amazon.com. Spend less. Smile more.")){
            System.out.println("title is as expected");
        }else {
            System.out.println("title is not same");
        }
        driver.quit();
    }
}
