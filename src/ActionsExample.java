import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsExample {

	public static void main(String[] args) {
				
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tokopedia.com/");
		
		WebElement btnHeaderCategory = driver.findElement(By.xpath("//div[@data-testid='btnHeaderCategory']"));
		WebElement inputSearch = driver.findElement(By.xpath("//div[@data-testid='txtHeaderSearchBar'] //input"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(btnHeaderCategory).build().perform(); // Simple Mouse Hover
		
		// Mouse Hover > Click > Type with Capital
		actions.moveToElement(inputSearch).click().keyDown(Keys.SHIFT).sendKeys("bpjs").build().perform();
		
	}
	
}
