package class11;

import Utiles.CommonMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FileUploadDemo extends CommonMethod {
    public static void main(String[] args) {
      String url = "https://the-internet.herokuapp.com/";
      openDriver(url);
      driver.manage().window().maximize();

        WebElement uploadFile=driver.findElement(By.linkText("File Upload"));
        uploadFile.click();

        WebElement choseFileBtn=driver.findElement(By.id("file-upload"));
        choseFileBtn.sendKeys("C:\\Users\\azizu\\IdeaProjects\\SeleniumBatch1\\ScreenShot\\adminLogin.png");

        WebElement uploadBtn=driver.findElement(By.id("file-submit"));
        uploadBtn.click();
        driver.navigate().back();
        driver.navigate().back();

    }
}
