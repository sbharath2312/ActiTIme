package genericlibs;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class FrameUtil implements constants {
	public static String takesScreenshot(WebDriver driver, String testcaseName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File tempfile = ts.getScreenshotAs(OutputType.FILE);
		
		String timestamp = LocalDateTime.now().toString().replace(":", "_");
		String newfile=IMG_PATH+timestamp+testcaseName+".png";
		FileUtils.copyFile(tempfile,new File(newfile));
		return newfile;	
	}
	
	public static void Sleeptosleep(long sleep) {
		try {
			Thread.sleep(sleep*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
