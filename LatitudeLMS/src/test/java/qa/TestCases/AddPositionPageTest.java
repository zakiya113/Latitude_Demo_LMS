package qa.TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AddPostionPage;
import pages.HomePage;
import pages.LoginPage;
import util.TestUtil;

public class AddPositionPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	AddPostionPage addpositionPage;
	//AdministrationPage addcoursePage;
	
	String sheetName = "Position";
	
	public AddPositionPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		addpositionPage = new AddPostionPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
		
	}
	
	

	@DataProvider
	public Object[][] AddPosition() {
	Object data[][]=TestUtil.getTestData(sheetName);
	return data;
	}
	
	@Test(priority=1 ,dataProvider="AddPosition")
	
	public void clickOnAddPosition(String pcode, String pname, String edname) throws InterruptedException{ 
	homePage.clickOnAdministratorLink();
	addpositionPage.clickOnAddPosition(pcode,pname, edname); 
	//homePage.clickOnAdministratorLink();
	} 
	

	/*@AfterMethod
	public void tearDown(){
		driver.quit();
		}*/
}
