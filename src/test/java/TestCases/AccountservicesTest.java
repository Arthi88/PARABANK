package TestCases;

import org.testng.annotations.Test;

import BaseTest.Baseclass;
import PageObjects.AccountServices;
import Utilities.AccountDetailsutils;

public class AccountservicesTest extends Baseclass {
	@Test
	public void opennewaccounttest() {
		AccountServices as= new AccountServices(driver,p);
		as.opennewaccount();
	    as.accountoverview();
	}
	@Test(priority=3)
	public void accountdetailsdisplay()
	{
		AccountDetailsutils accountdetail=new AccountDetailsutils(driver);
		accountdetail.printaccountdetails();
	}

}
