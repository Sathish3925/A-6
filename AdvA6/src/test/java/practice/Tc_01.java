package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Tc_01 {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demowebshop.tricentis.com/");
	WebElement computer = driver.findElement(By.xpath("(//a[contains(text(),'Computers')])[1]"));
	Actions action = new Actions(driver);
	action.moveToElement(computer).build().perform();
	Thread.sleep(5000);
	WebElement acc = driver.findElement(By.linkText("Accessories"));
	action.moveToElement(acc);
	action.click().build().perform();
	
}
}
