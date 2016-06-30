package com.qait.github.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qait.github.pageobjects.BaseClass;

public class MainTest {
     
	
	public static void main(String[] args) throws IOException, InterruptedException {
		String url="https://github.com/login";
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		BaseClass base=new BaseClass(driver);
		base.signInMethod();
	}
}
