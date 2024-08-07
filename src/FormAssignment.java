import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormAssignment {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.cssSelector("div[class='form-group'] input[name='name']")).sendKeys("Dian Pramana");
		driver.findElement(By.name("email")).sendKeys("dianpramana@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("test@123");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement genderDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(genderDropdown);
		dropdown.selectByVisibleText("Male");
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("13071987");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());

	}

}
