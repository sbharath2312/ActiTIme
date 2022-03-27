package genericlibs;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webActionUtil {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	public void enterdata(WebElement ele, String sendkeys ) {
		ele.clear();
		ele.sendKeys(sendkeys);
	}
	public webActionUtil(WebDriver driver, long eto) {
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(eto));
		 js=(JavascriptExecutor) driver;
	}
	public void clickorJsClick(WebElement ele) {
		try {
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
		}
		catch(Exception e) {
			wait.until(ExpectedConditions.visibilityOf(ele));
			js.executeScript("arguments[0].click();", ele);
		}
	}
	public void Scroll(int xpixels, int ypixels) {
		js.executeScript("scrollBy(arguments[0],arguments[1]);", xpixels,ypixels);
	}
	public void JsEnterData(WebElement ele, String keytosend) {
		js.executeAsyncScript("arguments[0].value=arguments[1];",ele,keytosend);
	}
	public void waitUtilUrl(String urlFraction) {
		wait.until(ExpectedConditions.urlContains(urlFraction));
	}
	
	

}
