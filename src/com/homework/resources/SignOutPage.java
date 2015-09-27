package com.homework.resources;

import org.openqa.selenium.WebDriver;


public class SignOutPage {
		
	private final String URL_LOGOUT = "https://www.walmart.com/account/logout";
	
	private WebDriver driver;
	
	public void signOut() {
		// Sign out before end of test
		driver.get(URL_LOGOUT);
	}
	
	public SignOutPage(WebDriver driver) {
		this.driver = driver;
	}
}
