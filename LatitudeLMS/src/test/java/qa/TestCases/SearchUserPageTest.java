package qa.TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchUsersPage;
import util.TestUtil;

public class SearchUserPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	SearchUsersPage searchuserPage;
	
	
	//String sheetName = "Search";
	
	public SearchUserPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		searchuserPage = new SearchUsersPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
		
	}
	
	
	/*@DataProvider
	public Object[][] SearchCourse() {
	Object data[][]=TestUtil.getTestData(sheetName);
	return data;
	}*/
	
	@Test
	
	public void clickOnUser() throws InterruptedException{ 
	homePage.clickOnAdministratorLink();
	searchuserPage.clickOnUser();
	
	} 
	

	/*@AfterMethod
	public void tearDown(){
		driver.quit();
		}*/
}
