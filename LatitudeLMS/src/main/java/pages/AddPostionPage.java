package pages;



import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class AddPostionPage extends TestBase {
	AddPostionPage positionPage;



	@FindBy(xpath="//select[@id='ctlTemplate_regMainBody_ctlPosGeneralInfo_ctlTemplate_regMainBody_ctlPosGeneralInfo_ctlPageLanguage_LanguageDropDown']")
	WebElement language;

	@FindBy(xpath="//input[@name='ctlTemplate$regMainBody$ctlPosGeneralInfo$txtCode']")
	WebElement code;

	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_ctlPosGeneralInfo_txtName']")
	WebElement name;

	@FindBy(xpath="//input[@name='ctlTemplate$regMainBody$ctlPosGeneralInfo$txtName']")
	WebElement editname;



	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_btnSubmit']")
	WebElement submit;



	public AddPostionPage() {
		PageFactory.initElements(driver, this);
	}

	public AddPostionPage clickOnAddPosition(String pcode, String pname, String edname) throws InterruptedException {

		//Organizations
		driver.findElement(By.xpath("//a[@id='ctlTemplate_regLeftNav_ctlMenuUser_mnuUser_MenuSection13_SectionHeader']")).click();
		Thread.sleep(3000);
		//Add Position
		driver.findElement(By.xpath("//a[@id='ctlTemplate_regLeftNav_ctlMenuUser_mnuUser_MenuSection13_SectionItemsRepeater_ctl05_SectionItem']")).click();
		Thread.sleep(3000);



		language.click();
		Thread.sleep(3000);
		code.sendKeys(pcode);
		Thread.sleep(1000);
		name.sendKeys(pname);
		Thread.sleep(1000);



		//Effective Date
		driver.findElement(By.xpath("//dd[@id='ctlTemplate_regMainBody_ctlPosGeneralInfo_Dd5']//img[@class='calButton']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'19')]")).click();
		Thread.sleep(1000);

		//End Date
		driver.findElement(By.xpath("//dd[@id='ctlTemplate_regMainBody_ctlPosGeneralInfo_Dd7']//img[@class='calButton']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='next']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='next']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='day day2'][contains(text(),'30')]")).click();
		Thread.sleep(1000);



		//Superior Positions
		driver.findElement(By.xpath("//a[@id='ctlTemplate_regMainBody_ctlPositionRelationships_ctlSuperiorPositionPicker_lnkPicker']")).click();
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

				//Search
				driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_ctlPositionList_ctlSearchList_ctlSearchPanel_btnSearch']")).click();
				Thread.sleep(5000);

				//Add
				driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_ctlPositionList_ctlSearchList_ctlSearchList_Results_ctl03_lnkAdd']")).click();
				Thread.sleep(5000);

				//Check out
				driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_ctlBasket_cmdCheckout']")).click();
				Thread.sleep(3000);

				driver.switchTo().window(parent);

				//Subordinate Positions
				driver.findElement(By.xpath("//a[@id='ctlTemplate_regMainBody_ctlPositionRelationships_ctlSubordinatePositionPicker_lnkPicker']")).click();
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

						//Add a Position
						driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_ctlPositionList_ctlSearchList_ctlSearchList_Results_ctl02_lnkAdd']")).click();
						Thread.sleep(3000);

						//check out
						driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_ctlBasket_cmdCheckout']")).click();
						Thread.sleep(3000);

						driver.switchTo().window(parent1);

						Thread.sleep(5000);
						
						//driver.findElement(By.xpath("//input[@value='Submit']")).click();	
						submit.click();
						Thread.sleep(3000);

						JavascriptExecutor js=(JavascriptExecutor)driver;
						js.executeScript("window.scrollBy(0,2500)");
						System.out.println("scrolled Down");
						Thread.sleep(3000);

						js.executeScript("window.scrollBy(2500,-2500)");
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

						//Scroll down 
						JavascriptExecutor js111=(JavascriptExecutor)driver;
						js111.executeScript("window.scrollBy(0,2500)");
						System.out.println("scrolled Down");
						Thread.sleep(3000);
						
						js111.executeScript("window.scrollBy(2500,-2500)");
						System.out.println("scrolled up");
						Thread.sleep(3000);
						
						
					}
				}
			}
			}
				return positionPage;


		}
	}
