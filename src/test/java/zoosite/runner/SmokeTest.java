package zoosite.runner;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import zoosite.steps.AbstractSteps;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber.json"}, 
				features = {"src/test/java/zoosite/features/"},
				glue ={"zoosite/steps/"},
				tags = {"@Smoke"}
					)


public class SmokeTest extends AbstractSteps {

private TestNGCucumberRunner testNGCucumberRunner;
	
	@DataProvider
	public Object[][] features(){
		return testNGCucumberRunner.provideFeatures();
		
	}
	
	@BeforeClass(alwaysRun=true)
    public void beforeClass() throws Exception{
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
	  @AfterClass (alwaysRun=true)
	    public void afterClass(){
		  testNGCucumberRunner.finish();
	    }
	
	
	@Test(groups="cucumber", description="runs cucumber feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature){
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}
}