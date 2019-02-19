package qa.TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AdministrationPage;
import pages.HomePage;
import pages.LoginPage;
import util.TestUtil;

public class AdministrationPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	AdministrationPage administrationPage;
	AdministrationPage addcoursePage;
	
	String sheetName = "Course";
	
	public AdministrationPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		administrationPage = new AdministrationPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
		
	}
	
	

	@DataProvider
	public Object[][] AddCourse() {
	Object data[][]=TestUtil.getTestData(sheetName);
	return data;
	}
	
	@Test(priority=1 ,dataProvider="AddCourse")
	
	public void clickOnAddCourse(String ccode , String cname, String Tuition, String desc, String trgtdlrnrs, String cduration, String cmajor, String delmthd) throws InterruptedException{ 
	homePage.clickOnAdministratorLink();
	administrationPage.clickOnAddCourse(ccode,cname, Tuition, desc,  trgtdlrnrs, cduration, cmajor,  delmthd); 
	//homePage.clickOnAdministratorLink();
	} 
	

	/*@AfterMethod
	public void tearDown(){
		driver.quit();
		}*/
}
