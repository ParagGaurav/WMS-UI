package wmsautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	
	public void loginToWebsite(WebDriver driver) {
		
		driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("parag@sayurbox.com");
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("Salary@321");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//a[@role='button']")).click();
	}

}
