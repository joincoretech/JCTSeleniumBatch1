package class9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalanderDemo {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://dreamhiringacademy.com/user/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement userName= driver.findElement(By.id("username"));
        userName.sendKeys("aziz@gmail.com");

        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("aziz@123");

        WebElement loginButton= driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();


        WebElement leaveButton= driver.findElement(By.cssSelector("a[title='Leave']"));
        leaveButton.click();

        WebElement applyButton=driver.findElement(By.cssSelector("a[href*='apply']"));
        applyButton.click();

        WebElement leaveType=driver.findElement(By.id("country"));
        Select select=new Select(leaveType);
        select.selectByVisibleText("Sick leave");
        driver.findElement(By.id("lname")).sendKeys("joincoretech");
        driver.findElement(By.id("StartDate")).click();
        // Thread.sleep(2000);
        List<WebElement> startDates=driver.findElements(By.cssSelector
                ("body > div:nth-child(9) > div.xdsoft_datepicker.active > div.xdsoft_calendar > table >tbody>tr>td"));
        System.out.println(startDates.size());

        for (WebElement startDate: startDates){
            String startDateText=startDate.getText();
            if (startDateText.equals("29")){
                startDate.click();
                break;
            }
        }

        driver.findElement(By.id("EndDate")).click();

        WebElement nextButton= driver.findElement(By.cssSelector
                ("body > div:nth-child(8) > div.xdsoft_datepicker.active > div.xdsoft_monthpicker > button.xdsoft_next"));

        WebElement month=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/span"));
        boolean flag =true;
        while (flag){
            nextButton.click();
            if (month.getText().equals("July")){
                flag=false;
            }
           // Thread.sleep(500);
        }

        List<WebElement> endDates=driver.findElements(By.cssSelector(
                "body > div:nth-child(8) > div.xdsoft_datepicker.active > div.xdsoft_calendar > table >tbody>tr>td"));
        for(WebElement endDate: endDates){
            if(endDate.getText().equals("28")){
                endDate.click();
                break;
            }
        }

        WebElement submitButton=driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();
    }
}
