import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarNewExample {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		WebElement calendarPlaceholder = driver.findElement(By.className("react-date-picker__inputGroup"));
		calendarPlaceholder.click(); // Open Calendar
		
		WebElement calendar = driver.findElement(By.className("react-calendar"));
		WebElement calendarNavigation = calendar.findElement(By.className("react-calendar__navigation"));
		WebElement calendarNavigationLabel = calendarNavigation.findElement(By.xpath("//button[contains(@class,'react-calendar__navigation__label')]"));
		
		calendarNavigationLabel.click(); // Change to Month View
		calendarNavigationLabel.click(); // Change to Year View
		
		WebElement calendarContainer = calendar.findElement(By.className("react-calendar__viewContainer"));
		calendarContainer.findElement(By.xpath("//button[text()='2025']")).click(); // Click Year
		
		calendarContainer.findElement(By.xpath("//abbr[text()='September']")).click(); // Click Month
		calendarContainer.findElement(By.xpath("//abbr[text()='13']")).click(); // Click Day
		
		
	}

}
