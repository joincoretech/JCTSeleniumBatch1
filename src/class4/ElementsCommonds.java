package class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementsCommonds {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");

        WebElement userName=driver.findElement(By.cssSelector("input#ctl00_MainContent_username"));
        userName.sendKeys("Tester");

        WebElement password=driver.findElement(By.cssSelector("input[name$='password']"));
        password.sendKeys("test");

        WebElement loginButton=driver.findElement(By.cssSelector("input.button"));
        loginButton.click();

        WebElement checkBox=driver.findElement(By.cssSelector("input[id*='ctl02']"));
        boolean isCheckBoxEnabled=checkBox.isEnabled();
        System.out.println(isCheckBoxEnabled);
        if (isCheckBoxEnabled){
            System.out.println("the checkBox is enabled");
        }else {
            System.out.println("The check box is disabled");
        }
        boolean isCheckBoxDisplayed=checkBox.isDisplayed();
        System.out.println(isCheckBoxDisplayed);
        boolean isCheckboxSelected=checkBox.isSelected();
        System.out.println("Before click "+isCheckboxSelected);
        checkBox.click();
        isCheckboxSelected=checkBox.isSelected();
        System.out.println("After click "+isCheckboxSelected);
        driver.quit();
    }
}
