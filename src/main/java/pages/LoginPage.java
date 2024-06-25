package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By username = By.id("username");
	private By password = By.id("password");
	private By submit = By.id("submit");
	
	private By loginSuccessMsg = By.xpath("//h1");
	private By errorMsg = By.id("error");
	
	private By logout = By.linkText("Log out");
	
	public void doLogin(String un, String pass) {
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(submit).click();			
	}
	
	public String doLoginWithCorrectData(String un, String pass) {
		doLogin(un, pass);
		String msg = driver.findElement(loginSuccessMsg).getText();
		driver.findElement(logout).click();
		return msg;
	}
	
	public String doLoginWithInCorrectData(String un, String pass) {
		doLogin(un, pass);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String msg = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg)).getText();
		return msg;
	}
	
	public String doGenericLogin(String un, String pass) {
		doLogin(un, pass);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if(driver.getCurrentUrl().contains("logged-in-successfully")) {
			String msg = wait.until(ExpectedConditions.visibilityOfElementLocated(loginSuccessMsg)).getText();
			driver.findElement(logout).click();
			return msg;
		}else{
			String msg = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg)).getText();
			return msg;
		}
	}
	

}
