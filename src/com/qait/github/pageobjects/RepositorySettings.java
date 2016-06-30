package com.qait.github.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.github.data.RepositoryRelatedData;

public class RepositorySettings extends BaseClass{
  WebDriver driver;
  
  public RepositorySettings(WebDriver driver) {
	super(driver);
	this.driver = driver;
}
	
  @FindBy(className="js-selected-navigation-item")
	private List<WebElement> deleteRepolinks;
	
	@FindBy(className="boxed-action")
	private List<WebElement> dangerButtonsOnSettingsPage;
	
	@FindBy(name="verify")
	private List<WebElement> deleteRepoTextBox;
	
	@FindBy(className="btn-danger")
	private List<WebElement> deleteIUnderStandButtons;
  
	
	
	public String deleteRepository() {
		 deleteRepolinks.get(8).click(); //this will click on the settings button of existing repository
		 driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		 dangerButtonsOnSettingsPage.get(2).click();
		 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		 RepositoryRelatedData repoInfo=new RepositoryRelatedData();
		 deleteRepoTextBox.get(2).sendKeys(repoInfo.getNewRepositoryName());
		 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		 deleteIUnderStandButtons.get(6).click();
		 driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		 return driver.getCurrentUrl();
	}

}
