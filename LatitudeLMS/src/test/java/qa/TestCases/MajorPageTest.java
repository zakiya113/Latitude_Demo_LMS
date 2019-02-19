package qa.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.MajorPage;
import util.TestUtil;

public class MajorPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	MajorPage majorPage;
	
	String sheetName = "Major";
	
	public MajorPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		majorPage = new MajorPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	
	@DataProvider
	public Object[][] AddMajor() {
	Object data[][]=TestUtil.getTestData(sheetName);
	return data;
	}
	
	@Test(priority=1 ,dataProvider="AddMajor")
	
	public void clickOnAddMajor(String mjcode, String mjname, String desc) throws InterruptedException{ 
	homePage.clickOnAdministratorLink();
	majorPage.clickOnAddMajor(mjcode, mjname, desc); 
	
	} 
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
		}
}
