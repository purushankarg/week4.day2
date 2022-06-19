package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();		 
		driver.get("http://leafground.com/pages/table.html");
		driver.manage().window().maximize();
		String text = driver.findElement(By.xpath("//table//tr[2]/td[1]")).getText();
		System.out.println(text);
		

		
	}

}
