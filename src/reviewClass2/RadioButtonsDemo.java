package reviewClass2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtonsDemo {
    public static String url ="https://material-ui.com/components/radio-buttons/";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get(url);

        List<WebElement> radioButtons=driver.findElements(By.xpath("//input[@name='radio-buttons-group']"));
        System.out.println(radioButtons.size());

        for (WebElement RBtn:radioButtons){// this for loop will click on all each radio button
            System.out.println("before click "+RBtn.isSelected());
            RBtn.click();
            System.out.println("after click "+RBtn.isSelected());
            Thread.sleep(2000);
        }

        for (WebElement radioBtn:radioButtons){
            String value=radioBtn.getAttribute("value");
            System.out.println(value);
            if (value.equalsIgnoreCase("male")){
                radioBtn.click();
            }else if(!radioBtn.isEnabled()){
                System.out.println("the radio button is not enabled");
            }
        }

    }
}
