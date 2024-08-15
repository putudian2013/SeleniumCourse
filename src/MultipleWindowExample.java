import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleWindowExample {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'courses-block col-lg-3 col-md-4 col-sm-6 col-xs-12')] //h2[1]")));
		
		String name = driver.findElement(By.xpath("//div[contains(@class,'courses-block col-lg-3 col-md-4 col-sm-6 col-xs-12')] //h2[1]")).getText();
		
		driver.switchTo().window(parentWindow);
		driver.findElement(By.name("name")).sendKeys(name);
		
	}

}
