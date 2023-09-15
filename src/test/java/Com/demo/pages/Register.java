package Com.demo.pages;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.demo.utilities.CommonUtility;




public class Register {

	static WebDriver driver;

	public static String em;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
    WebElement regis;

	@FindBy(name="Gender")
	WebElement fm;

	@FindBy(name="FirstName")
	WebElement f;

	@FindBy(name="LastName")
	WebElement l;

	@FindBy(name="Email")
	WebElement ema;

	@FindBy(name="Password")
	WebElement p;

	@FindBy(name="ConfirmPassword")
	WebElement pp;

	@CacheLookup
	@FindBy(id="register-button")
	WebElement r;

	public  void registration() throws IOException, InterruptedException {
		
		List<String> list= CommonUtility.main();
		String fn=list.get(0);
		String ln=list.get(1);
		em=CommonUtility.getEmail();
		String ps=list.get(3);
		String ps1=list.get(4);
		
		regis.click();
		Thread.sleep(1000);
		fm.click();
		Thread.sleep(1000);
		f.sendKeys(fn);
		Thread.sleep(1000);
		l.sendKeys(ln);
		Thread.sleep(1000);
		ema.sendKeys(em);
		Thread.sleep(1000);
		p.sendKeys(ps);
		Thread.sleep(1000);
		pp.sendKeys(ps1);
		
		r.click();
	}
}
