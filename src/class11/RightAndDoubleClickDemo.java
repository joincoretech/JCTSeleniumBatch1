package class11;

import Utiles.CommonMethod;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RightAndDoubleClickDemo extends CommonMethod {
    public static void main(String[] args) {
      String url ="http://demo.guru99.com/test/simple_context_menu.html";
      openDriver(url);
      driver.manage().window().maximize();

        WebElement rightButton=driver.findElement(By.xpath("//span[text()='right click me']"));

        Actions actions=new Actions(driver);
        actions.contextClick(rightButton).perform();

       WebElement editOption=driver.findElement(By.xpath("//span[text()='Edit']"));

       //editOption.click();
        actions.click(editOption).perform();
        Alert alert=driver.switchTo().alert();
        alert.accept();

        WebElement doubleButton= driver.findElement(By.xpath(
                "//button[contains(text(),'Double-Click')]"));
        actions.doubleClick(doubleButton).perform();
        alert=driver.switchTo().alert();
        String alertText=alert.getText();
        System.out.println(alertText);
        alert.accept();

    }
}
