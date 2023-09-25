package wmsautomation;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class GrnModule {

    public void createGrn(WebDriver driver,String createdPo) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        driver.findElement(By.xpath("//p[normalize-space()='GRN']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='srch-term']")).sendKeys(createdPo);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='col-sm-12 col-md-12']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='mt-2 mb-2 row']")).click();
        Thread.sleep(2000);


        String skuno = driver.findElement(By.xpath("//label[normalize-space()='SKU Number']/following-sibling::input")).getAttribute("value");
        jse.executeScript("window.scrollBy(0,700)");

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 7);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateAfter7Days = formatter.format(cal.getTime());
        driver.findElement(By.xpath("//input[@id='expirationDate-AcceptForm-0']")).clear();
        driver.findElement(By.xpath("//input[@id='expirationDate-AcceptForm-0']")).sendKeys(dateAfter7Days);
        Thread.sleep(2000);
        List<WebElement> ripenessLevel = driver.findElements(By.xpath("//select[@id='ripeLevel-AcceptForm-0']/option"));
        ripenessLevel.get(2).click();
        Thread.sleep(2000);
        List<WebElement> changeArea = driver.findElements(By.xpath("//select[@id='changeArea-AcceptForm-0']/option"));
        changeArea.get(3).click();
        Thread.sleep(2000);
        System.out.println("test::" + driver.findElement(By.xpath("//div[4]//div[1]//input[1]")).getAttribute("value"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='qtyUop-AcceptForm-0']")).sendKeys(driver.findElement(By.xpath("//div[4]//div[1]//input[1]")).getAttribute("value"));
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,200)");
        driver.findElement(By.xpath("//div[@id='root']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='btn btn-outline-success w-100']")).click();
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
        driver.findElement(By.xpath("//button[normalize-space()='Submit Pallet Untuk Dipindahkan']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Iya, Tandai Pallet']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='modal_close_button']")).click();
        jse.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='ContinueButton']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='mt-2 mb-2 row']")).click();
        if(driver.findElement(By.xpath("//label[normalize-space()='SKU Number']/following-sibling::input")).getAttribute("value")== skuno){
            driver.findElement(By.xpath("//span[@class='previous round ml-2']")).click();
            jse.executeScript("window.scrollBy(0,300)");
            System.out.println();


        }







       /* WebElement rL = driver.findElement(By.xpath("//select[@id='ripeLevel-AcceptForm-0']"));
        Select ripenessLevel = new Select(rL);
        ripenessLevel.selectByVisibleText("Level 2");*/









    }




}
