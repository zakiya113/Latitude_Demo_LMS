package qa.TestCases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;


public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
		@BeforeMethod
	public void setUp() {
				initialization();
		loginPage = new LoginPage();
		
	}
		
		@Test(priority=1)
		public void loginPageTitleTest() {
			
			 String title = loginPage.validateLoginPageTitle();
			 Assert.assertEquals(title,"Login");
		}
		
		
		@Test(priority=2)
		public void latitudeLMSImageTest() {
			boolean flag = loginPage.validateLatitudeLMSImage();
			Assert.assertTrue(flag);
		}
		
		@Test(priority=3)
		public void loginTest() throws InterruptedException {
			homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
