package com.homework.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchPage {
		
	//xpath parameters
	private final String SEARCH_BAR_XPATH = "id('top')/div[3]/div/div/div/div/div[3]/form/div/div[2]/span/input";
	private final String SEARCH_BTN_XPATH = "id('top')/div[3]/div/div/div/div/div[3]/form/div/div[3]/button";
	private final String CHECK_ORDER_BTN_XPATH = "/html/body/div[1]/section/section[4]/div/div/div/div/div[2]/div/div[2]/a";


	public WebDriver driver;
	public WebDriverWait wait;
	
	
	/**
	 * Fill in search bar
	 */
	public void fillInSearch(String searchTerms) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(CHECK_ORDER_BTN_XPATH)));
		WebElement searchBar = driver.findElement(By.xpath(SEARCH_BAR_XPATH));
		if (searchBar != null) {
			searchBar.clear();
			searchBar.sendKeys(searchTerms);
		}	
	}

	/**
	 * Search button click
	 */
	public void searchButtonClick() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(SEARCH_BTN_XPATH)));				
		WebElement searchButton = driver.findElement(By.xpath(SEARCH_BTN_XPATH));
		if (searchButton != null) {
			searchButton.click();
		}
	}
	
	public SearchPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
}