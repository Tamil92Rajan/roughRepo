package com.web.sdp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.pom.HomePage;
import com.pom.SignUpPage;

public class SDP {
	public WebDriver driver;
	
	public HomePage hp;
	public SignUpPage sp;
	
	public SDP(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	public HomePage getHomePage() {
		if (hp==null) {
			hp = new HomePage(driver);
		}
		return hp;
	}
	

	public SignUpPage getSignUpPage() {
		if (sp==null) {
			sp = new SignUpPage(driver);
		}
		return sp;
	}

}
