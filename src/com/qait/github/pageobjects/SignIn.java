package com.qait.github.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SignIn extends BaseClass{
	public SignIn(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "login_field")
	private WebElement userName;

	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(name = "commit")
	private WebElement submitButton;
   
	@FindBy(className="auth-form-header")
	private WebElement title;
	
	public String getTitle(){
		String signInTitle=title.getText();
		return signInTitle;
	}
	
	public String signIn(String user,String pass) {
	        // We continue using the element just as before
	        userName.sendKeys(user);
	        password.sendKeys(pass);
	        submitButton.click();
	       return driver.getCurrentUrl();
	      }
	
}
