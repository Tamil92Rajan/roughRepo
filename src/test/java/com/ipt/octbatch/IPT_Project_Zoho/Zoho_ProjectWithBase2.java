package com.ipt.octbatch.IPT_Project_Zoho;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.basefiles.BaseClass;
import com.property.ConfigurationHelper;
import com.web.sdp.SDP;

public class Zoho_ProjectWithBase2 extends BaseClass{
//	public static SDP sdp;
	public static void main(String[] args) throws IOException, InterruptedException {
		String browser = ConfigurationHelper.getInstance().getBrowser();
		browserLaunch(browser);
		SDP sdp = new SDP(driver);
		maximize();
		implicitlyWait(5);
		launchUrl(ConfigurationHelper.getInstance().getUrl());
		
		WebElement freeSignUpButton = sdp.getHomePage().getFreeSignUpButton();
		clickOnElement(freeSignUpButton);
		
		WebElement emailBox =sdp.getSignUpPage().getEmailBox();
		String userName = XLSX_Reader.readSingleData(ConfigurationHelper.getInstance().getSheet(), 1, 0);
		userInput(emailBox, userName);
		
		WebElement passwordBox = sdp.getSignUpPage().getPasswordBox();
		String 	password = XLSX_Reader.readSingleData(ConfigurationHelper.getInstance().getSheet(), 1, 1);
		userInput(passwordBox, password);
		
		WebElement mobileBox = sdp.getSignUpPage().getMobileBox();
		String mob_NO = XLSX_Reader.readSingleData(ConfigurationHelper.getInstance().getSheet(), 1, 2);
		userInput(mobileBox, mob_NO);
		
		WebElement tAndC_CheckBox = sdp.getSignUpPage().getTAndC_CheckBox();
		boolean selected = isElementSelected(tAndC_CheckBox);
		System.out.println("Check box is selected "+ selected);
		if (selected==true) {
			clickOnElement(tAndC_CheckBox);
		}
		
		WebElement signUpButton = sdp.getSignUpPage().getSignUpButton();
		clickOnElement(signUpButton);
		
		capture("zohologinerr");
		sleep(5000);
		quit();
		
	}

}
