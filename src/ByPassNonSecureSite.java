import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ByPassNonSecureSite {

	public static void main(String[] args) {
		
		ChromeOptions chromeOptions = new ChromeOptions();
		
		chromeOptions.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

	}

}
