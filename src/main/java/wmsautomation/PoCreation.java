package wmsautomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PoCreation {

	public String poCreation(WebDriver driver,String sku1,String sku2,JavascriptExecutor jse) throws Exception {
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@data-test-id='link-add-new']")).click();
		driver.findElement(By.xpath("//div[@id='select-supplier']//div[@class='css-1hwfws3']")).click();
		driver.findElement(By.xpath("//div[@id='react-select-5-option-0']"));
		WebElement div = driver.findElement(By.xpath("//div[@class='css-11unzgr']"));
		List<WebElement> list = div.findElements(By.xpath("./child::*"));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equalsIgnoreCase("Sayurbox")) {
				list.get(i).click();
				break;
			}

		}
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath("//div[@id='select-po-type']//div[@class='css-1hwfws3']")).click();
		WebElement div2 = driver.findElement(By.xpath("//div[@class='css-11unzgr']"));
		List<WebElement> list2 = div2.findElements(By.xpath("./child::*"));
		for (int i = 0; i < list2.size(); i++) {
			if (list2.get(i).getText().equalsIgnoreCase("Sourcing")) {
				list2.get(i).click();
				break;
			}

		}
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,100)");
		driver.findElement(By.xpath("//div[@id='select-po-payment-type']//div[@class='css-1hwfws3']")).click();
		WebElement div3 = driver.findElement(By.xpath("//div[@class='css-11unzgr']"));
		List<WebElement> list3 = div3.findElements(By.xpath("./child::*"));
		for (int i = 0; i < list3.size(); i++) {
			if (list3.get(i).getText().equalsIgnoreCase("COD")) {
				list3.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,100)");
		driver.findElement(By.xpath("//div[@id='select-dest']//div[@class='css-1hwfws3']")).click();
		WebElement div4 = driver.findElement(By.xpath("//div[@class='css-11unzgr']"));
		List<WebElement> list4 = div4.findElements(By.xpath("./child::*"));
		for (int i = 0; i < list4.size(); i++) {
			if (list4.get(i).getText().equalsIgnoreCase("SH - Sourcing Hub")) {
				list4.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='select-sourcing-hub']//div[@class='css-1hwfws3']")).click();
		WebElement div5 = driver.findElement(By.xpath("//div[@class='css-16wsl7r']"));
		List<WebElement> list5 = div5.findElements(By.xpath("./child::*"));
		for (int i = 0; i < list5.size(); i++) {
			if (list5.get(i).getText().equalsIgnoreCase("SH01 - Lembang")) {
				list5.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,100)");
		driver.findElement(By.xpath("//div[@id='select-payment-source']//div[@class='css-1hwfws3']")).click();
		WebElement div6 = driver.findElement(By.xpath("//div[@class='css-11unzgr']"));
		List<WebElement> list6 = div6.findElements(By.xpath("./child::*"));
		for (int i = 0; i < list6.size(); i++) {
			if (list6.get(i).getText().equalsIgnoreCase("PT. Kreasi Nostra Mandiri")) {
				list6.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath("//div[@id='select-can-reject']//div[@class='css-1hwfws3']")).click();
		WebElement div7 = driver.findElement(By.xpath("//div[@class='css-11unzgr']"));
		List<WebElement> list7 = div7.findElements(By.xpath("./child::*"));
		for (int i = 0; i < list7.size(); i++) {
			if (list7.get(i).getText().equalsIgnoreCase("YES")) {
				list7.get(i).click();
				break;
			}
		}
		driver.findElement(By.xpath("//i[@class='fa fa-filter']"));
		jse.executeScript("window.scrollBy(0,800)");
		driver.findElement(By.xpath("//i[@class='fa fa-filter']")).click();
		List<WebElement> sku_skuNumberSearchList = driver.findElements(By.xpath("//input[@placeholder='Search']"));
		sku_skuNumberSearchList.get(1).sendKeys(sku1);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@id='editChannel']")).click();

		driver.findElement(By.xpath("//input[@id='cf534deb-932d-11ed-8613-02d02d58ca48']")).sendKeys("50");
		driver.findElement(By.xpath("//input[@id='cf53549b-932d-11ed-8613-02d02d58ca48']")).sendKeys("50");
		driver.findElement(By.xpath("//input[@id='af635375-933d-12ed-8613-02d12d59cb48']")).sendKeys("50");
		driver.findElement(By.xpath("//button[normalize-space()='Confirm']")).click();
		if(sku2!=null) {
			sku_skuNumberSearchList.get(1).clear();
			Thread.sleep(1000);
			sku_skuNumberSearchList.get(1).sendKeys(sku2);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[@id='editChannel']")).click();
			driver.findElement(By.xpath("//input[@id='cf534deb-932d-11ed-8613-02d02d58ca48']")).sendKeys("50");
			driver.findElement(By.xpath("//input[@id='cf53549b-932d-11ed-8613-02d02d58ca48']")).sendKeys("50");
			driver.findElement(By.xpath("//button[normalize-space()='Confirm']")).click();
		}

		driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
		String createdPO = driver.findElement(By.xpath("//div[normalize-space()='Successfully create dengan PO']/following-sibling::div")).getText();

		return createdPO;


	}

}
