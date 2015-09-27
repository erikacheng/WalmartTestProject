package com.homework.resources;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CleanCartPage {
		
	//xpath parameters
	private final String CART_ITEM_XPATH = "//*[@id='spa-layout']/div/div/div[1]/div/div[4]/div[2]/div";
	
	private WebDriver driver;
	public WebDriverWait wait;
	
	
	/**
	 * Remove button click
	 */
	public void removeClick() {
		By removeClickXpath = By.id("CartRemItemBtn");
		wait.until(ExpectedConditions.elementToBeClickable(driver
				.findElement(removeClickXpath)));
		WebElement removeClick = driver.findElement(removeClickXpath);
		if (removeClick != null)
			removeClick.click();

	}
	
	/**
	 * Remove all items in cart
	 */
	public void removeItems() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(CART_ITEM_XPATH)));		
		List<WebElement> cartDisplay = driver.findElements(By
				.xpath(CART_ITEM_XPATH));
		int size = cartDisplay.size();
		while(cartDisplay != null && size != 0) {			
			removeClick();
			size--;
		}
	}
	
	
	public CleanCartPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
}