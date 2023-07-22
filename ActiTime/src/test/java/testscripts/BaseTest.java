package testscripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import genericlibs.constants;
import genericlibs.webActionUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.Commonpage;
import pom.ExtraTimeTrackerPage;
import pom.LoginPage;

public class BaseTest implements constants{
	
	//author bharath kumar s
	WebDriver driver;
	webActionUtil webactionutil;
	ExtraTimeTrackerPage extraTimeTrackerPage;
	@Parameters ({"browsername","appurl","ito","eto"})
	@BeforeClass(alwaysRun = true)
	public void setUp(@Optional(DEFAULT_BROWSER)String browsername,@Optional(APP_url) String appurl,
					  @Optional(ITO)String ito, @Optional(ETO)String eto) {
		if(browsername.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disabled-notification");
		driver=new ChromeDriver();}
		else if(browsername.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--disabled-notification");
			driver=new FirefoxDriver();	
		}else {
			Assert.fail("only two browesr available");
		}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ito)));
	driver.get(appurl);
	webactionutil=new webActionUtil(driver,Long.parseLong(eto));
	}
	@Parameters({"username","password"})
	@BeforeMethod(alwaysRun = true)
	public void login(@Optional(USERNAME) String username,@Optional(PASSWORD) String password) {
		extraTimeTrackerPage=new LoginPage(driver, webactionutil).login(username, password);
	}
	
	@AfterMethod(alwaysRun = true)
	public void logout() {
		new Commonpage(driver, webactionutil).logout();
	}
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
				

}
