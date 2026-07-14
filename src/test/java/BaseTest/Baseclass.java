package BaseTest;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Baseclass {
	 public WebDriver driver;
	    public Properties p;
	@BeforeMethod
	public void setup() throws IOException {
	    driver = new ChromeDriver();
	    FileReader file = new FileReader("./src/test/resources/config.properties");
	    p=new Properties();
	p.load(file);
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.get(p.getProperty("url"));
	}
	@AfterMethod
	    public void teardown()
	{
	    driver.quit();
	}

}
