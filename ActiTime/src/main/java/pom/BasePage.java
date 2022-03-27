package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import genericlibs.webActionUtil;

public class BasePage {
	WebDriver driver;
	webActionUtil webactionutil;
public BasePage(WebDriver driver,webActionUtil webactionutil) {
	this.webactionutil=webactionutil;
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
}
