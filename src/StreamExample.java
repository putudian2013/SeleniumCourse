import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamExample {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);

		// print all number inside numbers
		numbers.stream().distinct().forEach(number -> System.out.println(number));

		// sort the numbers and then display the 3rd index
		List<Integer> sortedNumber = numbers.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(sortedNumber.get(2));

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> elementList = driver.findElements(By.xpath("//tr//td[1]"));
		List<String> originalList = elementList.stream().map(s -> s.getText()).collect(Collectors.toList());
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());


		checkVeggieSorted(driver, originalList, sortedList);
		
		checkSelectedVeggiePrice(driver, elementList);
		
		handlingPagination(driver);
		
		handlingTableSearchResult(driver);
		
		

	}
	
	public static void checkVeggieSorted(WebDriver driver, List<String> originalList, List<String> sortedList) {
		Assert.assertTrue(originalList.equals(sortedList));
	}
	
	public static void checkSelectedVeggiePrice(WebDriver driver, List<WebElement> elementList) {
		List<String> price = elementList.stream().filter(s -> s.getText().contains("Beans")).map(s -> getPriceVeggie(s))
				.collect(Collectors.toList());
		price.forEach(s -> System.out.println(s));
	}
	
	public static void handlingPagination(WebDriver driver) {
		List<String> price;
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s)).collect(Collectors.toList());
			if(price.size() < 1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		} while (price.size() < 1);
	}
	
	public static void handlingTableSearchResult(WebDriver driver) {
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> veggiesName = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<WebElement> filteredVeggies = veggiesName.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		
		Assert.assertEquals(filteredVeggies.size(), veggiesName.size());
	}

	public static String getPriceVeggie(WebElement s) {
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
