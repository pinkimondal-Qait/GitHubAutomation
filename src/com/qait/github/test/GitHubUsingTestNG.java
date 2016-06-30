package com.qait.github.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import com.qait.github.pageobjects.BaseClass;
import com.qait.github.readFromDotGitFile.ReadFromLogFile;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GitHubUsingTestNG {
	 String url="https://github.com/login";
	 WebDriver driver;
	 BaseClass base;
  
  @BeforeClass
  public void beforeClass(){
	   	driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(url);
		base=new BaseClass(driver);	
}
  
  @Test(priority=0)
  public void onSignInPage(){
	  String expectedTitle="Sign in to GitHub";
	  String actualTitle= base.getTitleFromSignIn();
	  Assert.assertEquals(expectedTitle, actualTitle,"Sign In Page Title Do not Match");
  }
 
  @Test(priority=1)
  public void successSignIn(){
	  String expectedUrl="https://github.com/";  
	  String homePageTitle=base.signInMethod(); 
	  Assert.assertEquals(expectedUrl, homePageTitle,"Login Failed");
      
  }
  
  @Test(priority=2)
  public void clickOnNewRepository(){
	  String expectedUrl="https://github.com/new";  
	  String homePageTitle=base.homePageMethod(); 
	  Assert.assertEquals(expectedUrl, homePageTitle,"Failed to move on new repository creation page");
      
  }
 
  @Test(priority=3)
  public void createNewRepository(){
	  String expectedUrl="https://github.com/pinkimondal-Qait/NewRepository";  
	 // String expectedUrlAfterDelete="https://github.com/";
	  String homePageTitle=base.createNewRepo(); 
	 //  String actualUrlAfterDelete=homePageTitlePlusDeleteTilte[1].trim();
	 // String homePageTitle=homePageTitlePlusDeleteTilte[0].trim();
	// Assert.assertEquals(actualUrlAfterDelete, expectedUrlAfterDelete,"Failed to delete Existing Repository");
	  Assert.assertEquals(expectedUrl, homePageTitle,"Failed to create new repository");
  }

  @Test(priority=4)
  public void cloneLinkCheck(){
	  String expectedUrl="https://github.com/pinkimondal-Qait/NewRepository.git";  
	  String cloneLinkTitle=base.cloneLinkFromUi(); 
	  Assert.assertEquals(expectedUrl, cloneLinkTitle,"Failed to copy new repository clone Link");
  }
  
  
  @Test(priority=5)
  public void validateCommit(){
	  boolean commitStatus=base.checkCommitMsg(); 
	  Assert.assertTrue(commitStatus,"Failed to Commit");
  }
 
  @Test(dependsOnMethods={"validateCommit"})
  public void validateCommitId(){
	  String expectedCommitId=base.fetchCommitIdFromUi(); 
	  ReadFromLogFile r=new ReadFromLogFile();
	  String actualCommitId=r.read();
	  Assert.assertEquals(expectedCommitId, actualCommitId,"Latest Commit is not done");
  }
}
