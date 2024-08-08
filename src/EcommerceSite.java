import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EcommerceSite {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot", "Carrot" };
		
		addItems(driver, itemsNeeded);
		
		driver.findElement(By.cssSelector(".cart-icon")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".promoCode")));
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());

 	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) throws InterruptedException {

		int itemCount = 0;

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			String name = products.get(i).getText().split("-")[0].trim();

			List listItemsNeeded = Arrays.asList(itemsNeeded);

			if (listItemsNeeded.contains(name)) {
				itemCount++;
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				if (itemCount == itemsNeeded.length) {
					break;
				}
			}
			
//			Thread.sleep(4000);

		}

	}

}
