package com.qait.github.terminal;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qait.github.data.UserCredentials;
import com.qait.github.pageobjects.BaseClass;

public class GithubTerminalCommands extends BaseClass {
      String url;
      WebDriver driver;
      public GithubTerminalCommands(WebDriver driver, String url) {
    	  super(driver);
    	  this.driver=driver; 	  
    	  this.url=url;
    	 // System.out.println(url);
	}
	@FindBy(linkText="sample txt commit")
      private WebElement commit;
      
	public boolean clonePushPullOperations() throws IOException, InterruptedException {
		//System.out.println("Clone test1");
		UserCredentials userInfo=new UserCredentials();
		String[] mUrl=url.split("//");
		String modifiedUrl=mUrl[0]+"//"+userInfo.getUsername()+":"+userInfo.getPassword()+"@"+mUrl[1];
		//System.out.println(modifiedUrl);
		
		Runtime.getRuntime().exec("chmod +x /home/pinkimondal/Desktop/commands.sh");
		ProcessBuilder pb = new ProcessBuilder("/home/pinkimondal/Desktop/commands.sh");
		pb.environment().put("param1", modifiedUrl);
	    //	pb.environment().put("param2", userInfo.getUsername());
	    //	pb.environment().put("param3", userInfo.getPassword());
		
		Process process = pb.start();
        int errCode = process.waitFor();
		System.out.println("Echo command executed, any errors? " + (errCode == 0 ? "No" : "Yes"));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(commit));
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		boolean isContains=element.isDisplayed();
		//System.out.println("Clone test1"+isContains);
		return isContains;
	}

}