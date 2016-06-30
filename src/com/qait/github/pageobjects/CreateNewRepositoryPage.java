package com.qait.github.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.github.data.RepositoryRelatedData;

public class CreateNewRepositoryPage extends BaseClass {
    WebDriver driver;
   	String url;
	
	public CreateNewRepositoryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(className = "header-nav-link")
	private List<WebElement> li;

	@FindBy(className = "dropdown-item")
	private List<WebElement> dropdown;
	
	@FindBy(id = "repository_name")
	private WebElement repositoryNew;
	
	@FindBy(className="is-autocheck-errored")
	private List<WebElement> repositoryAlreadyExists;
	
	@FindBy(className="error")
	private WebElement errorRepoAlreadyExits;
	
	@FindBy(id = "repository_description")
	private WebElement repositoryDesc;
	
	@FindBy(id = "repository_auto_init")
	private WebElement readMeCheckBox;
	
	@FindBy(className = "btn")
	private List<WebElement> buttonsOnCreateRepoPage;
   
	public String createNewRepository(){
		String homePageAfterDeletionUrl = null;
		RepositoryRelatedData repoInfo=new RepositoryRelatedData(); 
		repositoryNew.sendKeys(repoInfo.getNewRepositoryName());   //send new repository name to textbox
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   
	    if(repositoryAlreadyExists.get(0).isDisplayed()){
	    	if(errorRepoAlreadyExits.getText() != null){
	    		 DeleteRepository del=new DeleteRepository(driver);
	    		 homePageAfterDeletionUrl= del.deleteRepo();
	    		 li.get(3).click();  //click on drop down to create new repository
			     dropdown.get(0).click(); //click on new repository section 
			     driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    	     System.out.println("homePageUrlAfterDeletion "+homePageAfterDeletionUrl);
	    	}
	      }
	    
        repositoryNew.sendKeys(repoInfo.getNewRepositoryName());   //send new repository name to textbox
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    repositoryDesc.sendKeys(repoInfo.getNewRepositoryDescription());  //fill description of repository
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    readMeCheckBox.click();   //click on check box to create Readme file
	    buttonsOnCreateRepoPage.get(3).click();   //click on create repository button
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		return driver.getCurrentUrl();
	       
	}
	

	
}
