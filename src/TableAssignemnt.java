import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableAssignemnt {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> tableRows = driver.findElements(By.cssSelector(".left-align #product tr"));
		List<WebElement> tableColumns = driver.findElements(By.cssSelector(".left-align #product tr:nth-child(1) th"));
				
		// print number of rows
		System.out.println(tableRows.size());
		
		// print number of column
		System.out.println(tableColumns.size());
		
		// print 2nd row content
		for(int i = 0; i < tableRows.size(); i++) {
			if(i == 2) {
				System.out.println(tableRows.get(i).getText());
				
			}
		}

	}

}
