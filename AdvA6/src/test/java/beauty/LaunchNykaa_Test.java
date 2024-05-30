package beauty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LaunchNykaa_Test {
	@Test
	public void nykaa() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("Window is maximized",true);
		driver.get("https://www.nykaa.com/");
		Thread.sleep(2000);
		driver.quit();
		
	}

}
