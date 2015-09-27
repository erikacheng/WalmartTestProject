package com.homework.resources;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class AddToCartPage {
		
	//xpath parameters
	private final String VIEW_CART_BTN = "//*[@id='PACViewCartBtn']";
	private final String CART_ITEM_XPATH = "//*[@id='spa-layout']/div/div/div[1]/div/div[4]/div[2]/div";
	
	public WebDriverWait wait;
	private WebDriver driver;
		
	
	/**
	 * Validate item ID
	 * @param itemID
	 */
	public void validateId(String itemID) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(CART_ITEM_XPATH)));		
		List<WebElement> cartItems = driver.findElements(By
				.xpath(CART_ITEM_XPATH));

		WebElement cartItemOne = cartItems.get(0);
		Assert.assertTrue(cartItemOne != null);

		WebElement one = cartItemOne.findElement(By.id("CartItemInfo"));
		boolean idToCart = false;
		String idInCart = null;
		try {
			idInCart = one.getAttribute("data-us-item-id");
			if (idInCart != null) {
				idToCart = true;
			}
		} catch (Exception e) {
		}
		Assert.assertTrue(idToCart, 
				"Selected item not put in cart!");
		Assert.assertEquals(idInCart, itemID);
	}
	
	/**
	 * Validate item number
	 */
	public void validateNum() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(CART_ITEM_XPATH)));		
		List<WebElement> cartItems = driver.findElements(By
				.xpath(CART_ITEM_XPATH));
		Assert.assertTrue(cartItems != null && cartItems.size() == 1,
				"More than one items in cart!");
	}

	/**
	 * View cart button click
	 */
	public void viewCartClick() {
		//Simulate customer actions
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(VIEW_CART_BTN)));
		WebElement viewCart = driver.findElement(By.xpath(VIEW_CART_BTN));
		if (viewCart != null) {
			viewCart.click();
		}
	}
	
	
	public AddToCartPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
}