CONTENTS OF THIS FILE
---------------------
 * Introduction
 * Requirements
 * Installation
 * Project Design
 * Possible bugs
 * Technical Choice
 * Trade-offs
 * Future Improvements
 
INTRODUCTION
-------------
This project automates an end-to-end user e-commerce transaction flow using any open source tool for www.walmart.com with an existing customer on Chrome.

REQUIREMENTS
------------
### Scenarios to Automate
 * Login using existing account
 * Perform a search on home page from a pool of key words given below
 * Identify an item from the result set that you can add to cart
 * Add the item to cart    
 * Validate that item added is present in the cart and is the only item in the cart

### Test Data
 * username / password: erikacheng1991@gmail.com / walmart
 * Search terms: tv, socks, dvd, toys, iPhone

INSTALLATION
------------
### Environment Requirement
 * Mac computer
 * Java SE 8 runtime environment
 * Eclipse IDE
 * WebDriver (chromedriver file in "drivers" folder, please move folder "drivers" to root path of disk)
 * Selenium (Already included in bins file, no need to download).
 * TestNG Eclipse plugin(Install from http://testng.org/doc/download.html)
 
 ### Project Import and Running
  * Open Eclipse -> Import -> Existing Projects Into Workspace
  *	Select Root Directory to the unzipped project folder, the project will show up in the Projects section
  * Click Finish and the project is imported to your workspace. 
  * Open test class MacChromeTest.java in com.homework.walmart package.
  * Run as TestNG
  
 PROJECT DESIGN
 --------------
 ### Design Assumptions
  * Search will be executed only when signed in.
  * The cart is empty when logged in.
  * Items are added as default style.
  * Cart will be cleared before log out.

 ### Test Flow
 	1. Init chromedriver to open chrome web server on Mac.
	2. Open Walmart homepage www.walmart.com.
	3. Sign in using existing username and password list in Requirements -> Test Data.
	4. Perform a search on home page from a pool of key words given.
	5: Identify an item from the result set.
	6: Add the selected item to cart.
	7. Validate that item added is present in the cart and is the only item in the cart by checking item id and cart item number.
	8. Delete item in cart to clear the cart.
	9. Logout from the account.
	10. Start from 1 again until all 5 search terms are tested.

POSSIBLE BUGS
-------------
 * Page may load incompletely when driver move on processing, thus test is interrupted.
	
TECHNICAL CHOICE
----------------
 * Selenium & WebDriver: Selenium has recently include the WebDriver API, and WebDriver is a tool for automating testing web applications, and in particular to verify that they work as expected. It aims to provide a friendly API that's easy to explore and understand, which will help make your tests easier to read and maintain.
 * TestNG: TestNG is a testing framework inspired from JUnit and NUnit but introducing some new functionalities that make it more powerful and easier to use. The TestNG Eclipse plug-in allows you to run your TestNG tests from Eclipse and easily monitor their execution and their output. I'm confortable in Java programming on Eclipse, and TestNG is perfect for developing Java testing project.
 
TRADE-OFFS
----------
  * Simplified user action modes.
  * Simplified webElement function calls.
  * Test only on Mac for Chrome browser.

### Reasons for trade-offs 
  * Lack of development platforms(Windows environment)
  * Lack of time.
  
FUTURE IMPROVEMENTS
-------------------
  * Automate more scenarios to make the automation more robust. 
  * Develop chromedriver automation on Windows system and mobile automation.
  * Rebuild the code to improve reusability and eliminate duplication. 