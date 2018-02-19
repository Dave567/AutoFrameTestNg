package zoosite.steps;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import zoosite.pages.AdoptionConfirmPage;
import zoosite.pages.AdoptionFailPage;
import zoosite.pages.AdoptionPage;
import zoosite.pages.ZooHomePage;


public class AnimalAdoption2 extends AbstractSteps{
	
	//WebDriver browser = getDriver();
	//Properties prop = getProp();
	
	@When("^I goto Adoption page and check for unavailability$")
	public void gotoAdoptionpageCheckAvailability2() throws Throwable {
		ZooHomePage homePage = new ZooHomePage();
		   homePage.navigateToAdoption();
		   AdoptionPage adoptPage = new AdoptionPage();
		   adoptPage.selectStartDate();
		   adoptPage.checkAvailability2();
		   
	}
	
	@Then("^I should see the error message \"([^\"]*)\"$")
	public void verifyAdoptionFailMessage(String failMesage) throws Throwable {
		  AdoptionFailPage adoptFailPage = new AdoptionFailPage();
		  String actual= adoptFailPage.getFailMessage().toLowerCase();  
		  Assert.assertEquals(failMesage, actual);
	}

}
