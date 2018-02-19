package zoosite.steps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import okio.Timeout;

public class AbstractSteps {
	
	//protected static WebDriver browser;
	protected Properties prop = new Properties();
	protected FileInputStream fis;
	
	
	 //Declare ThreadLocal Driver (ThreadLocalMap) for ThreadSafe Tests
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
 
    @BeforeMethod
    @Parameters(value={"browser"})
    public void setupTest (String browser) throws MalformedURLException {
        //Set DesiredCapabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        //Firefox Profile Settings
        /*if (browser=="firefox") {
            FirefoxProfile profile = new FirefoxProfile();
            //Accept Untrusted Certificates
            profile.setAcceptUntrustedCertificates(true);
            profile.setAssumeUntrustedCertificateIssuer(false);
            //Use No Proxy Settings
            profile.setPreference("network.proxy.type", 0);
            //Set Firefox profile to capabilities
            capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        }*/
     if (browser=="internet explorer") {
    	
    	 InternetExplorerDriver profile = new InternetExplorerDriver();    	 
    	 capabilities.setCapability(InternetExplorerDriver.BROWSER_ATTACH_TIMEOUT, profile.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS));
     }
//        capabilities = DesiredCapabilities.internetExplorer(); 
//       
//        
//       
//        		//WebDriver driver = new InternetExplorerDriver(capabilities);
//        }
        
        //Set BrowserName
        capabilities.setCapability("browserName", browser);
        
        //Set Browser to ThreadLocalMap
        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities));
      //  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
        
        driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          
    }
 
    @BeforeMethod
    public WebDriver getDriver() {
        //Get driver from ThreadLocalMap
        return driver.get();
    }
 
    @AfterMethod
    public void tearDown() throws Exception {
        getDriver().quit();
    }
 
    @AfterClass void terminate () {
        //Remove the ThreadLocalMap element
        driver.remove();
    }
	
	public Properties getProp(){
			
			try {
				fis = new FileInputStream("C:\\Users\\Devagouda\\Desktop\\testng\\Zoositetest-master\\src\\test\\java\\zoosite\\util\\data.properties");
				prop.load(fis);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		return prop;
	}

}
