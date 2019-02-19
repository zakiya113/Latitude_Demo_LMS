package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class AddUsersPage extends TestBase {
	AddUsersPage addusersPage;
	//AddUsersPage administrationPage;

	

	@FindBy(xpath="//input[@name='ctlTemplate$regMainBody$fsGeneralInfo$ctlUserGeneralInfo$txtUserName']")
	WebElement username;

	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_fsGeneralInfo_ctlUserGeneralInfo_txtFirstName']")
	WebElement firstname;

	@FindBy(xpath="//input[@name='ctlTemplate$regMainBody$fsGeneralInfo$ctlUserGeneralInfo$txtLastName']")
	WebElement lastname;

	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_fsGeneralInfo_ctlUserGeneralInfo_txtEmail']")
	WebElement email;
	
	@FindBy(xpath="//select[@id='ctlTemplate_regMainBody_fsGeneralInfo_ctlUserGeneralInfo_lstLanguage']")
	WebElement language;

	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_fsGeneralInfo_ctlUserPassword_txtPassword']")
	WebElement password;

	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_fsGeneralInfo_ctlUserPassword_txtPasswordConfirm']")
	WebElement confirmpassword;

	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_fsGeneralInfo_chkNotifyUser']")
	WebElement notifyuser;

	@FindBy(xpath="//span[@class='subheader']")
	WebElement additionalinfo;
	
	/*@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_pnlUserAdditionalInfo_ctlUserAdditionalInfo_txtEffectiveDate']")
	WebElement effectivedate;
	
	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_pnlUserAdditionalInfo_ctlUserAdditionalInfo_txtEndDate']")
	WebElement enddate;*/
	
	@FindBy(xpath="//input[@name='ctlTemplate$regMainBody$pnlUserAdditionalInfo$ctlUserContactInfo$txtMobile']")
	WebElement mobile;
	
	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_pnlUserAdditionalInfo_ctlUserAddress_ctlAddress_txtStreet1']")
	WebElement street;
	
	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_pnlUserAdditionalInfo_ctlUserAddress_ctlAddress_txtCity']")
	WebElement city;
	
	@FindBy(xpath="//select[@id='ctlTemplate_regMainBody_pnlUserAdditionalInfo_ctlUserAddress_ctlAddress_lstCountry']")
	WebElement country;
	
	@FindBy(xpath="//select[@id='ctlTemplate_regMainBody_pnlUserAdditionalInfo_ctlUserAddress_ctlAddress_lstState']")
	WebElement state;
	
	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_pnlUserAdditionalInfo_ctlUserAddress_ctlAddress_txtPostalCode']")
	WebElement zip;
	
	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_btnSubmit']")
	WebElement adduser ;


	public AddUsersPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddUser(String uname , String fname, String lname, String uemail,String pwd,String cpwd,String mob,String ustreet,String ucity,String ucountry, String ustate, String uzip ) throws InterruptedException {

		//Users
		driver.findElement(By.xpath("//a[@id='ctlTemplate_regLeftNav_ctlMenuUser_mnuUser_MenuSection18_SectionHeader']")).click();
		Thread.sleep(3000);
		//Add User
		driver.findElement(By.xpath("//a[@id='ctlTemplate_regLeftNav_ctlMenuUser_mnuUser_MenuSection18_SectionItemsRepeater_ctl01_SectionItem']")).click();
		Thread.sleep(3000);

		
		username.sendKeys(uname);
		Thread.sleep(3000);
		firstname.sendKeys(fname);
		Thread.sleep(3000);
		lastname.sendKeys(lname);
		Thread.sleep(3000);
		email.sendKeys(uemail);
		Thread.sleep(3000);
		
		language.click();
		Thread.sleep(3000);
		
		//Organizations
				driver.findElement(By.xpath("//a[@id='ctlTemplate_regMainBody_fsGeneralInfo_ctlProfileEdit_ctlOrganizationPicker_lnkPicker']")).click();
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

						//search
						driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_OrgSearchPanel_btnSearch']")).click();
						Thread.sleep(5000);

						//Select
						driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_ctlOrgList_grdOrgList_ctl03_lnkAdd']")).click();
						Thread.sleep(5000);

						driver.switchTo().window(parent);


						//Position
						driver.findElement(By.xpath("//a[contains(text(),'Select a Position')]")).click();
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
								driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_ctlPositionList_ctlSearchList_ctlSearchPanel_btnSearch']")).click();
								Thread.sleep(3000);

								//Add Resource
								driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_ctlPositionList_ctlSearchList_ctlSearchList_Results_ctl01_lnkAdd']")).click();
								Thread.sleep(5000);

								driver.switchTo().window(parent1);

								//Password
								driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_fsGeneralInfo_ctlUserPassword_txtPassword']")).sendKeys("Minds123");
								Thread.sleep(5000);

								//confirm password
								driver.findElement(By.xpath("//input[@name='ctlTemplate$regMainBody$fsGeneralInfo$ctlUserPassword$txtPasswordConfirm']")).sendKeys("Minds123");
								Thread.sleep(5000);

								JavascriptExecutor js=(JavascriptExecutor)driver;
								js.executeScript("window.scrollBy(200,500)");
								System.out.println("scrolled Down");
								Thread.sleep(3000);
								
								
								/*//Notify User
								driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_fsGeneralInfo_chkNotifyUser']")).click();
								Thread.sleep(3000);
							
								//Additional info
								driver.findElement(By.xpath("//span[@class='subheader']")).click();
								Thread.sleep(3000);*/
								
								
								notifyuser.click();
								Thread.sleep(3000);
		
								additionalinfo.click();
								Thread.sleep(3000);
								
								/*JavascriptExecutor js1=(JavascriptExecutor)driver;
								js1.executeScript("window.scrollBy(200,500)");
								System.out.println("scrolled Down");
								Thread.sleep(3000);*/
								
								
							
								/*effectivedate.sendKeys(effdate);
								Thread.sleep(5000);*/
								/*enddate.sendKeys(endDate);
								Thread.sleep(3000);		*/
											
								mobile.sendKeys(mob);
								Thread.sleep(3000);		
								street.sendKeys(ustreet);
								Thread.sleep(3000);			
								city.sendKeys(ucity);
								Thread.sleep(3000);	
								country.sendKeys(ucountry);
								Thread.sleep(3000);	
								state.sendKeys(ustate);
								Thread.sleep(3000);	
								zip.sendKeys(uzip);
								Thread.sleep(3000);	
								
								
								
								
								adduser.click();
								Thread.sleep(3000);
								
								
								
								
		
								/*//Add User
								driver.findElement(By.xpath("//input[@value='Add User']")).click();
								Thread.sleep(3000);
								*/
								
								
							/*	password.sendKeys(pwd);
								Thread.sleep(3000);
								confirmpassword.sendKeys(cpwd);
								Thread.sleep(3000);*/
							/*	
								notifyuser.click();
								Thread.sleep(3000);
		
								additionalinfo.click();
								Thread.sleep(3000);
		
		
								adduser.click();
								Thread.sleep(3000);*/
		
					}
				}
			}
		}
		return;

	}	




}
