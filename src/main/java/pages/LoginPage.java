package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By username = By.id("username");
	private By password = By.id("password");
	private By submit = By.id("submit");
	
	private By loginSuccessMsg = By.xpath("//h1");
	private By errorMsgUsername = By.id("error");
	
	private By logout = By.linkText("Log out");
	
	public String doLogin(String un, String pass) {
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(submit).click();		
		String msg = driver.findElement(loginSuccessMsg).getText();
		driver.findElement(logout).click();
		return msg;
	}
	

}
