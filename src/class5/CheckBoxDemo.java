package class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.ironspider.ca/forms/checkradio.htm");
        driver.manage().window().maximize();
       // Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[href='#checkbox']")).click();

        List<WebElement>  checkBoxes=driver.findElements(By.cssSelector("input[type='checkbox']"));
        System.out.println(checkBoxes.size());
        Thread.sleep(2000);
       /* for(WebElement checkbox:checkBoxes){// code to select all checkboxes
            checkbox.click();
        }*/
        for (WebElement checkBox:checkBoxes){
            String value=checkBox.getAttribute("value");
            if (value.equalsIgnoreCase("Red")){
                Thread.sleep(2000);
                checkBox.click();
                break;
            }
        }

    }
}
