import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DynamicTestScriptAssignment {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		WebElement checkbox = driver.findElement(By.xpath("//div[@id='checkbox-example'] //fieldset //label[@for='honda']"));
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		WebElement textInput = driver.findElement(By.id("name"));
		WebElement btnAlert = driver.findElement(By.id("alertbtn"));
		
		checkbox.findElement(By.tagName("input")).click();
		String checkboxValue = checkbox.getText();
		
		Select select = new Select(dropdown);
		select.selectByVisibleText(checkboxValue);
		String dropdownValue = select.getFirstSelectedOption().getText();
		
		textInput.sendKeys(dropdownValue);
		
		btnAlert.click();
		

	}

}
