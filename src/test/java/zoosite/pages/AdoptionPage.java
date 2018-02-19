package zoosite.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import zoosite.pageelements.AdoptionPageLocators;
import zoosite.pageelements.HomePageLocators;
import zoosite.steps.AbstractSteps;
//import zoosite.util.Base;

public class AdoptionPage extends AbstractSteps {
	
	Properties prop = getProp();
	WebDriver browser = getDriver();
	
//	// Properties prop;
//	
//	public AdoptionPage(WebDriver browser, Properties prop) {
//		super(browser, prop);
//	//	this.prop = prop;
//	}


	public void  selectStartDate(){
		Select startDateBox = new Select(browser.findElement(AdoptionPageLocators.startDate));
		startDateBox.selectByValue(prop.getProperty("startDate"));
	}
	
	public void checkAvailability(){
		browser.findElement(AdoptionPageLocators.selectAnimal).click();
		
	}
	
	public void checkAvailability2(){
		browser.findElement(AdoptionPageLocators.selectAnimal2).click();
		
	}


	public void navigateToAdoption() {
		browser.findElement(HomePageLocators.adoption).click();

	}

}
