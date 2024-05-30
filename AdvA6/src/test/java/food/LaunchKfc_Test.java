package food;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LaunchKfc_Test {
	@Test
	public void kfc() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("Window is maximized",true);
		driver.get("https://online.kfc.co.in/");
		Thread.sleep(2000);
		driver.quit();
	}

}
