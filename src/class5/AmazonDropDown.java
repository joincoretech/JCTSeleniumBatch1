package class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

public class AmazonDropDown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com/");

        WebElement catagoryDD=driver.findElement(By.id("searchDropdownBox"));

        Select select=new Select(catagoryDD);
        boolean multiple=select.isMultiple();
        System.out.println(multiple);

      /*  List<WebElement> options=select.getOptions();
        for(WebElement option:options){
            String optionText=option.getText();
            System.out.println(optionText);
        }*/
        Thread.sleep(1000);
        select.selectByIndex(2);
        if(!multiple){
            List<WebElement> options=select.getOptions();

            Iterator <WebElement> it =options.iterator();
            while (it.hasNext()){
                WebElement next= it.next();
                System.out.println(next.getText());
            }
        }


    }
}
