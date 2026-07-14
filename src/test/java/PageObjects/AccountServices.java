package PageObjects;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BaseTest.BasePage;

public class AccountServices extends BasePage {
	WebDriverWait wait;
	Properties p;

	public AccountServices(WebDriver driver, Properties p) {
		super(driver);
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//this.p=p;
		Login_POM log= new Login_POM(driver,p);
		log.logincred();
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//a[contains(text(),'Open New Account')]")
	WebElement Openaccountlink;
	/*@FindBy(xpath="//div[@id='showOverview']//table")
	WebElement account;*/
	@FindBy(xpath="//select[@id='type']")
	WebElement opennewaccountdetail;
	@FindBy(xpath="//select[@id='fromAccountId']")
	WebElement accountid;
	@FindBy(xpath="//input[@class='button']")
    WebElement opennewaccountbtn;
	@FindBy(xpath="//div[@id='openAccountResult']//a")
	WebElement accountnumclick;
	@FindBy(xpath="//a[contains(text(),'Accounts Overview')]")
	WebElement Accountoverview;
	@FindBy(xpath="//table[@id='accountTable']//tr/td[1]")
	WebElement showoverview;
	@FindBy(xpath="//h1[contains(text(),'Account Opened!')]")
	WebElement gettitle; 
	@FindBy(xpath="//input[@type='submit']")
	WebElement Gobtn;
	
	public void opennewaccount() {
		Openaccountlink.click();
		//System.out.println(account.getText());
		Select dropdown= new Select(opennewaccountdetail);
		for(int i=0;i<dropdown.getOptions().size();i++) {
			dropdown.selectByIndex(i);
			
		}
		Select dropaccountid= new Select(accountid);
		dropaccountid.selectByIndex(0);
		opennewaccountbtn.click();
		wait.until(ExpectedConditions.visibilityOf(gettitle));
		String title=gettitle.getText();
		String url=driver.getCurrentUrl();
		Assert.assertTrue(url.contains("https://parabank.parasoft.com/parabank/openaccount.htm"),"URL is not correct");
		Assert.assertEquals(title, "Account Opened!");
		accountnumclick.click();
		
		
	}
	public void accountoverview()
	{
		Accountoverview.click();
		//accountnumber.click();
		wait.until(ExpectedConditions.visibilityOf(gettitle));
		System.out.println(gettitle.getText());
		
		
		Select dropmonth= new Select(driver.findElement(By.xpath("//select[@id='month']")));
		for(int i=0;i<dropmonth.getOptions().size();i++)
		{
			dropmonth.selectByIndex(i);
			System.out.println(dropmonth.getFirstSelectedOption().getText());
			
		}
		Select droptransaction= new Select(driver.findElement(By.xpath("//select[@id='transactionType']")));
		for(int i=0;i<droptransaction.getOptions().size();i++)
		{
			droptransaction.selectByIndex(i);
			System.out.println(droptransaction.getFirstSelectedOption().getText());
		}	
		wait.until(ExpectedConditions.visibilityOf(Gobtn));
		Gobtn.click();
	}
	

}
