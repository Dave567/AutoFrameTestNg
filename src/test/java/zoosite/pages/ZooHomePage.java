package zoosite.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import zoosite.pageelements.HomePageLocators;
import zoosite.steps.AbstractSteps;
//import zoosite.util.Base;

public class ZooHomePage extends AbstractSteps {
	
	Properties prop = getProp();
	WebDriver browser = getDriver();
	
////	Properties prop;
//	
//	public ZooHomePage(WebDriver browser, Properties prop) {
//		super(browser, prop);
//		//this.prop =prop;
//	}

	public void navigateToAdoption(){
		browser.findElement(HomePageLocators.adoption).click();
		}

}
