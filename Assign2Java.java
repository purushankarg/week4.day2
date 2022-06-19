package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign2Java {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		// Setting up the URL
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		Actions ac = new Actions(driver);
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		
		ac.moveToElement(brand).perform();
		
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		
		driver.findElement(By.xpath("//div[@class='css-ov2o3v']//a")).click();
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		
		String checkFilter = driver.findElement(By.xpath("//span[@class='filter-value' and text()='Shampoo']")).getText();
		System.out.println(checkFilter);
		
		String parentWindow = driver.getWindowHandle();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='css-43m2vm']//img")).click();
		
		Set<String> windows = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windows);
		
		driver.switchTo().window(window.get(1));
		
		WebElement drop = driver.findElement(By.xpath("//select[@title='SIZE']"));
		
		Select dp = new Select(drop);
		dp.selectByValue("1");
		
		String price = driver.findElement(By.xpath("//div[@class='css-1ufhqkr']//div[@class='css-f5j3vf']/div/span[@class='css-1jczs19']")).getText();
		System.out.println(price);
		
		driver.findElement(By.xpath("//div[@class='css-vp18r8']//button//span")).click();
		
		driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();
		
		Thread.sleep(5000);
		WebElement fram = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
		driver.switchTo().frame(fram);
		String grandTotal = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		grandTotal.replaceAll("[^0-9]", "");
		System.out.println(grandTotal);
		
		driver.findElement(By.xpath("//span[@class='vernacular-string' and text()='Proceed']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		
		String totl = driver.findElement(By.xpath("//div[@class='payment-details-tbl grand-total-cell prl20']//div[@class='value']")).getText();
		System.out.println(totl);
		
		if(grandTotal.equals(totl)) {
			System.out.println("Both values are equal");
		}
		else {
			System.out.println("Both values are not equal");
		}
		
		driver.quit();

	}

}
