package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign4Table {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		// Setting up the URL
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		List<WebElement> colunm = driver.findElements(By.xpath("//table/tbody/tr[2]/td"));
		System.out.println("count of number of columns: " + colunm.size());
		
		List<WebElement> row = driver.findElements(By.xpath("//table/tbody/tr"));
		System.out.println("count of number of rows: " + row.size());
		
		
		List<WebElement> row1Col = driver.findElements(By.xpath("//table/tbody/tr[@class='even']/td"));
//		System.out.println(row1Col.get(2).getText());
		for(int i=0; i<row1Col.size(); i++) {
//			if(row1Col.get(i).getText().equals("Learn to interact with Elements"))
			System.out.println(row1Col.get(i).getText());
		}
		
		WebElement checkP = driver.findElement(By.xpath("//table/tbody/tr[6]/td/input[@name='vital']"));
		
		System.out.println(checkP.isSelected());
		System.out.println(checkP.isEnabled());
		checkP.click();
		System.out.println(checkP.isSelected());

	}

}
