package class8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DynamicTableDemo {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");

        // driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");

        WebElement userName=driver.findElement(By.id("ctl00_MainContent_username"));
        userName.sendKeys("Tester");

        WebElement password= driver.findElement(By.name("ctl00$MainContent$password"));
        password.sendKeys("test");

        WebElement loginBT=driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginBT.click();

        List<WebElement> rows = driver.findElements(By.xpath(
                "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
        for (int i=1; i<rows.size(); i++){
            String rowText= rows.get(i).getText();
            System.out.println(rowText);
            if (rowText.contains("FamilyAlbum")){
                List<WebElement> checkBoxes=driver.findElements(By.xpath(
                        "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td [1]"));
                checkBoxes.get(i-1).click();
            }
        }

    }
}
