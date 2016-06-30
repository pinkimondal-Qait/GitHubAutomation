package com.qait.github.pageobjects;

import org.openqa.selenium.WebDriver;
import com.qait.github.data.RepositoryRelatedData;

public class DeleteRepository extends BaseClass {
      WebDriver driver;
	public DeleteRepository(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	public String deleteRepo(){
	   RepositoryRelatedData repoInfo=new RepositoryRelatedData();
	   driver.navigate().to("https://github.com/pinkimondal-Qait/"+repoInfo.getNewRepositoryName());
	   RepositorySettings settingsPage= new RepositorySettings(driver);
	   String homePageAfterDeletion=settingsPage.deleteRepository();
	   return homePageAfterDeletion;
	}
	
}
