package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class SearchCoursePage extends TestBase {
	SearchCoursePage searchcoursePage;
	
	
	
	
	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_txtFilterCourseName']")
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
	WebElement applyfilter;
	
	
	public SearchCoursePage() {
		PageFactory.initElements(driver, this);
			}
	
	public SearchCoursePage clickOnSearchCourse(String key , String ccode, String cat, String mjr, String delmthd) throws InterruptedException {
		
			//Course
			driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/span[2]/div[9]/a[1]")).click();
			Thread.sleep(3000);
			//Search Course
			driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/span[2]/div[10]/div[1]/a[1]")).click();
			Thread.sleep(3000);
			
			
							keyword.sendKeys(key);
							Thread.sleep(1000);
							coursecode.sendKeys(ccode);
							Thread.sleep(1000);
							catalog.click();
							Thread.sleep(1000);
							major.click();
							Thread.sleep(1000);
							deliverymethod.click();
							Thread.sleep(1000);
							status.click();
							Thread.sleep(1000);
							tuition.click();
							Thread.sleep(1000);
							subscription.click();
							Thread.sleep(1000);
							
							applyfilter.click();
							Thread.sleep(5000);
							
											
		//Click On Course
		driver.findElement(By.xpath("//a[contains(text(),'CSE')]")).click();
		Thread.sleep(3000);
											
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2500)");
		System.out.println("scrolled Down");
		Thread.sleep(3000);
		
		js.executeScript("window.scrollBy(2500,-2500)");
		System.out.println("scrolled up");
		Thread.sleep(3000);
		
		//Edit Course
		driver.findElement(By.xpath("//a[@id='ctlTemplate_regMainBody_ctlCourseTabs_lnkGeneralInfo']")).click();
		Thread.sleep(2000);
		
		//Description
		driver.findElement(By.xpath("//textarea[@name='ctlTemplate$regMainBody$ctlCourseGeneralInfoEdit$ctl01$ttDescription']")).clear();
		driver.findElement(By.xpath("//textarea[@name='ctlTemplate$regMainBody$ctlCourseGeneralInfoEdit$ctl01$ttDescription']")).sendKeys("Computer Science and Programming");
		Thread.sleep(2000);
		
		
		//Targeted learners
		driver.findElement(By.xpath("//textarea[@name='ctlTemplate$regMainBody$ctlCourseGeneralInfoEdit$ctl01$ttAudience']")).clear();
		driver.findElement(By.xpath("//textarea[@name='ctlTemplate$regMainBody$ctlCourseGeneralInfoEdit$ctl01$ttAudience']")).sendKeys("IT People");
		Thread.sleep(2000);
		
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,2500)");
		System.out.println("scrolled Down");
		Thread.sleep(3000);
		
		
		//Save Course
		driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_btnSubmit']")).click();
		Thread.sleep(3000);
		
		return searchcoursePage;
											
			
			
			
	}	

			
	

}
