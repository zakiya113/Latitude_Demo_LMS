package pages;



import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class MajorPage extends TestBase {
	MajorPage majorPage;
	
	
	
	
	@FindBy(xpath="//input[@name='ctlTemplate$regMainBody$ctlCategoryEdit$txtCode']")
	WebElement code;
	
	@FindBy(xpath="//input[@name='ctlTemplate$regMainBody$ctlCategoryEdit$txtCode']")
	WebElement language;
	
	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_ctlCategoryEdit_txtName']")
	WebElement name;
	
	@FindBy(xpath="//textarea[@name='ctlTemplate$regMainBody$ctlCategoryEdit$txtDescription']")
	WebElement description;
	
	/*@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_ctlCategoryEdit_txtOrdinal']")
	WebElement ordinal;*/
	
	@FindBy(xpath="//input[@id='ctlTemplate_regMainBody_ctlCategoryEdit_lstActive_0']")
	WebElement status;
	
	
	
	public MajorPage() {
		PageFactory.initElements(driver, this);
			}
	
	public MajorPage clickOnAddMajor(String mjcode, String mjname, String desc) throws InterruptedException {
		
			//Course Support
			driver.findElement(By.xpath("//a[@id='ctlTemplate_regLeftNav_ctlMenuUser_mnuUser_MenuSection6_SectionHeader']")).click();
			Thread.sleep(3000);
			//Add Major
			driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/span[2]/div[12]/div[2]/a[1]")).click();
			Thread.sleep(3000);
			
			//Organizations
			driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/fieldset[1]/dl[1]/dd[1]/a[1]")).click();
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
					driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_ctlSearchList_ctlSearchList_ctlSearchPanel_btnSearch']")).click();
					Thread.sleep(5000);
					
					//Add
					driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_ctlSearchList_ctlSearchList_ctlSearchList_Results_ctl01_lnkAdd']")).click();
					Thread.sleep(5000);
					
					//Check out
					driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_ctlBasket_cmdCheckout']")).click();
							Thread.sleep(3000);
							
							driver.switchTo().window(parent);
							
			
							code.sendKeys(mjcode);
							Thread.sleep(1000);
							language.click();
							Thread.sleep(1000);
							name.sendKeys(mjname);
							Thread.sleep(1000);
							description.sendKeys(desc);
							Thread.sleep(1000);
							
							status.click();
							Thread.sleep(1000);
							
						
		
		
	//Submit to add
		driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_ctlCategoryEdit_btnSubmit']")).click();
		Thread.sleep(3000);
		
		//Submit to edit
		driver.findElement(By.xpath("//input[@value='Submit']")).click();	
		Thread.sleep(3000);
		
		
		//Return To Search
		driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_btnBack']")).click();	
		Thread.sleep(3000);

		//Search
		driver.findElement(By.xpath("//input[@value='Search']")).click();	
		Thread.sleep(3000);
		
		//Select Major 
		driver.findElement(By.xpath("//a[contains(text(),'System Design')]")).click();
		Thread.sleep(3000);
		
		//Ordinal
		driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_ctlCategoryEdit_txtOrdinal']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='ctlTemplate_regMainBody_ctlCategoryEdit_txtOrdinal']")).sendKeys("1");
		Thread.sleep(3000);
		
		
		//Submit after editing
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(3000);
		
		
			}
			}
		return majorPage;
											
			
			
			
	}	

			
	

}
