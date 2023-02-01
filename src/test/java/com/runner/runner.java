
package com.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.basefiles.BaseClass;
import com.property.ConfigurationHelper;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/com/features/ZohoFeatureOne.feature", glue="com.stepdefinition",
monochrome = true,
plugin = {"pretty", "html:Reports/htmlreport.html", "json:Reports/jsonreport.json",
		"junit:Reports/junitReport.xml"})
public class runner {
	public static WebDriver driver = null;
	@BeforeClass
	public static void setUp() throws IOException {
		driver = BaseClass.browserLaunch(ConfigurationHelper.getInstance().getBrowser());
		BaseClass.maximize();
		BaseClass.implicitlyWait(4);
	}
	@AfterClass
	public static void tearDown() {
		BaseClass.quit();
	}
}
