package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory-OR:
	//Page Factory-OR
		@FindBy(id="ctlTemplate_regMainBody_ctlLogin_sID")
		WebElement username;
		
		@FindBy(id="ctlTemplate_regMainBody_ctlLogin_sPassword")
		WebElement password;
		
		@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_ctlLogin_cmdLogin']")
		WebElement loginBtn;
		
		@FindBy(xpath="//img[@id='ctlTemplate_regMainBody_ctl01_siteLogoHeader']")
		WebElement logo;
	
	//Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
		}
	
	public boolean validateLatitudeLMSImage() {
		return logo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException {
		username.sendKeys(un);
		Thread.sleep(2000);
		password.sendKeys(pwd);
		Thread.sleep(2000);
		loginBtn.click();
		Thread.sleep(2000);
		
		return new HomePage();
		
	}
	
}
