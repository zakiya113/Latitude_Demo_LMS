package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class AdministrationPage extends TestBase {
	AdministrationPage addcoursePage;
	AdministrationPage administrationPage;
	
	/*@FindBy(xpath="//a[contains(text(),'Choose Organizations')]")
	WebElement Organizations ;*/
	
	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_ctlCourseGeneralInfoEdit_ctl01_txtCode']")
	WebElement code;
	
	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_ctlCourseGeneralInfoEdit_ctl01_ttName']")
	WebElement name;
	
	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_ctlCourseGeneralInfoEdit_ctl01_ctlCostsList_ctl00_txtAmount']")
	WebElement tuition;
	
	@FindBy(xpath="//textarea[@id='ctlTemplate_regMainBody_ctlCourseGeneralInfoEdit_ctl01_ttDescription']")
	WebElement description;
	
	@FindBy(xpath="//textarea[@id='ctlTemplate_regMainBody_ctlCourseGeneralInfoEdit_ctl01_ttAudience']")
	WebElement targetedlearners;
	
	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_ctlCourseGeneralInfoEdit_ctl01_txtDuration']")
	WebElement duration;
	
	@FindBy(xpath="//select[@id='ctlTemplate_regMainBody_ctlCourseGeneralInfoEdit_ctl01_lstCourseMajor']")
	WebElement major;
	
	@FindBy(xpath="//select[@id='ctlTemplate_regMainBody_ctlCourseGeneralInfoEdit_ctl01_lstDeliveryMethod']")
	WebElement deliverymethod;
	
	
	
	
	public AdministrationPage() {
		PageFactory.initElements(driver, this);
			}
	
	public void clickOnAddCourse(String ccode , String cname, String Tuition, String desc, String trgtdlrnrs, String cduration, String cmajor, String delmthd) throws InterruptedException {
		
			//Course
			driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/span[2]/div[9]/a[1]")).click();
			Thread.sleep(3000);
			//Add Course
			driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/span[2]/div[10]/div[2]/a[1]")).click();
			Thread.sleep(3000);
			
			//Organizations
			driver.findElement(By.xpath("//a[contains(text(),'Choose Organizations')]")).click();
			Thread.sleep(5000);
			
			String parent=driver.getWindowHandle();
			// This will return the number of windows opened by Webdriver and will return Set of Strings
			Set<String>s1=driver.getWindowHandles();
			// Now we will iterate using Iterator
			Iterator<String>I1=s1.iterator();
			while(I1.hasNext())
			{
			 String child_window=I1.next();
			// Here we will compare if parent window is not equal to child window then we will close
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			System.out.println(driver.switchTo().window(child_window).getTitle());


					driver.findElement(By.xpath("//input[@value='Search']")).click();
					Thread.sleep(5000);
					
			
					driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_ctlSearchList_ctlSearchList_ctlSearchList_Results_ctl01_lnkAdd']")).click();
					Thread.sleep(5000);
					
					driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_ctlBasket_cmdCheckout']")).click();
							Thread.sleep(3000);
							
							driver.switchTo().window(parent);
							
						
							code.sendKeys(ccode);
							Thread.sleep(1000);
							name.sendKeys(cname);
							Thread.sleep(1000);
							tuition.sendKeys(Tuition);
							Thread.sleep(1000);
							description.sendKeys(desc);
							Thread.sleep(1000);
							targetedlearners.sendKeys(trgtdlrnrs);
							Thread.sleep(1000);
							duration.sendKeys(cduration);
							Thread.sleep(1000);
							major.sendKeys(cmajor);
							Thread.sleep(1000);
							deliverymethod.sendKeys(delmthd);
							Thread.sleep(1000);
							
							//Approval req
							driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_ctlCourseGeneralInfoEdit_ctl01_lstApprovalRequired_0']")).click();
							Thread.sleep(3000);
							//can relaunch
							driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_ctlCourseGeneralInfoEdit_ctl01_lstCanRelaunch_0']")).click();
							Thread.sleep(3000);
							//course completion certificate
							driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_ctlCourseGeneralInfoEdit_ctl01_lstCourseCompletionCertificate_1']")).click();
							Thread.sleep(5000);
							
							
							//Resources
							driver.findElement(By.xpath("//a[@id='ctlTemplate_regMainBody_ctlCourseGeneralInfoEdit_ctl01_ctlResourcePicker_lnkPicker']")).click();
							Thread.sleep(3000);
							
							String parent1=driver.getWindowHandle();
							// This will return the number of windows opened by Webdriver and will return Set of Strings
							Set<String>s2=driver.getWindowHandles();
							// Now we will iterate using Iterator
							Iterator<String>I2=s2.iterator();
							while(I2.hasNext())
							{
							 String child_window1=I2.next();
							// Here we will compare if parent window is not equal to child window then we will close
							if(!parent1.equals(child_window1))
							{
							driver.switchTo().window(child_window1);
							System.out.println(driver.switchTo().window(child_window1).getTitle());

									//Search
									driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_ctlResourceList_ctlSearchList_ctlSearchPanel_btnSearch']")).click();
									Thread.sleep(3000);
									
									//Add Resource
									driver.findElement(By.xpath("//input[@value='Add']")).click();
									Thread.sleep(3000);
									
									//check out
									driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_ctlBasket_cmdCheckout']")).click();
											Thread.sleep(3000);
											
											driver.switchTo().window(parent1);
											
											
										
											
											driver.findElement(By.xpath("//span[@class='subheader']")).click();
											Thread.sleep(3000);
											
											//Language
											driver.findElement(By.xpath("//select[@name='ctlTemplate$regMainBody$pnlCourseAdditionalInfo$ctlCourseAdditionalInfoEdit$ctlTemplate_regMainBody_pnlCourseAdditionalInfo_ctlCourseAdditionalInfoEdit_ctlPageLanguage_LanguageDropDown']")).click();
											//driver.findElement(By.xpath("//select[@name='ctlTemplate$regMainBody$pnlCourseAdditionalInfo$ctlCourseAdditionalInfoEdit$ctlTemplate_regMainBody_pnlCourseAdditionalInfo_ctlCourseAdditionalInfoEdit_ctlPageLanguage_LanguageDropDown']/option[0]")).click();
											Thread.sleep(3000);
											
											JavascriptExecutor js1=(JavascriptExecutor)driver;
											js1.executeScript("window.scrollBy(200,500)");
											System.out.println("scrolled Down");
											Thread.sleep(3000);
											
											//Notes
											driver.findElement(By.xpath("//textarea[@id='ctlTemplate_regMainBody_pnlCourseAdditionalInfo_ctlCourseAdditionalInfoEdit_ttNotes']")).sendKeys("Course notes");
											Thread.sleep(3000);
											
											//Course display date
											driver.findElement(By.xpath("//fieldset[@id='additionalInfoFields']//dl[3]//dd[1]//img[1]")).click();
											Thread.sleep(1000);
											driver.findElement(By.xpath("//div[contains(text(),'21')]")).click();
											Thread.sleep(1000);
											
											//Enrollment open date
											driver.findElement(By.xpath("//dl[@id='ctlTemplate_regMainBody_pnlCourseAdditionalInfo_ctlCourseAdditionalInfoEdit_dlOpenDateContainer']//img[@class='calButton']")).click();
											Thread.sleep(1000);
											driver.findElement(By.xpath("//div[contains(text(),'21')]")).click();
											Thread.sleep(1000);
											
											//Enrollment close date
											driver.findElement(By.xpath("//dl[@id='ctlTemplate_regMainBody_pnlCourseAdditionalInfo_ctlCourseAdditionalInfoEdit_dlCloseDateContainer']//img[@class='calButton']")).click();
											Thread.sleep(1000);
											driver.findElement(By.xpath("//div[@class='next']")).click();
											Thread.sleep(1000);
											driver.findElement(By.xpath("//div[@class='day day0'][contains(text(),'31')]")).click();
											Thread.sleep(1000);
											
											//Course hide date
											driver.findElement(By.xpath("//fieldset[@id='additionalInfoFields']//dl[6]//dd[1]//img[1]")).click();
											Thread.sleep(1000);
											driver.findElement(By.xpath("//div[@class='next']")).click();
											Thread.sleep(1000);
											driver.findElement(By.xpath("//div[@class='day day0'][contains(text(),'31')]")).click();
											Thread.sleep(1000);
											
											//Certification calculation date
											driver.findElement(By.xpath("//dl[@id='ctlTemplate_regMainBody_pnlCourseAdditionalInfo_ctlCourseAdditionalInfoEdit_dlCalculationDateContainer']//img[@class='calButton']")).click();
											Thread.sleep(1000);
											driver.findElement(By.xpath("//div[@class='next']")).click();
											Thread.sleep(1000);
											driver.findElement(By.xpath("//div[@class='day day0'][contains(text(),'31')]")).click();
											Thread.sleep(1000);
			
											//days for student to complete(Due date)
											driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_pnlCourseAdditionalInfo_ctlCourseAdditionalInfoEdit_txtCoursePastDuedate']")).sendKeys("50");
											Thread.sleep(1000);
			
											//days before due date to remind student
											driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_pnlCourseAdditionalInfo_ctlCourseAdditionalInfoEdit_txtCourseDuedateReminder']")).sendKeys("7");
											Thread.sleep(1000);
											
											//Transcript expiration date
											driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_pnlCourseAdditionalInfo_ctlCourseAdditionalInfoEdit_txtTranscriptExpirationDays']")).sendKeys("30");
											Thread.sleep(1000);
											
											//days before transcript expiration to remind student
											driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_pnlCourseAdditionalInfo_ctlCourseAdditionalInfoEdit_txtTranscriptExpirationReminder']")).sendKeys("2");
											Thread.sleep(1000);
											
											
											//enrollment restriction
											driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_pnlCourseAdditionalInfo_ctlCourseAdditionalInfoEdit_lstRetakeRestrictionType_1']")).click();
											Thread.sleep(1000);
											
											//Accumulate Credit
											driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_pnlCourseAdditionalInfo_ctlCourseAdditionalInfoEdit_lstAccumulateCredit_0']")).click();
											Thread.sleep(1000);
											
											
											//credit
											driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_pnlCourseAdditionalInfo_ctlCourseAdditionalInfoEdit_txtCredit']")).sendKeys("10");;
											Thread.sleep(1000);
											
											/*//subscription
											driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/div[1]/div[2]/span[1]/div[2]/fieldset[1]/dl[17]/dd[1]/select[1]")).click();
											driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/div[1]/div[2]/span[1]/div[2]/fieldset[1]/dl[17]/dd[1]/select[1]/option[1]")).click();
											Thread.sleep(1000);*/
											
											//Instructional languages
											driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_pnlCourseAdditionalInfo_ctlCourseAdditionalInfoEdit_lstAccumulateCredit_1']")).click();
											Thread.sleep(1000);
													
											//version
											driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_pnlCourseAdditionalInfo_ctlCourseAdditionalInfoEdit_txtVersionNumber']")).sendKeys("1");;
											Thread.sleep(1000);
											
											//allow use of interest list
											driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_pnlCourseAdditionalInfo_ctlCourseAdditionalInfoEdit_lstInterestType_0']")).click();
											Thread.sleep(1000);
											
											
											//Add Course
											driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_btnSubmit']")).click();
											Thread.sleep(2000);
			
			
			
	}
							}
			}
		}
			return;
			
	}	

			
	

}
