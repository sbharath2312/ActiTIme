package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericlibs.webActionUtil;

public class Commonpage extends BasePage{
	
	@FindBy(id="logoutLink")
	private WebElement logoutlink;
	

	public WebElement getLogoutlink() {
		return logoutlink;
	}


	public Commonpage(WebDriver driver, webActionUtil webactionutil) {
		super(driver, webactionutil);
		// TODO Auto-generated constructor stub
	}
	public void logout() {
		webactionutil.clickorJsClick(logoutlink);
		
	}

}
