package TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseTest.Baseclass;
import PageObjects.Login_POM;
import Utilities.AccountDetailsutils;
import Utilities.TestDataProvider;

public class Login_Test extends Baseclass {
	@Test(dataProvider = "logindata", dataProviderClass = TestDataProvider.class,priority=1)
	public void loginpage(String user, String password)
	{
		Login_POM lg= new Login_POM(driver,p);
		lg.logincheck(user,password);
		lg.titlecheck();
         
		
	}
	@Test(priority=2)
	public void linkval()
	{
		Login_POM link=new Login_POM(driver,p);
		link.urlcheck();
		link.checkAboutUsLinks();
		
	}
	

}
