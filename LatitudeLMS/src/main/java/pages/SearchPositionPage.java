package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class SearchPositionPage extends TestBase {
	SearchPositionPage searchpositionPage;
	
	
	@FindBy(xpath="//input[@name='ctlTemplate$regMainBody$ctlPositionList$ctlSearchList$ctlSearchPanel$ctlFilter$txtName']")
	WebElement searchname;

	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_ctlPositionList_ctlSearchList_ctlSearchPanel_ctlFilter_txtCode']")
	WebElement searchcode;
	
	@FindBy(xpath="//input[@name='ctlTemplate$regMainBody$ctlPosGeneralInfo$txtName']")
	WebElement editname;
	
	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_btnSubmit']")
	WebElement submit;
	
	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_ctlPositionList_ctlSearchList_ctlSearchPanel_btnSearch']")
	WebElement search;
	
	public SearchPositionPage() {
		PageFactory.initElements(driver, this);
			}
	
	public SearchPositionPage clickOnSearchPosition(String sname , String scode, String edname) throws InterruptedException {
		
			//Organizations
			driver.findElement(By.xpath("//a[@id='ctlTemplate_regLeftNav_ctlMenuUser_mnuUser_MenuSection13_SectionHeader']")).click();
			Thread.sleep(3000);
			
			//Scroll down
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,2500)");
			System.out.println("scrolled Down");
			Thread.sleep(3000);
			
			//Search Position
			driver.findElement(By.xpath("//a[@id='ctlTemplate_regLeftNav_ctlMenuUser_mnuUser_MenuSection13_SectionItemsRepeater_ctl04_SectionItem']")).click();
			Thread.sleep(3000);
			
			searchname.sendKeys(sname);
			Thread.sleep(3000);
			searchcode.sendKeys(scode);
			Thread.sleep(3000);
			
			//Status
			driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_ctlPositionList_ctlSearchList_ctlSearchPanel_ctlFilter_radStatus_2']")).click();
			Thread.sleep(3000);


			//Search
			//driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_ctlPositionList_ctlSearchList_ctlSearchPanel_btnSearch']")).click();
			search.click();
			Thread.sleep(3000);


			//Select a Position
			driver.findElement(By.xpath("//a[contains(text(),'CI07')]")).click();
			Thread.sleep(3000);


			//Scroll down and scroll up
			JavascriptExecutor js2=(JavascriptExecutor)driver;
			js2.executeScript("window.scrollBy(0,2500)");
			System.out.println("scrolled Down");
			Thread.sleep(3000);

			js2.executeScript("window.scrollBy(2500,-2500)");
			System.out.println("scrolled up");
			Thread.sleep(3000);

			//Edit
			driver.findElement(By.xpath("//a[@id='ctlTemplate_regMainBody_ctlTabs_lnkGeneralInfo']")).click();	
			Thread.sleep(3000);


			//Edit name
			
			//driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_btnSubmit']")).sendKeys("Course Instructor");	
			editname.clear();
			Thread.sleep(1000);
			editname.sendKeys(edname);
			Thread.sleep(1000);

			//Submit edited
			driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_btnSubmit']")).click();	
			Thread.sleep(3000);

			//Scroll down and scroll up
			JavascriptExecutor js11=(JavascriptExecutor)driver;
			js11.executeScript("window.scrollBy(0,2500)");
			System.out.println("scrolled Down");
			Thread.sleep(3000);

			js11.executeScript("window.scrollBy(2500,-2500)");
			System.out.println("scrolled up");
			Thread.sleep(3000);


			//Relationships 
			driver.findElement(By.xpath("//a[contains(text(),'Relationships')]")).click();
			Thread.sleep(3000);
			
			//Submit 
			driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_btnSubmit']")).click();	
			Thread.sleep(3000);

			
			
			
		return searchpositionPage;
											
			
			
			
	}	

			
	

}
