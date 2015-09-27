package com.homework.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class SelectPage {
		
	//xpath parameters
	private final String ITEMS_VIEW_XPATh = "//div[1]/section/section[4]/div/div/div[3]/div[1]/div[1]/a";
	private final String ITEMS_DEP_XPATH = "//div[1]/section/section[4]/div/div/div[3]/div[1]/div[1]";	
	private final String ITEM_ID = "data-product-id";

	private WebDriver driver;
	public WebDriverWait wait;

	
	/**
	 * Identify an item from the result set
	 * @param searchTerm
	 */
	public void identifyOneItemFromResult(String searchTerm) {
		try {
			//Some merchandises have department selection before go to merchandise list
			WebElement departmentSec = driver.findElement(By.xpath(ITEMS_DEP_XPATH));
			if (departmentSec != null) {
				WebElement itemView = driver.findElement(By
						.xpath(ITEMS_VIEW_XPATh));
				if (itemView != null) {
					itemView.click();
				}
			}
		} catch (Exception ex) {
		} finally {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.id("tile-container")));
				WebElement firstItem = driver.findElement(By
						.xpath("//*[@id='tile-container']/div[1]/div/div/h4/a"));
				if (firstItem != null) {
					firstItem.click();
				}
			} catch (Exception ex) {
			}
		}
	}

	/**
	 * Save item id for future verification
	 * @return
	 */
	public String saveItemId() {
		String itemIdStore = "//div[@class='js-reviews see-all-reviews']";
		wait.until(ExpectedConditions.visibilityOfElementLocated
									(By.xpath(itemIdStore)));
		WebElement webElement = driver.findElement(By.xpath(itemIdStore));
		Assert.assertTrue(webElement != null);

		Boolean isItemIdPresent = false;
		String productIDAddToCart = null;
		try {
			productIDAddToCart = webElement.getAttribute(ITEM_ID);
			if (productIDAddToCart != null) {
				isItemIdPresent = true;
			}
		} catch (Exception e) {
		}
		Assert.assertTrue(isItemIdPresent,
				"No product Id stored!");
		return productIDAddToCart;
	}


	
	
	public SelectPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
}