package PageObjects;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BaseTest.BasePage;

public class Login_POM extends BasePage{
	WebDriverWait wait;
	Properties p;

	public Login_POM(WebDriver driver, Properties p) {
		super(driver);
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		this.p = p;
	}
	@FindBy(xpath="//input[@name='username']")
	WebElement usname;
	@FindBy(xpath="//input[@name='password']")
	WebElement pwd;
	@FindBy(xpath="//p[contains(text(),'Please enter a username and password.')]")
	WebElement Nousername;
	@FindBy(xpath="//p[contains(text(),'Please enter a username and password.')]")
	WebElement nopwd;
	@FindBy(xpath="//p[contains(text(),'The username and password could not be verified.')]")
	WebElement invalid;
	@FindBy(xpath="//input[@class='button']")
	WebElement loginbtn;
	@FindBy(xpath="//a[contains(text(),'About Us')]")
	WebElement aboutus;
	@FindBy(xpath="//a[contains(text(),'Services')]")
	WebElement services;
	@FindBy(xpath="//a[contains(text(),'Products')]")
	WebElement products;
	@FindBy(xpath="//a[contains(text(),'Locations')]")
	WebElement location;
	@FindBy(xpath="//a[contains(text(),'Admin Page')]")
	WebElement adminpage;
	@FindBy(xpath="//a[contains(text(),'home')]")
	WebElement home;

	@FindBy(xpath="//a[contains(text(),'Withdraw Funds')]")
	WebElement withdrawfnd;
	@FindBy(xpath="//ul[@class='services']/li/a[text()='Transfer Funds']")
	WebElement transferfnd;
	@FindBy(xpath="//a[contains(text(),'Check Balances')]")
	WebElement checkbal;
	@FindBy(xpath="//a[contains(text(),'Make Deposits')]")
	WebElement makedeposit;
	@FindBy(xpath="//a[contains(text(),'Bill Pay')]")
	WebElement billpay;
	@FindBy(xpath="//a[contains(text(),'Account History')]")
	WebElement accounthistory;
	@FindBy(xpath="//ul[@class='servicestwo']/li/a[text()='Transfer Funds']")
	WebElement transferfnds;
	@FindBy(xpath="//a[contains(text(),'Read More')]")
	WebElement readmore;
	@FindBy(xpath="//a[contains(text(),'ParaBank Is Now Re-Opened')]")
	WebElement parareopened;
	@FindBy(xpath="//a[contains(text(),'New! Online Bill Pay')]")
	WebElement newbillpay;
	@FindBy(xpath="//a[contains(text(),'New! Online Account Transfers')]")
	WebElement newaccounttransfer;
	@FindBy(xpath="//a[@href='news.htm'][1]")
	WebElement readmore1;
	public void titlecheck()
	{
		try {
			wait.until(ExpectedConditions.titleContains("ParaBank"));
			String title = driver.getTitle();
			String url = driver.getCurrentUrl();
			System.out.println("Page Title: " + title);
			System.out.println("Current URL: " + url);
			Assert.assertTrue(title.contains("ParaBank"), "Title does not contain ParaBank");
			Assert.assertTrue(url.contains("parabank.parasoft.com"), "URL does not contain parabank.parasoft.com");
		} catch(Exception e) {
			System.out.println("Title check failed!");
			System.out.println("Current Title: " + driver.getTitle());
			System.out.println("Current URL: " + driver.getCurrentUrl());
			throw e;
		}
	}
	public void urlcheck()
	{
		try {
			// Navigate to home
			/*driver.findElement(By.linkText("home")).click();
			wait.until(ExpectedConditions.urlContains("index.htm"));
			Assert.assertTrue(driver.getCurrentUrl().contains("index.htm"), "Home URL verification failed");
			System.out.println("✓ Home link verified");*/
			
			// Navigate to About Us
			driver.findElement(By.linkText("About Us")).click();
			wait.until(ExpectedConditions.urlContains("about.htm"));
			Assert.assertTrue(driver.getCurrentUrl().contains("about.htm"), "About Us URL verification failed");
			System.out.println("✓ About Us link verified");
			
			// Navigate to Services
			driver.findElement(By.linkText("Services")).click();
			wait.until(ExpectedConditions.urlContains("services.htm"));
			Assert.assertTrue(driver.getCurrentUrl().contains("services.htm"), "Services URL verification failed");
			System.out.println("✓ Services link verified");
			
			// Navigate back home before testing external links
			driver.findElement(By.linkText("home")).click();
			wait.until(ExpectedConditions.urlContains("index.htm"));
			
			// Skip external links (Products and Locations) as they navigate outside the app
			System.out.println("⊘ Skipping external links (Products/Locations)");
			
			// Navigate to Admin Page
			driver.findElement(By.linkText("Admin Page")).click();
			wait.until(ExpectedConditions.urlContains("admin.htm"));
			Assert.assertTrue(driver.getCurrentUrl().contains("admin.htm"), "Admin Page URL verification failed");
			System.out.println("✓ Admin Page link verified");
			
			// Navigate back home
			driver.findElement(By.linkText("home")).click();
			wait.until(ExpectedConditions.urlContains("index.htm"));
			Assert.assertTrue(driver.getCurrentUrl().contains("index.htm"), "Home URL verification failed");
			System.out.println("✓ Home link verified");

			System.out.println("***********ATM Services***********");
			
			// Withdraw Funds
			driver.findElement(By.linkText("Withdraw Funds")).click();
			wait.until(ExpectedConditions.urlContains("https://parabank.parasoft.com/parabank/services/ParaBank?wsdl"));
			Assert.assertTrue(driver.getCurrentUrl().contains("https://parabank.parasoft.com/parabank/services/ParaBank?wsdl"), "Withdraw Funds URL verification failed");
			System.out.println("✓ Withdraw Funds link verified");
			
			// Navigate back home before next ATM service
			/*driver.findElement(By.linkText("home")).click();
			wait.until(ExpectedConditions.urlContains("index.htm"));
			System.out.println("✓ Home link verified");*/

			
			// Transfer Funds
			driver.navigate().back();
			transferfnd.click();
			wait.until(ExpectedConditions.urlContains("https://parabank.parasoft.com/parabank/services/ParaBank?wsdl"));
			Assert.assertTrue(driver.getCurrentUrl().contains("https://parabank.parasoft.com/parabank/services/ParaBank?wsdl"), "Transfer Funds URL verification failed");
			System.out.println("✓ Transfer Funds link verified");
			
			// Navigate back home
			driver.navigate().back();
			// Check Balances
			checkbal.click();
			wait.until(ExpectedConditions.urlContains("ParaBank?wsdl"));
			Assert.assertTrue(driver.getCurrentUrl().contains("ParaBank?wsdl"), "Check Balances URL verification failed");
			System.out.println("✓ Check Balances link verified");
			
			
			// Make Deposits
			driver.navigate().back();
			makedeposit.click();
			wait.until(ExpectedConditions.urlContains("ParaBank?wsdl"));
			Assert.assertTrue(driver.getCurrentUrl().contains("ParaBank?wsdl"), "Make Deposits URL verification failed");
			System.out.println("✓ Make Deposits link verified");
			
			System.out.println("***********Online Services***********");
			
			driver.navigate().back();
			// Bill Pay
			billpay.click();
			wait.until(ExpectedConditions.urlContains("bank?_wadl"));
			Assert.assertTrue(driver.getCurrentUrl().contains("bank?_wadl"), "Bill Pay URL verification failed");
			System.out.println("✓ Bill Pay link verified");
			
			
			// Account History
			driver.navigate().back();
			accounthistory.click();
			wait.until(ExpectedConditions.urlContains("bank?_wadl"));
			Assert.assertTrue(driver.getCurrentUrl().contains("bank?_wadl"), "Account History URL verification failed");
			System.out.println("✓ Account History link verified");
			
			
			// Transfer Funds (Online Services)
			driver.navigate().back();

			transferfnds.click();
			wait.until(ExpectedConditions.urlContains("https://parabank.parasoft.com/parabank/services/bank?_wadl&_type=xml"));
			Assert.assertTrue(driver.getCurrentUrl().contains("https://parabank.parasoft.com/parabank/services/bank?_wadl&_type=xml"), "Transfer Funds (Online) URL verification failed");
			System.out.println("✓ Transfer Funds (Online) link verified");
			
			System.out.println("**********Latest News***********");
			
			driver.navigate().back();
			//wait.until(ExpectedConditions.urlContains("index.htm"));
			readmore.click();
			
			// ParaBank Is Now Re-Opened
			driver.navigate().back();

			parareopened.click();
			wait.until(ExpectedConditions.urlContains("news.htm"));
			Assert.assertTrue(driver.getCurrentUrl().contains("news.htm"), "ParaBank Is Now Re-Opened URL verification failed");
			System.out.println("✓ ParaBank Is Now Re-Opened link verified");
			
			driver.navigate().back();
			newbillpay.click();
			wait.until(ExpectedConditions.urlContains("https://parabank.parasoft.com/parabank/news.htm#5"));
			Assert.assertTrue(driver.getCurrentUrl().contains("https://parabank.parasoft.com/parabank/news.htm#5"));
			System.out.println("New! Online Bill pay link verified");
			
			driver.navigate().back();
			newaccounttransfer.click();
			wait.until(ExpectedConditions.urlContains("https://parabank.parasoft.com/parabank/news.htm#4"));
			Assert.assertTrue(driver.getCurrentUrl().contains("https://parabank.parasoft.com/parabank/news.htm#4"));
			System.out.println("New! Online Account Transfers link verified");
			
			driver.navigate().back();
			readmore1.click();
			wait.until(ExpectedConditions.urlContains("https://parabank.parasoft.com/parabank/news.htm"));
			Assert.assertTrue(driver.getCurrentUrl().contains("https://parabank.parasoft.com/parabank/news.htm"));
			System.out.println("Read more link under latest news is verified");
			
			System.out.println("✓ All URL checks passed successfully!");
		} catch(Exception e) {
			System.out.println("✗ URL check failed!");
			System.out.println("Current URL: " + driver.getCurrentUrl());
			System.out.println("Page Title: " + driver.getTitle());
			throw e;
		}
	}
	
	public void logincheck(String user, String password)
	{
		wait.until(ExpectedConditions.visibilityOf(usname));
		usname.clear();
		usname.sendKeys(user);
		
		wait.until(ExpectedConditions.visibilityOf(pwd));
		pwd.clear();
		pwd.sendKeys(password);
		
		loginbtn.click();
		
		// Add delay to allow page to process
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(user.isEmpty()) {
			wait.until(ExpectedConditions.visibilityOf(Nousername));
			Assert.assertTrue(Nousername.isDisplayed(),"Error message for username and password is not shown.");
			Assert.assertEquals(Nousername.getText(), "Please enter a username and password.");
			
		}
		else if(password.isEmpty())
		{
			wait.until(ExpectedConditions.visibilityOf(nopwd));
			Assert.assertTrue(nopwd.isDisplayed(), "Error message for password is not shown");
			Assert.assertEquals(nopwd.getText(), "Please enter a username and password.");
			
		}
		else if(user.equals("arthi")&& password.equals("Kesu@413"))
		{
			try {
				// Wait for URL to change or for a specific element on the overview page
				wait.until(ExpectedConditions.urlContains("overview"));
				String currentUrl = driver.getCurrentUrl();
				System.out.println("Login successful! Current URL: " + currentUrl);
				Assert.assertTrue(currentUrl.contains("overview"), "URL does not contain overview");
			} catch(Exception e) {
				System.out.println("Login validation failed!");
				System.out.println("Current URL: " + driver.getCurrentUrl());
				System.out.println("Page Title: " + driver.getTitle());
				System.out.println("Page Source snippet: " + driver.getPageSource().substring(0, Math.min(500, driver.getPageSource().length())));
				throw e;
			}
					
		}
		else
		{
			try {
				wait.until(ExpectedConditions.visibilityOf(invalid));
				Assert.assertTrue(invalid.isDisplayed(),"Error message for invalid username and password is not shown");
				Assert.assertEquals(invalid.getText(),"The username and password could not be verified.");
			} catch(Exception e) {
				System.out.println("Invalid credentials validation failed!");
				System.out.println("Current URL: " + driver.getCurrentUrl());
				System.out.println("Page Title: " + driver.getTitle());
				throw e;
			}
			
		}
	}
	
	public void logincred()
	{
		wait.until(ExpectedConditions.visibilityOf(usname));
		usname.clear();
		usname.sendKeys(p.getProperty("username"));
		
		wait.until(ExpectedConditions.visibilityOf(pwd));
		pwd.clear();
		pwd.sendKeys(p.getProperty("password"));
		loginbtn.click();
		//wait.until(ExpectedConditions.urlToBe("arabank.parasoft.com/parabank/login.htm;"));
	}


public void checkAboutUsLinks()
{
	// Navigate back to home first
	/*driver.findElement(By.linkText("home")).click();
	wait.until(ExpectedConditions.urlContains("index.htm"));
	
	aboutuslink.click();
	wait.until(ExpectedConditions.urlContains("https://parabank.parasoft.com/parabank/about.htm"));
	Assert.assertTrue(driver.getCurrentUrl().contains("https://parabank.parasoft.com/parabank/about.htm"));
	System.out.println("✓ About Us link verified");
	
	contactuslink.click();
	wait.until(ExpectedConditions.urlContains("https://parabank.parasoft.com/parabank/contact.htm"));
	System.out.println("✓ Contact Us link verified");*/
}
}
