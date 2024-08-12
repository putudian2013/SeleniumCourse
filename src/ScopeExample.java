import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeExample {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		
		WebElement firstFooterColumn = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		List<WebElement> firstFooterColumnContent = firstFooterColumn.findElements(By.tagName("a"));
		
		for(int i = 1; i < firstFooterColumnContent.size(); i++) {
			
			String openNewTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
			
			firstFooterColumnContent.get(i).sendKeys(openNewTab);
			Thread.sleep(2000);
	
		}
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> window = windows.iterator();
		
		while(window.hasNext()) {
			driver.switchTo().window(window.next());
			System.out.println(driver.getTitle());
		}
		
	}

}
