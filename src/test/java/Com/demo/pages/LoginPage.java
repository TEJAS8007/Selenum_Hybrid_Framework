package Com.demo.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Com.demo.utilities.CommonUtility;



public class LoginPage {

	WebDriver driver;
	Properties pro=new Properties();
	FileInputStream fi;
	
	@FindBy(className ="ico-logout")
	WebElement logout;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	WebElement login;
	
	@FindBy(name="Email")
	WebElement email;
	
	@FindBy(name="Password")
	WebElement pass;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")
	WebElement logbutton;
	
	
	public LoginPage(WebDriver driver) throws IOException
	{
		this.driver=driver;
		
	}
	
	public void loginAction() throws InterruptedException, IOException
	{
	    fi=new FileInputStream("src//test//resources//Properties//DemoWeb.properties");
        pro.load(fi);
		Thread.sleep(1000);
		logout.click();
		Thread.sleep(500);
		login.click();
		Thread.sleep(500);
		email.sendKeys(Register.em);
		
		Thread.sleep(500);
		pass.sendKeys(pro.getProperty("ps1"));
		
		Thread.sleep(500);
		logbutton.click();
	}
	
	
	
	
	
	
	
}
