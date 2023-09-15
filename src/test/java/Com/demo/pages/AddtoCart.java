package Com.demo.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class AddtoCart {

WebDriver driver;
	
	static Logger log=Logger.getLogger(AddtoCart.class.getName());
	
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[3]/div/div/div[3]/div[3]/div/div[2]/div[3]/div[2]/input")
    WebElement Addto;
	@FindBy(linkText = "Shopping cart")
	WebElement cart;
	@FindBy(id="termsofservice")
	WebElement checkbox;
	@FindBy(id="checkout")
	WebElement checkout;
//	@FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[1]/div[3]/input[1]")
//	WebElement AsGuest;
	
	
	public AddtoCart(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void Addd() throws InterruptedException
	{
		Thread.sleep(1000);
		Addto.click();
		Thread.sleep(1000);
		cart.click();
		Thread.sleep(1000);
		checkbox.click();
		Thread.sleep(1000);
		checkout.click();
		Thread.sleep(1000);
	    //AsGuest.click();
	}
	
	
}
