package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class SearchUsersPage extends TestBase {
	SearchUsersPage searchuserPage;
	
	
	
	
	/*@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_txtFilterCourseName']")
	WebElement keyword;
	
	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_ctlCourseSearch_pnlSearchFilter_dListCourseNumber_txtFilterCourseNumber']")
	WebElement coursecode;
	
	@FindBy(xpath="//option[@value='132616']")
	WebElement catalog;
	
	@FindBy(xpath="//option[@value='19519']")
	WebElement major;
	
	@FindBy(xpath="//option[@value='2']")
	WebElement deliverymethod;
	
	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_ctlCourseSearch_pnlSearchFilter_defCourseActive_chkFilterCourseActive_2']")
	WebElement status;
	
	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_ctlCourseSearch_pnlSearchFilter_defCourseTuition_chkFilterCourseTuition_2']")
	WebElement tuition;
	
	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_ctlCourseSearch_pnlSearchFilter_defCourseSubscription_chkFilterCourseSusbscription_2']")
	WebElement subscription;
	
	@FindBy(xpath="//input[@value='Apply Filter']")
	WebElement applyfilter;*/
	
	
	public SearchUsersPage() {
		PageFactory.initElements(driver, this);
			}
	
	public SearchUsersPage clickOnUser() throws InterruptedException {
		
			//Users
			driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/span[2]/div[33]/a[1]")).click();
			Thread.sleep(3000);
			//Search User
			driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/span[2]/div[34]/div[1]/a[1]")).click();
			Thread.sleep(3000);
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,2500)");
			System.out.println("scrolled Down");
			Thread.sleep(3000);
			
			
		//Apply filters
		driver.findElement(By.xpath("//input[@value='Apply Filter']")).click();
		Thread.sleep(3000);
					
		
		//Edit User Account
		driver.findElement(By.xpath("//a[@id='ctlTemplate_regMainBody_ctlSearchResults_grdDataGrid_ctl03_lnkUserProfile']")).click();
		Thread.sleep(3000);
		
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,2500)");
		System.out.println("scrolled Down");
		Thread.sleep(3000);
		
		js1.executeScript("window.scrollBy(2500,-2500)");
		System.out.println("scrolled up");
		Thread.sleep(3000);
		
		//General info
		driver.findElement(By.xpath("//a[contains(text(),'General Info')]")).click();
		Thread.sleep(2000);
		
		//Additional info 
		driver.findElement(By.xpath("//span[@class='subheader']")).click();
		Thread.sleep(2000);
		
		//Save 
		driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_btnSubmit']")).click();
		Thread.sleep(2000);
		
		
		
		return searchuserPage;
											
			
			
			
	}	

			
	

}
