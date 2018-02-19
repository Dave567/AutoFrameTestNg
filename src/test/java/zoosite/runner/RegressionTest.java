package zoosite.runner;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import gherkin.formatter.model.Scenario;
import zoosite.steps.AbstractSteps;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber.json"}, 
				features = {"src/test/java/zoosite/features/"},
				glue ={"zoosite/steps/"},
				tags = {"@Regression"}
					)


public class RegressionTest extends AbstractSteps{
	private TestNGCucumberRunner testNGCucumberRunner;
	
	@DataProvider
	public Object[][] features(){
		return testNGCucumberRunner.provideFeatures();
		
	}
	
	@BeforeClass(alwaysRun=true)
    public void beforeClass() throws Exception{
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		 driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
	  @AfterClass (alwaysRun=true)
	    public void afterClass(){
		  testNGCucumberRunner.finish();		  
	    }
	
	@Test(groups="cucumber", description="runs cucumber feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature){
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
		 driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

}