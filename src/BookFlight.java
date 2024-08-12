import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BookFlight {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		// Select From
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(3000);
		
		// Select Destination
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		// Choose Departure Date
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		// Check Senior Citizen
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		
		// Make sure Return Date Disabled
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		
		// Add Pax
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		int i = 1;
		while(i<=7) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		// Change Currency to USD
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(3);
		
		// Submit
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

	}

}
