package practice;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Snapshot {
	@Test
	public void name() {
		WebDriver driver = new ChromeDriver();
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extentReport/.html");
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(reporter);
		ExtentTest test = reports.createTest("login");
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(null).build());
		reports.flush();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = "./screenshot";
		File dst = new File(path);
		try {
			org.openqa.selenium.io.FileHandler.copy(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
