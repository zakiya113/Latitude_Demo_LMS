package qa.TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPositionPage;
import util.TestUtil;

public class SearchPositionPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	SearchPositionPage searchpositionPage;
	
	
	String sheetName = "SearchPos";
	
	public SearchPositionPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		searchpositionPage = new SearchPositionPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
		
	}
	
	
	@DataProvider
	public Object[][] SearchPosition() {
	Object data[][]=TestUtil.getTestData(sheetName);
	return data;
	}
	
	@Test(priority=1 ,dataProvider="SearchPosition")
	
	public void clickOnSearchPosition(String sname , String scode, String edname) throws InterruptedException{ 
	homePage.clickOnAdministratorLink();
	searchpositionPage.clickOnSearchPosition(sname,scode, edname); 
	
	} 
	

	/*@AfterMethod
	public void tearDown(){
		driver.quit();
		}*/
}
