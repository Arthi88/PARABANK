package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountDetailsutils {
	public WebDriver driver;
	
	public AccountDetailsutils(WebDriver driver)
	{
		this.driver=driver;
	}
	public void printaccountdetails()
	{
		WebElement accountdetails=driver.findElement(By.xpath("//table[@id='accountTable']//tr/td[1]"));
		accountdetails.click();
		String accountnumber=driver.findElement(By.xpath("//div[@id='accountDetails']//tr/td[1]")).getText();
		System.out.println("Account number is:"+accountnumber);
		String accounttype=driver.findElement(By.xpath("//td[@id='accountType'][1]")).getText();
		System.out.println("Account type is:"+accounttype);
		String accountbal=driver.findElement(By.xpath("//td[@id='balance'][1]")).getText();
		System.out.println("Account balance is:"+accountbal);
		String availablebal=driver.findElement(By.xpath("//td[@id='availableBalance'][1]")).getText();
		System.out.println("Available balance is:"+availablebal);
		
	}

}
