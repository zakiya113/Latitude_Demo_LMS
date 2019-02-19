package qa.TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchCoursePage;
import util.TestUtil;

public class SearchCoursePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	SearchCoursePage searchcoursePage;
	
	
	String sheetName = "Search";
	
	public SearchCoursePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		searchcoursePage = new SearchCoursePage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
		
	}
	
	
	@DataProvider
	public Object[][] SearchCourse() {
	Object data[][]=TestUtil.getTestData(sheetName);
	return data;
	}
	
	@Test(priority=1 ,dataProvider="SearchCourse")
	
	public void clickOnAddCourse(String key , String ccode, String cat, String mjr, String delmthd) throws InterruptedException{ 
	homePage.clickOnAdministratorLink();
	searchcoursePage.clickOnSearchCourse(key,ccode, cat, mjr, delmthd); 
	
	} 
	

	/*@AfterMethod
	public void tearDown(){
		driver.quit();
		}*/
}
