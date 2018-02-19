package zoosite.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import zoosite.pageelements.AdoptionPassLocators;
import zoosite.steps.AbstractSteps;


public class AdoptionPassPage extends AbstractSteps{
	
	Properties prop = getProp();
	WebDriver browser = getDriver();
	
////	Properties prop;
//	
//	public AdoptionPassPage(WebDriver browser, Properties prop){
//		super(browser, prop);
//	//	this.prop=prop;
//	}

	public void enterDetails(){
		browser.findElement(AdoptionPassLocators.name).sendKeys(prop.getProperty("name"));
		browser.findElement(AdoptionPassLocators.address).sendKeys(prop.getProperty("address"));
		browser.findElement(AdoptionPassLocators.postcode).sendKeys(prop.getProperty("postcode"));
		browser.findElement(AdoptionPassLocators.email).sendKeys(prop.getProperty("email"));
	}
	
	public void submitDetails(){
		browser.findElement(AdoptionPassLocators.submitAdoption).click();
	}
}
