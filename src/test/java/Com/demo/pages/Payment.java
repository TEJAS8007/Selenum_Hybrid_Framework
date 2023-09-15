package Com.demo.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class Payment {

	WebDriver driver;
	 
	 static Logger log=Logger.getLogger(Payment.class.getName());
	 
	 @FindBy(xpath="//*[@id=\"shipping-buttons-container\"]/input")
    WebElement firstCont;
    @FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/input")
    WebElement SecondCont;
    @FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/input")
    WebElement thirdCont;
    @FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/input")
    WebElement fourth;
    @FindBy(xpath = "//*[@id=\"confirm-order-buttons-container\"]/input")
    WebElement fifth;
    
    
    public Payment(WebDriver driver)
    {
   	 this.driver=driver;
    }
    
    public void PayDone() throws InterruptedException
    {
   	 driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
   	
   	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   	 Thread.sleep(2000);
   	 firstCont.click();
   	 Thread.sleep(2000);
   	 SecondCont.click();
   	 Thread.sleep(2000);
   	 thirdCont.click();
   	 Thread.sleep(3000);
   	 fourth.click();
   	 Thread.sleep(3000);
   	 fifth.click();
    }
    
    
}
