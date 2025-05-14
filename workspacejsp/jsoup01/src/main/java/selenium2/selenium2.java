package selenium2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class selenium2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%EB%B0%95%EC%8A%A4%EC%98%A4%ED%94%BC%EC%8A%A4&ackey=d4s4q816");
		System.out.println(driver.getTitle());		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		
		WebElement textBox = driver.findElement(By.name("my-text"));
		WebElement submitButton = driver.findElement(By.cssSelector("button"));
		
		textBox.sendKeys("Selenium");
		submitButton.click();
		
		WebElement message = driver.findElement(By.id("message"));
		System.out.println(message.getText());
		
		driver.quit();

	}

} 
