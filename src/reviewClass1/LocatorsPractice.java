package reviewClass1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsPractice {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@data-test='login-button']")).click();

        driver.findElement(By.className("inventory_item_name")).click();
        driver.findElement(By.xpath("//button[contains(@name, 'labs-backpack')]")).click();
        Thread.sleep(2000);
        driver.navigate().back();

        driver.findElement(By.xpath("//button[contains(text(), 'Open Menu')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("About")).click();
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        String title=driver.getTitle();
        Thread.sleep(2000);
       if (title.equals("Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing")){
             System.out.println("The title is correct");
       }else {
       System.out.println("The title is not correct");
       }
        Thread.sleep(2000);
       driver.navigate().back();
        Thread.sleep(2000);
       driver.findElement(By.partialLinkText("Log")).click();
       driver.quit();

       //  //a[@id='about_sidebar_link']/ancestor::div  // get to grand father
       //  //a[@id='about_sidebar_link']/parent::nav    // get to parent
       //  //a[@id='about_sidebar_link']/preceding-sibling::a // move to previous sibling
        //  //a[@id='about_sidebar_link']/following-sibling::a  // move to next sibling


    }
}
