package com.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.basefiles.BaseClass;
import com.property.ConfigurationHelper;
import com.runner.runner;
import com.web.sdp.SDP;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass {
	public static WebDriver driver = runner.driver;
	SDP sdp = new SDP(driver);
	
	@Given("zoho Site Launch")
	public void zoho_site_launch() throws Exception {
		launchUrl(ConfigurationHelper.getInstance().getUrl());
	}

	@When("go To Zoho Homepage Send {string} {string} {string}")
	public void go_to_zoho_homepage_send(String userName, String password, String mob_NO) {
		WebElement freeSignUpButton = sdp.getHomePage().getFreeSignUpButton();
//				driver.findElement(By.xpath("//a[contains (text(), 'Free Sign')]"));
//		freeSignUpButton.click();
		clickOnElement(freeSignUpButton);

		WebElement emailBox = driver.findElement(By.id("emailfield"));
//		String userName = XLSX_Reader.readSingleData("zoho", 1, 0);
		userInput(emailBox, userName);

		WebElement passwordBox = sdp.getSignUpPage().getPasswordBox();
//		String password = XLSX_Reader.readSingleData("zoho", 1, 1);
		userInput(passwordBox, password);

		WebElement mobileBox = sdp.getSignUpPage().getMobileBox();
//		String mob_NO = XLSX_Reader.readSingleData("zoho", 1, 2);
		userInput(mobileBox, mob_NO);

		WebElement tAndC_CheckBox = sdp.getSignUpPage().getTAndC_CheckBox();
		boolean selected = isElementSelected(tAndC_CheckBox);
		System.out.println("Check box is selected " + selected);
		if (selected == true) {
			clickOnElement(tAndC_CheckBox);
		}

		WebElement signUpButton = sdp.getSignUpPage().getSignUpButton();
		clickOnElement(signUpButton);
	}

	@When("click Submit Takescreenshot")
	public void click_submit_takescreenshot() throws Exception {
		capture("zohoCucuErr");
		sleep(3000);
	}

}
