package com.qait.github.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommitIdPageObject extends BaseClass{
   WebDriver driver;
   public CommitIdPageObject(WebDriver driver){
	   super(driver);
	   this.driver=driver;
   }
  
   @FindBy(css=".commits a")
   private WebElement commitLink;
 
   @FindBy(className="js-zeroclipboard")
   private List<WebElement> commitIdsButttons;
   
   
   public String getCommitIdUi(){
	   driver.get("https://github.com/pinkimondal-Qait/NewRepository");
	   commitLink.click();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   String commitIdFromUi=commitIdsButttons.get(0).getAttribute("data-clipboard-text");
	  // System.out.println("Ui  "+commitIdFromUi);
       return commitIdFromUi;
   }


}
