package class10;

import Utiles.CommonMethod;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class ScreenShotDemo extends CommonMethod {
    public static void main(String[] args) throws InterruptedException {
        String url="https://dreamhiringacademy.com/index.php";
        openDriver(url);
        driver.manage().window().maximize();
       // Thread.sleep(1000);   //input[@id='password']/preceding-sibling::input
        WebElement userNameBox=driver.findElement(By.name("name"));
       // Thread.sleep(1000);
        userNameBox.sendKeys("batch1@gmailcom", Keys.TAB);
        //input[@name='name']/following-sibling::input
     WebElement passwordBox=driver.findElement(By.name("password"));
        Thread.sleep(1000);
     passwordBox.sendKeys( "batch1@123", Keys.ENTER);

        /*TakesScreenshot ts=(TakesScreenshot) driver;
        File sourceFile=ts.getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(sourceFile, new File("ScreenShot/adminLogin.png"));

        }catch (IOException e){
            e.printStackTrace();
        }*/

     String filepath="ScreenShot/adminLogin.png";
     takeScreenShot(filepath);
     tearDown();
    }
}
