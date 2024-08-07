import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxExercise {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Check the 1st checkbox
		driver.findElement(By.id("checkBoxOption1")).click();
		
		// Verify 1st checkbox is successfully checked
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		// Uncheck the 1st checkbox
		driver.findElement(By.id("checkBoxOption1")).click();
		
		// Verify 1st checkbox is successfully unchecked
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		// Count all checkboxes in the page
		driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		
	}

}
