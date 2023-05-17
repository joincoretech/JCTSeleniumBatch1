package class8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class StaticTableDemo {
    public static String url="https://grafana.com/docs/grafana/latest/datasources/testdata/";
    public static void main(String[] args) {
       System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
       WebDriver driver=new ChromeDriver();
       driver.get(url);

        List<WebElement> cloData= driver.findElements(By.xpath("//table/thead/tr/th"));
        System.out.println(cloData.size());
        for(WebElement col:cloData){
            String colText=col.getText();
            System.out.println(colText);
        }

        List<WebElement> rowData=driver.findElements(By.xpath("//table/tbody/tr/td"));
        System.out.println(rowData.size());
        Iterator<WebElement> it=rowData.iterator();
        while (it.hasNext()){
            WebElement row=it.next();
            String rowText=row.getText();
            System.out.println(rowText);
            if (rowText.equals("Name")){
                System.out.println("Name is visible");
            }
        }

    }
}
