package com.qait.github.pageobjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.hamcrest.core.Is;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qait.github.data.UserCredentials;
import com.qait.github.terminal.GithubTerminalCommands;

public class BaseClass {
    WebDriver driver;
    String url,cloneLinkUrl;    

    public BaseClass(WebDriver driver){
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
	  }
	
    public String getTitleFromSignIn(){
    	SignIn signIn= new SignIn(driver);
    	String s=signIn.getTitle();
    	return s;
    }
     
    public String signInMethod(){
    	SignIn signIn= new SignIn(driver);
    	UserCredentials userInfo=new UserCredentials();
    	String title=signIn.signIn(userInfo.getUsername(),userInfo.getPassword());
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		return title;
     }
  
   public String homePageMethod(){
	GitHomePage home=new GitHomePage(driver);
	String newRepoUrl=home.mainHomePageCreateRepo();
	return newRepoUrl;
	}	

   public String createNewRepo(){
	  CreateNewRepositoryPage repo=new CreateNewRepositoryPage(driver);
	  url=repo.createNewRepository();
      return url;    
    }
  
   public String cloneLinkFromUi(){
		  CloneLinkPageObject repo=new CloneLinkPageObject(driver);
		  this.cloneLinkUrl=repo.setCloneLink();
	      return cloneLinkUrl;    
	    }
     
   public boolean checkCommitMsg()
    {  boolean isCommit = false;
       GithubTerminalCommands commands=new GithubTerminalCommands(driver,cloneLinkUrl);
        try {
		  isCommit=commands.clonePushPullOperations();
		    } catch (IOException e) {
		         e.printStackTrace();
	        } catch (InterruptedException e) {
		         e.printStackTrace();
  	  }
      return isCommit;
   }
  
   public String fetchCommitIdFromUi(){
	     CommitIdPageObject c=new CommitIdPageObject(driver);
	     String commitIdUi=c.getCommitIdUi();
	     return commitIdUi; 
   }
   
  
}
