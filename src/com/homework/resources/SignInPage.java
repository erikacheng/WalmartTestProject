package com.homework.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class SignInPage {
		
	//xpath parameters
	private final String SIGN_IN_XPATH = "//*[@id='top']/div[3]/div/div/div/div/div[4]/div/div[1]/div[1]/p/span[2]/a";
	private final String SIGN_IN_BTN_XPATH = "/html/body/div[1]/section/section[4]/div/div/div/div/div/div/div/form/div/button";

	private WebDriver driver;
	public WebDriverWait wait;
	
	
	/**
	 * Click sign in button on home page
	 */
	public void signInHomePageClick() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(SIGN_IN_XPATH)));
		WebElement signIn = driver.findElement(By.xpath(SIGN_IN_XPATH));
		if (signIn != null) {
			signIn.click();
		}
	}
	
	
	/**
	 * Fill in sign in information
	 * @param username
	 * @param password
	 */
	public void signInInformation(String username, String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("login-username")));	
		WebElement usernameBar = driver.findElement(By.id("login-username"));	
		if (usernameBar != null) {
			usernameBar.clear();
			usernameBar.sendKeys(username);
		}
		WebElement passwordBar = driver.findElement(By
				.id("login-password"));
		if (passwordBar != null)
			passwordBar.clear();
			passwordBar.sendKeys(password);
	}

	/**
	 * Click on sign in button
	 */
	public void signInButtonClick() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(SIGN_IN_BTN_XPATH)));	
		WebElement signInBTN = driver.findElement(By.xpath(SIGN_IN_BTN_XPATH));
		if (signInBTN != null) {
			signInBTN.click();
		}	
	}
	
	
	public SignInPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
}