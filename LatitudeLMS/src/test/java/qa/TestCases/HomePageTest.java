package qa.TestCases;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import pages.AdministrationPage;
import pages.HomePage;
import pages.LoginPage;
import util.TestUtil;
import base.TestBase;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	HomePage administrator;
	AdministrationPage administrationPage;
	
	
	
	
	public HomePageTest() {
		super();
	}
	
	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
				initialization();
				testUtil = new TestUtil();
		//restaurantPage = new RestaurantPage();
			loginPage = new LoginPage();
			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@Test(priority=1)
	public void clickOnAdministratorLink() throws InterruptedException{
		
		administrator = homePage.clickOnAdministratorLink();
		Thread.sleep(3000);
		//administrationPage = AdministrationPage.clickOnAddCourse(ccode , cname,  Tuition,  desc,  trgtdlrnrs, cduration,  cmajor,  delmthd); 
		
	}
		
		
		
	/*@AfterMethod
	public void tearDown(){
		driver.quit();
		}
	*/
}
