package com.ipt.octbatch.IPT_Project_Zoho;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zoho_Project {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\WELCOME\\eclipse-workspace\\IPT_Project_Zoho\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.get("https://www.zoho.com/");
		
		WebElement freeSignUpButton = driver.findElement(By.xpath("//a[contains (text(), 'Free Sign')]"));
		freeSignUpButton.click();
		
		WebElement emailBox = driver.findElement(By.id("emailfield"));
		String userName = XLSX_Reader.readSingleData("zoho", 1, 0);
		emailBox.sendKeys(userName);
		
		WebElement passwordBox = driver.findElement(By.id("password"));
		String 	password = XLSX_Reader.readSingleData("zoho", 1, 1);
		passwordBox.sendKeys(password);
		
		WebElement mobileBox = driver.findElement(By.id("rmobile"));
		String mob_NO = XLSX_Reader.readSingleData("zoho", 1, 2);
		mobileBox.sendKeys(mob_NO);
		
		WebElement tAndC_CheckBox = driver.findElement(By.id("signup-termservice"));
		boolean selected = tAndC_CheckBox.isSelected();
		System.out.println("Check box is selected "+ selected);
		if (selected==true) {
			tAndC_CheckBox.click();
		}
		
		WebElement signUpButton = driver.findElement(By.id("signupbtn"));
		signUpButton.click();
		
		TakesScreenshot errorPage = (TakesScreenshot)driver;
		File source = errorPage.getScreenshotAs(OutputType.FILE);
		File destinaton = new File("C:\\Users\\WELCOME\\eclipse-workspace\\IPT_Project_Zoho\\ScreenShot\\zohoLoginError.png");
		FileUtils.copyFile(source, destinaton);
		
		Thread.sleep(5000);
//		driver.close();
		
		
	}

}
