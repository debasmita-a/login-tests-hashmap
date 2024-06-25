package basetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import driverfactory.DriverFactory;
import pages.LoginPage;

public class BaseTest {

	protected WebDriver driver;
	protected Properties prop;
	protected DriverFactory df;
	protected LoginPage loginPage;
	
	@BeforeTest
	public void init() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver();
		loginPage = new LoginPage(driver);
	}
}
