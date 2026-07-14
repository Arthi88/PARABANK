package TestCases;

import org.testng.annotations.Test;

import BaseTest.Baseclass;
import PageObjects.Register_POM;
import Utilities.TestDataProvider;

public class Register_Test extends Baseclass {
    @Test(priority = 1, dataProvider = "register", dataProviderClass = TestDataProvider.class)
	public void Registerpage(String firstnme, String lstnme, String address, String city, String state, String zip_code, String Phone, String ssn, String usrnme, String pwd, String confirm)
	{
		Register_POM reg= new Register_POM(driver, p);
        reg.Regdetails_check(firstnme,lstnme,address, city, state, zip_code, Phone, ssn, usrnme, pwd, confirm);
        reg.regbutton();
    }
}