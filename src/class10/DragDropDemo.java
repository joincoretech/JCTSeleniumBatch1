package class10;

import Utiles.CommonMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragDropDemo extends CommonMethod {
    public static void main(String[] args) throws InterruptedException {
        String url="https://jqueryui.com/droppable/";
         openDriver(url);
         driver.manage().window().maximize();
         driver.switchTo().frame(0);
        WebElement a=driver.findElement(By.id("draggable"));
        WebElement b=driver.findElement(By.id("droppable"));
        Actions actions=new Actions(driver);
        Thread.sleep(2000);
       // actions.dragAndDrop(a,b).perform();

        actions.clickAndHold(a).moveToElement(b).release().build().perform();
        takeScreenShot("ScreenShot/drgAndDrop.png");

        Thread.sleep(2000);
        tearDown();

    }
}
