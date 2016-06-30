package com.qait.github.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GitHomePage extends BaseClass {
	WebDriver driver;
	
	public GitHomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
     }
	
	@FindBy(className = "header-nav-link")
	private List<WebElement> li;

	@FindBy(className = "dropdown-item")
	private List<WebElement> dropdown;
	
	public String mainHomePageCreateRepo(){
	        li.get(3).click();  //click on drop down to create new repository
	        dropdown.get(0).click(); //click on new repository section 
	        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
       return driver.getCurrentUrl();
	    }
	 

}
