package wmsautomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test


public class LaunchOssWebsite {
	
	

	public  void testOss() throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"//Users//paraggaurav//Downloads//Software//chromedriver_mac_arm64//chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("https://oss-web.sayurbox.tech/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		Login login = new Login();
		login.loginToWebsite(driver);

		String createdPO = createPo(driver);
		LaunchWmsWebsite launchWmsWebsite = new LaunchWmsWebsite();
		launchWmsWebsite.launchWms(driver, createdPO);
		GrnModule grnModule = new GrnModule();
		grnModule.createGrn(driver,createdPO);


	}

	private static String createPo(WebDriver driver) throws Exception {
		PoCreation po = new PoCreation();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1800)");
		driver.findElement(By.xpath("//a[@data-test-id='card-link-po-2-0']")).click();
		String createdPO = po.poCreation(driver,"1000208","1001382",jse);
		return createdPO;
	}

}
