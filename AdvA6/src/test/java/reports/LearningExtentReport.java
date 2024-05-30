package reports;

import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LearningExtentReport {
	@Test(description = "Login")
	public void script() {
		WebDriver driver;
		ScreenShotMethod ss = new ScreenShotMethod();
		LocalDateTime dateTime = LocalDateTime.now();
		String date = dateTime.toString().replace(":", "_");
		ExtentReports reports = new ExtentReports();
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extentsReport/"+date+".html");
		reports.attachReporter(reporter);
		ExtentTest extentTest = reports.createTest("login");
		driver = new ChromeDriver();
		extentTest.log(Status.INFO, "Browser is launched");
		driver.manage().window().maximize();
		extentTest.log(Status.INFO, "Browser is maximized");
		driver.get("https://demowebshop.tricentis.com/");
		extentTest.log(Status.INFO, "DemoWebShop is launched");
		driver.findElement(By.partialLinkText("Log in")).click();
		extentTest.log(Status.INFO, "login page is displayed");
		driver.findElement(By.id("Email")).sendKeys("csksathish1@gmail.com");
		extentTest.log(Status.INFO, "user entered email");
		driver.findElement(By.id("Password")).sendKeys("Csk@1995");
		extentTest.log(Status.INFO, "user has entered password");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		extentTest.log(Status.INFO, "user has clicked on login button");
		extentTest.log(Status.INFO, "DemoWebShop user home page displayed");
		
		try {
			if(driver.findElement(By.linkText("Log out")).isDisplayed()) {
				extentTest.pass(MediaEntityBuilder.createScreenCaptureFromPath(ss.takeScreenShot(driver)).build());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(ss.takeScreenShot(driver)).build());
			extentTest.log(Status.FAIL, "log in option not displayed");
		}
		driver.quit();
		reports.flush();
	}
	@Test
	public void script1() {
		WebDriver driver;
		ScreenShotMethod ss = new ScreenShotMethod();
		LocalDateTime dateTime = LocalDateTime.now();
		String date = dateTime.toString().replace(":", "_");
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extentsReport/"+date+".html");
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(reporter);
		ExtentTest extentTest =reports.createTest("Book");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		extentTest.log(Status.INFO, "Browser get maximized");
		driver.get("https://demowebshop.tricentis.com/");
		extentTest.log(Status.INFO, "Url has been trigered");
		driver.findElement(By.partialLinkText("Log in")).click();
		extentTest.log(Status.INFO, "login page is displayed");
		driver.findElement(By.id("Email")).sendKeys("csksathish1@gmail.com");
		extentTest.log(Status.INFO, "user entered email");
		driver.findElement(By.id("Password")).sendKeys("Csk@1995");
		extentTest.log(Status.INFO, "user has entered password");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		extentTest.log(Status.INFO, "user has clicked on login button");
		driver.findElement(By.linkText("Books")).click();
		extentTest.log(Status.INFO, "Click on book option");
		try {
			if(driver.getTitle().contains("Demo Web Shop. Books")) {
				extentTest.pass(MediaEntityBuilder.createScreenCaptureFromPath(ss.takeScreenShot(driver)).build());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(ss.takeScreenShot(driver)).build());
			extentTest.log(Status.FAIL, "log in option not displayed");
		}
		driver.quit();
		reports.flush();
		
		
		
		
		
	}

}
