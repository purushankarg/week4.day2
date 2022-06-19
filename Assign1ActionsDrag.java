package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign1ActionsDrag {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drag.html");
		driver.manage().window().maximize();
		
		WebElement ele = driver.findElement(By.xpath("//div[@id='draggable']"));
		
		Actions ac = new Actions(driver);
		ac.dragAndDropBy(ele, 120, 120)
		.perform();
		

	}

}
