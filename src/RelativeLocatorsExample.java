import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocatorsExample {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement inputName = driver.findElement(By.name("name"));
		
		WebElement labelName = driver.findElement(with(By.tagName("label")).above(inputName));
		System.out.println(labelName.getText());
		
		WebElement labelDob = driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		WebElement inputDob = driver.findElement(with(By.tagName("input")).below(labelDob));
		inputDob.click();
		
		WebElement labelCheckIceCream = driver.findElement(By.xpath("//label[@for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(labelCheckIceCream)).click();

		WebElement radioStudent = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("input")).toRightOf(radioStudent)).getText());
	}

}
