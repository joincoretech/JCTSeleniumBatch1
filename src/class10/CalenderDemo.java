package class10;

import Utiles.CommonMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CalenderDemo extends CommonMethod {
    public static void main(String[] args) throws InterruptedException {
        String url="https://www.delta.com/";
        openDriver(url);
        driver.manage().window().maximize();

       // Thread.sleep(3000);
       WebElement calenderBox= driver.findElement(By.cssSelector("div.calDispValueCont.icon-Calendar  "));
       calenderBox.click();

       WebElement dMonth=driver.findElement(By.className("dl-datepicker-month-0"));
       String dMonthText=dMonth.getText();
       System.out.println(dMonthText);

       WebElement nextBtn=driver.findElement(By.xpath("//span[text()='Next']"));

       while (dMonthText.equals("May")){

           List<WebElement> dpartDates=driver.findElements(By.xpath(
                   "(//table[@class='dl-datepicker-calendar'])[1]/tbody/tr/td"));
           System.out.println(dpartDates.size());
           for (WebElement departdate:dpartDates ){
               if (departdate.getText().contains("28")){
                   departdate.click();
                   break;
               }
           }

           WebElement rMonth=driver.findElement(By.className("dl-datepicker-month-1"));
           String returnMonthText=rMonth.getText();
           while (!returnMonthText.equals("September")){
               nextBtn.click();
               returnMonthText=rMonth.getText();
           }

           List<WebElement> returnDates=driver.findElements(By.xpath(
                   "(//table[@class='dl-datepicker-calendar'])[2]/tbody/tr/td"));
           System.out.println(returnDates.size());
           for (WebElement returndate:returnDates ){
               if (returndate.getText().contains("5")){
                   returndate.click();
                   break;
               }
           }

           WebElement doneButton=driver.findElement(By.className("donebutton"));
           doneButton.click();
       }

    }

}
