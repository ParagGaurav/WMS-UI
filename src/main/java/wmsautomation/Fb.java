package wmsautomation;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;


public class Fb {
    WebDriver driver;
    @BeforeClass
    public  void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "/Users/paraggaurav/Downloads/Software/chromedriver-mac-arm64/chromedriver");

        driver = new ChromeDriver();
        driver.get("https://facebook.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Thread.sleep(2000);
    }
    @Test(dataProvider = "dataset")
    public void test(String email, String password) throws IOException, InterruptedException {


        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.name("login")).click();


    }

    @DataProvider
    private Object[][] dataset() throws IOException {
        String path = "/Users/paraggaurav/Downloads/TestData.xlsx";
        FileInputStream file = new FileInputStream(path);
        XSSFWorkbook book = new XSSFWorkbook(file);

        XSSFSheet sheet = book.getSheetAt(0);
        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(1).getLastCellNum();
        Object b[][] = new Object[rows][cols];
        for (int i = 1; i < rows; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int c = 0; c < cols; c++) {
                XSSFCell cell = row.getCell(c);
                switch (cell.getCellType()) {
                    case STRING: {
                        b[i][c] = cell.getStringCellValue();
                        break;
                    }
                    case NUMERIC: {
                        double cellVal = cell.getNumericCellValue();
                        BigDecimal bdItemCode = new BigDecimal(cellVal);
                        b[i][c] = bdItemCode.toPlainString();
                        break;
                    }
                }
                System.out.println(b[i][c]);
            }
        }
        return b;
    }

}
