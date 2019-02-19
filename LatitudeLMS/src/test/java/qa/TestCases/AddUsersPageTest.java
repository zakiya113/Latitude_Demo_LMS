package qa.TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AddUsersPage;
import pages.HomePage;
import pages.LoginPage;
import util.TestUtil;

public class AddUsersPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	AddUsersPage addusersPage;
	//AdministrationPage addcoursePage;
	
	String sheetName = "Users";
	
	public AddUsersPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		addusersPage = new AddUsersPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
		
	}
	
	

	@DataProvider
	public Object[][] AddUser() {
	Object data[][]=TestUtil.getTestData(sheetName);
	return data;
	}
	
	@Test(priority=1 ,dataProvider="AddUser")
	
	public void clickOnAddUser(String uname, String fname, String lname, String uemail,String pwd,String cpwd, String mob,String ustreet,String ucity,String ucountry,String ustate,String uzip ) throws InterruptedException{ 
	homePage.clickOnAdministratorLink();
	addusersPage.clickOnAddUser(uname, fname, lname, uemail,pwd, cpwd,  mob, ustreet, ucity, ucountry, ustate, uzip); 
	//homePage.clickOnAdministratorLink();
	} 
	

	/*@AfterMethod
	public void tearDown(){
		driver.quit();
		}*/
}
