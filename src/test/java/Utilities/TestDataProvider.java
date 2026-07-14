package Utilities;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	    @DataProvider(name = "register")
	    public Object[][] register() {
	        return new Object[][]{
	                {"arthi", "k", "Ramaniyam senate", "chennai", "TN", "600078", "8937682657", "NIL", "arthi", "Kesu@413", "Kesu@413"},
	                {"", "k", "Ramaniyam senate", "chennai", "TN", "600078", "8937682657", "NIL", "arthi", "Kesu@413", "Kesu@413"},
	                {"arthi", "", "Ramaniyam senate", "chennai", "TN", "600078", "8937682657", "NIL", "arthi", "Kesu@413", "Kesu@413"},
	                {"arthi", "k", "", "chennai", "TN", "600078", "8937682657", "NIL", "arthi", "Kesu@413", "Kesu@413"},
	                {"arthi", "k", "Ramaniyam senate", "", "TN", "600078", "8937682657", "NIL", "arthi", "Kesu@413", "Kesu@413"},
	                {"arthi", "k", "Ramaniyam senate", "chennai", "", "600078", "8937682657", "NIL", "arthi", "Kesu@413", "Kesu@413"},
	                {"arthi", "k", "Ramaniyam senate", "chennai", "TN", " ", "8937682657", "NIL", "arthi", "Kesu@413", "Kesu@413"},
	                {"arthi", "k", "Ramaniyam senate", "chennai", "TN", "600078", " ", "NIL", "arthi", "Kesu@413", "Kesu@413"},
	                {"arthi", "k", "Ramaniyam senate", "chennai", "TN", "600078", "8937682657", " ", "arthi", "Kesu@413", "Kesu@413"},
	                {"arthi", "k", "Ramaniyam senate", "chennai", "TN", "600078", "8937682657", "NIL", " ", "Kesu@413", "Kesu@413"},
	                {"arthi", "k", "Ramaniyam senate", "chennai", "TN", "600078", "8937682657", "NIL", "arthi", " ", "Kesu@413"},
	                {"arthi", "k", "Ramaniyam senate", "chennai", "TN", "600078", "8937682657", "NIL", "arthi", "Kesu@413", " "},
	                {"arthi", "k", "Ramaniyam senate", "chennai", "TN", "600078", "8937682657", "NIL", "arthi", "Kesu@413", "Kesu@167"},

                    

	        };
	    }
	    
    
    @DataProvider(name = "logindata")
    public Object[][] loginData() {
        return new Object[][]{
                {"", ""},  // No username and no password
                {"arthi", ""}, // No password
                {"", "Kesu@413"}, // No username
                {"arthi", "Kesu@413"}, // Valid credentials
                {"arthi", "wrongpassword"}, // Invalid password
        };
    }
}

