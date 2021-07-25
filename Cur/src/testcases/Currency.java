package testcases;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.ExcelUtils;


public class Currency {

	
	//public static void main(String[] args) throws IOException {
	@Test
		public void CurrencyTest() throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\exc\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		ExcelUtils file = new ExcelUtils();
		Sheet Sheet1 = file.readExcel(System.getProperty("user.dir")+"\\","src\\testdata\\cur.xlsx" , "Sheet1");
		driver.get("https://www.xe.com/currencyconverter/");
		WebElement inputcur=driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/section/div[2]/div/main/form/div[1]/div[1]"));
		//driver.findElement(By.xpath("//*[@id=\"midmarketFromCurrency\"]")).click();
		WebElement fromcur=driver.findElement(By.xpath("//*[@id=\"midmarketFromCurrency\"]"));
		//driver.findElement(By.id("midmarketToCurrency")).click();
		WebElement tocur=driver.findElement(By.id("midmarketToCurrency"));
		//driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/section/div[2]/div/main/form/div[2]/button")).click();
		
		
		
		
		int rowCount = Sheet1.getLastRowNum()-Sheet1.getFirstRowNum();
 
        //iterate over all the row to print the data present in each cell.
        for(int i=1;i<=rowCount;i++)
        {
         //Enter the values read from Excel in firstname,lastname,mobile,email,address
        Row row = Sheet1.getRow(i);
         inputcur.sendKeys(row.getCell(i).toString());
         driver.findElement(By.xpath("//*[@id=\"midmarketFromCurrency\"]")).click();
         fromcur.sendKeys(row.getCell(i+1).toString());
         driver.findElement(By.xpath("//*[@id=\"midmarketFromCurrency\"]")).sendKeys(Keys.ENTER);
         driver.findElement(By.id("midmarketToCurrency")).click();
         tocur.sendKeys(row.getCell(i+2).toString());
         driver.findElement(By.id("midmarketToCurrency")).sendKeys(Keys.ENTER);
         driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/section/div[2]/div/main/form/div[2]/button")).click();
         
	}

}

}