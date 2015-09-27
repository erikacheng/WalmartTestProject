package com.homework.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductPage {
	//xpath parameters	
	private final String PRODUCT_XPATH = "/html/body/div[1]/section/section[4]/div/div[2]/div[1]/div[4]/div[2]/div/div[2]/div/div[2]";
	private final String ADD_TO_CART_BTN_XPATH = "//*[@id='WMItemAddToCartBtn']";
	
	
	public WebDriver driver;
	public WebDriverWait wait;
		
	
	/**
	 * Add to cart button click
	 */	
	public void addToCartClick() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(PRODUCT_XPATH)));		
		WebElement addToCart = driver.findElement(By.xpath(ADD_TO_CART_BTN_XPATH));
		if(addToCart != null) {
			addToCart.click();
		}
	}

	
	public ProductPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
}