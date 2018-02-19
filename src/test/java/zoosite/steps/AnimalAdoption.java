package zoosite.steps;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import zoosite.pages.AdoptionConfirmPage;
import zoosite.pages.AdoptionPage;
import zoosite.pages.AdoptionPassPage;
import zoosite.pages.ZooHomePage;

public class AnimalAdoption extends AbstractSteps{
	
	Properties prop = getProp();
	WebDriver browser = getDriver();
	
	
	@Given("^I am on the home page of Zoo site$")
	public void openZooSite() throws Throwable {
		browser.navigate().to(prop.getProperty("url"));     
	}

	@And("^I adopt an animal$")
	public void adoptAnimal() throws Throwable {
		AdoptionPassPage adoptPassPage = new AdoptionPassPage();
		adoptPassPage.enterDetails();
		adoptPassPage.submitDetails();	    
	}
	
	@When("^I goto Adoption page and check foravailability$")
	public void gotoAdoptionpageCheckAvailability() throws Throwable {
			ZooHomePage homePage = new ZooHomePage();
		   homePage.navigateToAdoption();
		   AdoptionPage adoptPage = new AdoptionPage();
		   adoptPage.selectStartDate();
		   adoptPage.checkAvailability();		   
	}

	@Then("^I should see the success message \"([^\"]*)\"$")
	public void verifyAdoptionMessage(String successMessage) throws Throwable {
		  AdoptionConfirmPage adoptConfirmPage = new AdoptionConfirmPage();
		  String actual= adoptConfirmPage.getSuccesMessage().toLowerCase();  
		  Assert.assertEquals(successMessage, actual);	 
	}


}

