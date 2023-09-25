package wmsautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;


import java.util.Iterator;
import java.util.Set;


public class LaunchWmsWebsite {

    public void launchWms(WebDriver driver, String createdPo) throws InterruptedException {


        JavascriptExecutor jse = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://wms-web.sayurbox.tech/welcome");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='button']")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String p = it.next();
        String c = it.next();
        String c1 = it.next();
        driver.switchTo().window(c1);

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("parag@sayurbox.com");
        driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Parag@0852");
        driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
        Thread.sleep(3000);
        driver.switchTo().window(c);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//p[normalize-space()='RCV']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='srch-term']")).sendKeys(createdPo);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Terima Barang']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(),'User Roles')]")).click();
        Thread.sleep(2000);


    }
}
