package com.homework.walmart;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.homework.resources.*;


public class MacChromeTest {
	
	private final String DRIVER_PATH = "/drivers/chromedriver";
	private final String URL_HOMEPAGE = "http://www.walmart.com";
	private final String USERNAME = "erikacheng1991@gmail.com";
	private final String PASSWORD = "walmart";
	
	private WebDriver driver;
	public WebDriverWait wait;
	
	private SignInPage signInPage;
	private SearchPage searchPage;
	private SelectPage selectPage;
	private ProductPage productPage;
	private AddToCartPage addToCartPage;
	private CleanCartPage cleanCartPage;
	private SignOutPage signOutPage;
	
	
	@BeforeTest
	public void init() throws Exception  {
		System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
				
		driver.get(URL_HOMEPAGE);
				
		signInPage = new SignInPage(driver, wait);
		searchPage = new SearchPage(driver, wait);
		selectPage = new SelectPage(driver, wait);
		productPage = new ProductPage(driver, wait);
		addToCartPage = new AddToCartPage(driver, wait);
		cleanCartPage = new CleanCartPage(driver, wait);
		signOutPage = new SignOutPage(driver);				
	}
	
	@DataProvider(name = "Search terms")
	public Object[][] getData() {
		return new Object[][] {{"tv"}, {"socks"}, {"dvd"}, 
								{"toys"}, {"iPhone"}};
	}
	
	@Test(dataProvider = "Search terms")
	public void addItemToCart(String searchTerms)
		throws InterruptedException {
		//Login using existing account
		signInPage.signInHomePageClick();
		signInPage.signInInformation(USERNAME, PASSWORD);
		signInPage.signInButtonClick();
						
		//Perform a search on home page from a pool of key words
		searchPage.fillInSearch(searchTerms);
		searchPage.searchButtonClick();
			
		//Identify an item from the result set
		selectPage.identifyOneItemFromResult(searchTerms);
		String itemID = selectPage.saveItemId();
			
		//Add the item to cart
		productPage.addToCartClick();

		//Validate that item added is present in the cart and is the only item
		//in the cart
		addToCartPage.viewCartClick();	
		addToCartPage.validateId(itemID);
		addToCartPage.validateNum();
			
		//Clean cart
		cleanCartPage.removeItems();
			
		//Sign out
		signOutPage.signOut();

	}
	

	@AfterTest
	public void exit() throws Exception {
		driver.quit();
	}
}