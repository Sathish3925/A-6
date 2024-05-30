package ecom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoWebShop1_Test {
	@Test
	public void demoWebShop1() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("Window is maximized",true);
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		driver.quit();
	}

}
