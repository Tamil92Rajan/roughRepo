package com.ipt.octbatch.IPT_Project_Zoho;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.basefiles.BaseClass;

public class Zoho_ProjectWithBase extends BaseClass{

	public static void main(String[] args) throws IOException, InterruptedException {
		browserLaunch("chrome");
		maximize();
		implicitlyWait(5);
		launchUrl("https://www.zoho.com/");
		
		WebElement freeSignUpButton = driver.findElement(By.xpath("//a[contains (text(), 'Free Sign')]"));
		clickOnElement(freeSignUpButton);
		
		WebElement emailBox = driver.findElement(By.id("emailfield"));
		String userName = XLSX_Reader.readSingleData("zoho", 1, 0);
		userInput(emailBox, userName);
		
		WebElement passwordBox = driver.findElement(By.id("password"));
		String 	password = XLSX_Reader.readSingleData("zoho", 1, 1);
		userInput(passwordBox, password);
		
		WebElement mobileBox = driver.findElement(By.id("rmobile"));
		String mob_NO = XLSX_Reader.readSingleData("zoho", 1, 2);
		userInput(mobileBox, mob_NO);
		
		WebElement tAndC_CheckBox = driver.findElement(By.id("signup-termservice"));
		boolean selected = isElementSelected(tAndC_CheckBox);
		System.out.println("Check box is selected "+ selected);
		if (selected==true) {
			clickOnElement(tAndC_CheckBox);
		}
		
		WebElement signUpButton = driver.findElement(By.id("signupbtn"));
		clickOnElement(signUpButton);
		
		capture("zohologinerr");
		sleep(5000);
		quit();
		
	}

}
