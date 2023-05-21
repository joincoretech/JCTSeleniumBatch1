package class10;

import Utiles.CommonMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class ActionclassDemo extends CommonMethod {
    public static void main(String[] args) throws InterruptedException {
        String url="https://amazon.com";
        //Thread.sleep(2000);
        openDriver(url);
        WebElement accountAndList=driver.findElement(By.id("nav-link-accountList"));
        Actions action=new Actions(driver);
        action.moveToElement(accountAndList).perform();

        Thread.sleep(2000);
        tearDown();// same as driver.quit();
    }
}
