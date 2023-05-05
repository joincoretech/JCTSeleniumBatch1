package class1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {
    public static void main(String[] args) {
        WebDriver driver =new ChromeDriver();
        System.setProperty("wedriver.chrome.driver", "drivers/chromedriver.exe");

        driver.get("https://www.google.com/");// this will open the chrome browser

        String url=driver.getCurrentUrl();
        System.out.println("this is the url "+url);
        System.out.println(" this is the url " +driver.getCurrentUrl());

        String title=driver.getTitle();// this method will get a page title
        System.out.println("this is the page title " +title);

        driver.close();

    }
}
