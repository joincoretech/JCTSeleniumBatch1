package Utiles;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CommonMethod {
    
        public static   WebDriver driver;
        
        public  static void  openDriver(String url){
              System.setProperty("Webdriver.chrome.driver", "drivers/chromedriver.exe")  ;
              driver=new ChromeDriver();
              driver.get(url);
              driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }

        public static void takeScreenShot(String filePath){
            TakesScreenshot ts=(TakesScreenshot) driver;
            File sourceFile=ts.getScreenshotAs(OutputType.FILE);
            try{
                FileUtils.copyFile(sourceFile, new File(filePath));

            }catch (IOException e){
                e.printStackTrace();
            }
        }


        public static void tearDown(){
              driver.quit();
        }
}
