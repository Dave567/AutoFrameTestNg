package zoosite.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import zoosite.pageelements.AdoptionFailPageLocators;
import zoosite.steps.AbstractSteps;
//import zoosite.util.Base;

public class AdoptionFailPage extends AbstractSteps{
	
	Properties prop = getProp();
	WebDriver browser = getDriver();
	
//	//Properties prop;
//
//	public AdoptionFailPage(WebDriver browser, Properties prop) {
//		super(browser, prop);
//	//	this.prop = prop;
//	}
	
	
	public String getFailMessage(){
		return browser.findElement(AdoptionFailPageLocators.failMessage).getText();
		}
}
