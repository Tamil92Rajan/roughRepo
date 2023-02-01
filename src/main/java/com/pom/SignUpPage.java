package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	public WebDriver driver;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains (text(), 'Free Sign')]")
	private WebElement freeSignUpButton;

	public WebElement getFreeSignUpButton() {
		return freeSignUpButton;
	}

	@FindBy(id = "emailfield")
	private WebElement emailBox;

	public WebElement getEmailBox() {
		return emailBox;
	}

	@FindBy(id = "password")
	private WebElement passwordBox;

	public WebElement getPasswordBox() {
		return passwordBox;
	}

	@FindBy(id = "rmobile")
	private WebElement mobileBox;

	public WebElement getMobileBox() {
		return mobileBox;
	}

	@FindBy(id = "signup-termservice")
	private WebElement tAndC_CheckBox;

	public WebElement getTAndC_CheckBox() {
		return tAndC_CheckBox;
	}

	@FindBy(id = "signupbtn")
	private WebElement signUpButton;

	public WebElement getSignUpButton() {
		return signUpButton;
	}
	

}
