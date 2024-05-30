package reports;

import java.io.File;
import java.time.LocalDateTime;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotMethod {
	public String takeScreenShot(WebDriver driver) {
		LocalDateTime dateTime = LocalDateTime.now();
		String date = dateTime.toString().replace(":", "_");
		String path = "./screenShot/"+date+".png";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(path);
		try {
			FileHandler.copy(source, target);
			
		} catch (Exception e) {
			
			// TODO: handle exception
		}
		return "." + path;
		
		
		
	}

}
