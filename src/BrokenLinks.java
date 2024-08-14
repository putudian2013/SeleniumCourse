import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		String url = driver.findElement(By.cssSelector("a[href='https://rahulshettyacademy.com/brokenlink']")).getAttribute("href");
		
		@SuppressWarnings("deprecation")
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int responseCode = conn.getResponseCode();
//		System.out.println(url +", "+ responseCode);
		
		
		List<WebElement> footerLinks = driver.findElements(By.cssSelector("#gf-BIG a"));
		
		for(WebElement footerLink : footerLinks) {
			String urlNew = footerLink.getAttribute("href");
			@SuppressWarnings("deprecation")
			HttpURLConnection connNew = (HttpURLConnection) new URL(urlNew).openConnection();
			connNew.setRequestMethod("HEAD");
			connNew.connect();
			int responseCodeNew = connNew.getResponseCode();
			System.out.println(responseCodeNew +", "+ urlNew);
		}
		
	}

}










