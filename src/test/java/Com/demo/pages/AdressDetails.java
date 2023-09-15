package Com.demo.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Com.demo.utilities.CommonUtility;




public class AdressDetails {

WebDriver driver;
	
	static Logger log=Logger.getLogger(AdressDetails.class.getName());
	
	Properties pro=new Properties();
	
	@FindBy(id="BillingNewAddress_FirstName")
    WebElement name;
	
    @FindBy(id="BillingNewAddress_LastName")
    WebElement last;
    
    @FindBy(id="BillingNewAddress_Email")
    WebElement email;
    
    @FindBy(id="BillingNewAddress_Company")
    WebElement comp;
    
    @FindBy(id="BillingNewAddress_CountryId")
    WebElement country;
    
    @FindBy(id="BillingNewAddress_StateProvinceId")
    WebElement state;
    
    @FindBy(id="BillingNewAddress_City")
    WebElement city;
    
    @FindBy(id="BillingNewAddress_Address1")
    WebElement ad1;
    
    @FindBy(id="BillingNewAddress_Address2")
    WebElement ad2;
    
    @FindBy(id="BillingNewAddress_ZipPostalCode")
    WebElement zip;
    
    @FindBy(id="BillingNewAddress_PhoneNumber")
    WebElement ph;
    
    @FindBy(id="BillingNewAddress_FaxNumber")
    WebElement fax;
    
    @FindBy(xpath="//*[@id=\"billing-buttons-container\"]/input")
    WebElement cont;


    public AdressDetails(WebDriver driver) throws IOException
    {
    	this.driver=driver;
    	
    }

   public void sendAdress(String a,String b,String c,String d,String e,String f,String g,String h) throws IOException, InterruptedException
   {
	  
       Thread.sleep(1000);
       comp.sendKeys(a);
       Thread.sleep(1000);
       Select sel=new Select(country);
       Thread.sleep(1000);
       sel.selectByVisibleText(b);
       Thread.sleep(1000);
       Select se=new Select(state);
       se.selectByIndex(0);
       Thread.sleep(1000);
       city.sendKeys(c);
       Thread.sleep(1000);
       ad1.sendKeys(d);
       Thread.sleep(1000);
       ad2.sendKeys(e);
       Thread.sleep(1000);
       zip.sendKeys(f);
       Thread.sleep(1000);
       ph.sendKeys(g);
       Thread.sleep(1000);
       fax.sendKeys(h);
       Thread.sleep(1000);
       cont.click();
   }
}
