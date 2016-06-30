package com.qait.github.pageobjects;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qait.github.data.RepositoryRelatedData;

public class CloneLinkPageObject extends BaseClass{
	WebDriver driver;
	
	public CloneLinkPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(className = "btn")
	private List<WebElement> buttonsOnRepository;
	
	@FindBy(className="js-zeroclipboard")
	private List<WebElement> clipBoardButtons;
	
	@FindBy(className="form-control")
	private List<WebElement> clipBoardText;
	
	public String setCloneLink(){
		RepositoryRelatedData repoInfo=new RepositoryRelatedData();
		buttonsOnRepository.get(5).click(); // click on clone button 
        clipBoardButtons.get(0).click();   //copy url to clone git repository 
        String cloneLink=clipBoardText.get(5).getAttribute("value"); // get the url of repository
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Clone Link"+cloneLink);
        File repo=new File("/home/pinkimondal/Desktop/"+repoInfo.getNewRepositoryName()); //link to create local repository
        if(repo.isDirectory()){
        	if(repo.exists()){
        		//	repo.delete();
        	}
        	else{
        		new File("/home/pinkimondal/Desktop/"+repoInfo.getNewRepositoryName()).mkdir();  //this will make new repository at local machine
        	}
           }
   return cloneLink;
	}
	
}
