package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//a[@title='Administration']")
	WebElement administrator;
	
	@FindBy(xpath="/html[1]/body[1]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/span[2]/div[10]/div[1]/a[1]")
	WebElement searchcourse;
	
	//Initializing the Page Objects
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
	
		public HomePage clickOnAdministratorLink() throws InterruptedException {
			Thread.sleep(3000);
			administrator.click();
		return new HomePage();
		}
		
	public SearchCoursePage clickOnAddCourse() throws InterruptedException {
		Thread.sleep(3000);
		searchcourse.click();
	return new SearchCoursePage();
	}
	
	
	
}
