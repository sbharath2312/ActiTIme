package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericlibs.webActionUtil;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver, webActionUtil webactionutil) {
		super(driver, webactionutil);
	}
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(name="pwd")
	private WebElement password;
	
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	@FindBy(id="loginButton")
	private WebElement loginbutton;
	
	@FindBy(id="keepLoggedInCheckBox")
	private WebElement remembercheckbox;

	public WebElement getRemembercheckbox() {
		return remembercheckbox;
	}

	public ExtraTimeTrackerPage login(String usernameData, String passwordData) {
		
		webactionutil.enterdata(username, usernameData);
		webactionutil.enterdata(password, passwordData);
		webactionutil.clickorJsClick(loginbutton);
		return new ExtraTimeTrackerPage(driver, webactionutil);
		
		
	}
	
	

}
