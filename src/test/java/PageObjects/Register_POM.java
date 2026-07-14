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

public class Register_POM extends BasePage {
	 WebDriverWait wait;

	    public Register_POM(WebDriver driver, Properties p) {
	        super(driver);
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    }
	    @FindBy(xpath="//a[contains(text(),'Register')]")
	    WebElement Regclick;


	    @FindBy(xpath = "//input[@id='customer.firstName']")
	    WebElement Firstname;
	    @FindBy(xpath = "//input[@id='customer.lastName']")
	    WebElement Lastname;
	    @FindBy(xpath = "//input[@id='customer.address.street']")
	    WebElement Address;
	    @FindBy(xpath = "//input[@id='customer.address.city']")
	    WebElement City;
	    @FindBy(xpath = "//input[@id='customer.address.state']")
	    WebElement State;
	    @FindBy(xpath = "//input[@id='customer.address.zipCode']")
	    WebElement Zip;
	    @FindBy(xpath = "//input[@id='customer.phoneNumber']")
	    WebElement Phne;
	    @FindBy(xpath = "//input[@id='customer.ssn']")
	    WebElement SSN;
	    @FindBy(xpath = "//input[@id='customer.username']")
	    WebElement Username;
	    @FindBy(xpath = "//input[@id='customer.password']")
	    WebElement psswd;
	    @FindBy(xpath = "//input[@id='repeatedPassword']")
	    WebElement repeatpwd;
	    @FindBy(xpath = "//input[@value='Register']")
	    WebElement Registrbtn;
	    @FindBy(xpath="//span[@id='customer.firstName.errors']")
	    WebElement NoFirstnme;
	    @FindBy(xpath="//span[@id='customer.lastName.errors']")
	    WebElement NoLastnme;

	    @FindBy(xpath="//span[@id='customer.address.city.errors']")
	    WebElement NoAddress;
	    @FindBy(xpath="//span[@id='customer.address.state.errors']")
	    WebElement NoState;
	    @FindBy(xpath="//span[@id='customer.address.zipCode.errors']")
	    WebElement NoZip;
	    @FindBy(xpath="//span[@id='customer.ssn.errors']")
	    WebElement Nossn;
	    @FindBy(xpath="//span[@id='customer.username.errors']")
	    WebElement NoUsername;
	    @FindBy(xpath="//span[@id='customer.password.errors']")
	    WebElement passwd;
	    @FindBy(xpath = "//span[@id='repeatedPassword.errors']")
	    WebElement Norepeatpwd;
	    @FindBy(xpath="//h1[@class='title']")
	    WebElement gettitle;

	    public void Regdetails_check(String firstnme, String lstnme, String address, String city, String state, String zip_code, String Phone, String ssn, String usrnme, String pwd, String confirm) {
	        Regclick.click();

	    	Firstname.clear();
	        Firstname.sendKeys(firstnme);
	        Lastname.clear();
	        Lastname.sendKeys(lstnme);
	        Address.clear();
	        Address.sendKeys(address);
	        City.clear();
	        City.sendKeys(city);
	        State.clear();
	        State.sendKeys(state);
	        Zip.clear();
	        Zip.sendKeys(zip_code);
	        Phne.clear();
	        Phne.sendKeys(Phone);
	        SSN.clear();
	        SSN.sendKeys(ssn);
	        Username.clear();
	        Username.sendKeys(usrnme);
	        psswd.clear();
	        psswd.sendKeys(pwd);
	        repeatpwd.clear();
	        repeatpwd.sendKeys(confirm);
	        Registrbtn.click();
	        
	        // Wait for page to load after registration
	        try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        
	        try {
	            // Check if we're on the success page by looking for the success message
	            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//p[contains(text(),'Your account was created successfully')]")));
	            WebElement successMsg = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully')]"));
	            Assert.assertTrue(successMsg.isDisplayed());
	        } catch(Exception e) {
	            if (firstnme.isEmpty()) {
	                wait.until(ExpectedConditions.visibilityOf(NoFirstnme));
	                Assert.assertTrue(NoFirstnme.isDisplayed());
	                Assert.assertEquals(NoFirstnme.getText(),"First name is required");
	            } else if (lstnme.isEmpty()) {
	                wait.until(ExpectedConditions.visibilityOf(NoLastnme));
	                Assert.assertTrue(NoLastnme.isDisplayed());
	                Assert.assertEquals(NoLastnme.getText(),"Last name is required");
	            } else if (address.isEmpty()) {
	                wait.until(ExpectedConditions.visibilityOf(NoAddress));
	                Assert.assertTrue(NoAddress.isDisplayed());
	                Assert.assertEquals(NoAddress.getText(),"Address is required");
	            } else if (city.isEmpty()) {
	                wait.until(ExpectedConditions.visibilityOf(NoAddress));
	                Assert.assertTrue(NoAddress.isDisplayed());
	                Assert.assertEquals(NoAddress.getText(),"City is required");
	            } else if (state.isEmpty()) {
	                wait.until(ExpectedConditions.visibilityOf(NoState));
	                Assert.assertTrue(NoState.isDisplayed());
	                Assert.assertEquals(NoState.getText(),"State is required");
	            } else if (zip_code.isEmpty()) {
	                wait.until(ExpectedConditions.visibilityOf(NoZip));
	                Assert.assertTrue(NoZip.isDisplayed());
	                Assert.assertEquals(NoZip.getText(),"Zip code is required");
	            } else if (ssn.isEmpty()) {
	                wait.until(ExpectedConditions.visibilityOf(Nossn));
	                Assert.assertTrue(Nossn.isDisplayed());
	                Assert.assertEquals(Nossn.getText(),"SSN is required");
	            } else if (usrnme.isEmpty()) {
	                wait.until(ExpectedConditions.visibilityOf(NoUsername));
	                Assert.assertTrue(NoUsername.isDisplayed());
	                Assert.assertEquals(NoUsername.getText(),"Username is required");
	            } else if (pwd.isEmpty()) {
	                wait.until(ExpectedConditions.visibilityOf(passwd));
	                Assert.assertTrue(passwd.isDisplayed());
	                Assert.assertEquals(passwd.getText(),"Password is required");
	            } else if (confirm.isEmpty()) {
	                wait.until(ExpectedConditions.visibilityOf(Norepeatpwd));
	                Assert.assertTrue(Norepeatpwd.isDisplayed());
	                Assert.assertEquals(Norepeatpwd.getText(),"Password confirmation is required");
	            }
	        }
	    }
	    public  void regbutton()
	    {
	        Registrbtn.click();
	    }
	}


