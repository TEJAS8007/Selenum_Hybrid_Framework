package Com.demo.test;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Com.demo.pages.AddtoCart;
import Com.demo.pages.AdressDetails;
import Com.demo.pages.LoginPage;
import Com.demo.pages.Payment;
import Com.demo.pages.Register;
import Com.demo.utilities.CommonUtility;


public class DemoWebTest {

	static WebDriver driver;

	Properties pro=new Properties();

	FileInputStream fi;

	Logger logger;

	@BeforeSuite
	public void openBrowser() throws IOException
	{
		fi=new FileInputStream("src//test//resources//Properties//DemoWeb.properties");
		pro.load(fi);

		System.setProperty(pro.getProperty("key"),pro.getProperty("value"));
		driver=new ChromeDriver();
	}

	@BeforeTest
	@Parameters({"url"})
	public void getUrl(String url)
	{
		driver.get(url);
		Assert.assertEquals(url, driver.getCurrentUrl());	
	}

	@BeforeClass
	public void maxi()
	{
		driver.manage().window().maximize();
		logger=LogManager.getLogger(this.getClass());
		logger.debug("debugging ***********");
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void getCookies() {

		Set<Cookie>det=driver.manage().getCookies();
		logger.info(det.size());

	}

	@Test(priority = 1)
	public void regClass() throws IOException, InterruptedException
	{
		logger.info("Registration Class");
		Register reg=PageFactory.initElements(driver,Register.class);
		String title=driver.getTitle();
		if(title.equals(driver.getTitle()))
		{
			logger.info("title Verified ..");
		}
		reg.registration();
	}

	@Test( priority = 2)
	public void LogClass() throws InterruptedException, IOException 
	{
		logger.info("Login Page");
		LoginPage login=PageFactory.initElements(driver,LoginPage.class);
		String title=driver.getTitle();
		if(title.equals(driver.getTitle()))
		{
			logger.info("title Verified ..");
		}
		login.loginAction();
	}

	@Test(priority = 3)
	public void aadtcartclass() throws InterruptedException
	{
		logger.info("Add TO Cart Class");
		AddtoCart add=PageFactory.initElements(driver,AddtoCart.class);
		String title=driver.getTitle();
		if(title.equals(driver.getTitle()))
		{
			logger.info("title Verified ..");
		}
		add.Addd();
	}

	@Test(priority = 4,dataProvider = "getData")
	public void AddressClass(String cm,String co,String cit,String add,String addd,String zp,String ph,String fx) throws IOException, InterruptedException
	{
		logger.info("Address Class");
		AdressDetails addr=PageFactory.initElements(driver,AdressDetails.class);
		String title=driver.getTitle();
		if(title.equals(driver.getTitle()))
		{
			logger.info("title Verified ..");
		}
		addr.sendAdress(cm,co,cit,add,addd,zp,ph,fx);
	}

	@Test(priority = 5)
	public void PaymentClass() throws InterruptedException, IOException
	{
		logger.info("Payment Is In Progress");
		Payment pay=PageFactory.initElements(driver,Payment.class);
		String title=driver.getTitle();

		if(title.equals(driver.getTitle()))
		{
			logger.info("title Verified ..");
		}
		pay.PayDone();

		Thread.sleep(1000);
		File img=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(img, new File("src//test//resources//DemowebScreenShot//DemoWeb.jpg"));


	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj=CommonUtility.getpaymentdata("src//test//resources//Excel//Hybrid.xlsx", "Sheet1");
		return obj;
	} 








}
