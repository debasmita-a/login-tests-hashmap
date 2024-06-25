package driverfactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
	WebDriver driver;
	Properties prop;
	
	public WebDriver init_driver() {
		String browserName = prop.getProperty("browser");
		switch (browserName) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "msedge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Provide correct browser name.. " + browserName);
			break;
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
	}
	
	public Properties init_prop() {
		FileInputStream input;
		prop = new Properties();
		try {
			input = new FileInputStream("./src/test/resources/configfile/config.properties");
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
