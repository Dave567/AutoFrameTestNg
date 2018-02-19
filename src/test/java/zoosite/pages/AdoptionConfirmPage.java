package zoosite.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import zoosite.pageelements.AdoptionConfirmPageLocators;
import zoosite.steps.AbstractSteps;


public class AdoptionConfirmPage extends AbstractSteps{
	
	Properties prop = getProp();
	WebDriver browser = getDriver();
	
//	public AdoptionConfirmPage(WebDriver browser, Properties prop){
//		super(browser , prop);
//	//	this.prop =prop;
//	}
	
	public String getSuccesMessage(){
		return browser.findElement(AdoptionConfirmPageLocators.message).getText();
	}

}
