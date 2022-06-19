package week4.day2;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.mongodb.MapReduceCommand.OutputType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign3SnapDeal {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		// Setting up the URL
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Actions ac =new Actions(driver);
		WebElement mFashion = driver.findElement(By.xpath("//span[@class='catText' and text()=\"Men's Fashion\"]"));
		
		ac.moveToElement(mFashion).perform();
		
		driver.findElement(By.xpath("(//span[@class='linkTest' and text()=\"Sports Shoes\"])[1]")).click();
		
		Thread.sleep(5000);
		String count = driver.findElement(By.xpath("(//a[@class='child-cat-node dp-widget-link hashAdded']//div[@class='child-cat-count '])[2]")).getText();
		System.out.println("Count of sports shoe: " + count);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		
		driver.findElement(By.xpath("//ul[@class='sort-value']//li[2]")).click();
		
//		List<WebElement> pri = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
//		System.out.println(pri.get(1).getText());
		
		WebElement lowP = driver.findElement(By.xpath("( //input[@class='input-filter'])[1]"));
		lowP.clear();
		lowP.sendKeys("300");
		
		WebElement lowH = driver.findElement(By.xpath("( //input[@class='input-filter'])[2]"));
		lowH.clear();
		lowH.sendKeys("2000");
		
		driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow')]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//div[@data-name='Color_s']//following::button[contains(@class,'view-more-button')])[1]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		
		Thread.sleep(3000);
		
		String filterPrice = driver.findElement(By.xpath("(//div[@class='filters']//div//a)[1]")).getText();
		
		String filterColor = driver.findElement(By.xpath("(//div[@class='filters']//div[2]//a[@data-value='Navy'])[1]")).getText();

		Thread.sleep(5000);
		
		System.out.println(filterPrice);
		
		System.out.println(filterColor);
		
		WebElement firstResult = driver.findElement(By.xpath("(//div[@class='product-tuple-image ']//a)[1]"));
		ac.moveToElement(firstResult).perform();
		
		driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]")).click();
		
		Thread.sleep(5000);
		
		String priceF = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		
		System.out.println("Price of the shoe: " + priceF);
		
		String percent = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		
		System.out.println("Percentage is: " + percent);
		
		WebElement quick = driver.findElement(By.xpath("//div[@class='sidebarin-content']"));
		
		File source = quick.getScreenshotAs(OutputType.FILE);
		
		File destination = new File("./snapshot/Shoe.png");
		
		FileUtils.copyFile(source, destination);
		
		driver.close();	

	}

}
