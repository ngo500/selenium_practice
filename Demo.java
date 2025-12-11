package p4;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Demo {
	
	/**
	 * This method takes a given WebDriver and opens a web page url given in String format.
	 * @param driver The WebDriver being used for the automation.
	 * @param page The url of the web page to be navigated to in String format.
	 */
	public static void openWebPage(WebDriver driver, String page) {
		//open the page using given url in String format
		driver.get(page);
	}//openWebPage
	
	/**
	 * This method takes a given WebDriver and returns the title of the web page in String format.
	 * @param driver The WebDriver being used for the automation.
	 * @return The title of the found web page in String format.
	 */
	public static String getPageTitle(WebDriver driver) {
		//get the title of the given driver page
		return driver.getTitle();
	}//getPageTitle
	
	/**
	 * This method takes a given WebDriver and returns the entire temperature element of the web page in String format.
	 * @param driver The WebDriver being used for the automation.
	 * @return The entire temperature element in String format.
	 */
	public static String getEntireTemp(WebDriver driver)  {
		//save element for temperature
		WebElement tempElement = driver.findElement(By.id("temperature"));
		//save entire string, #degreeC
		return tempElement.getText();
	}//getTemp
	
	/**
	 * This method takes a given String that contains a temperature element and parses just the temperature number in String format.
	 * @param entireTemp The String that contains the entire temperature element to be parsed.
	 * @return The just the number of the temperature in String format.
	 */
	public static int getParseTemp(String entireTemp) {
		//parse only temperature from string
		return Integer.parseInt(entireTemp.replaceAll("[^\\d]", ""));
	}//getParseTemp
	
	/**
	 * This method takes a given TreeMap, List of WebElement names, and List of WebElement Prices, and puts both lists in the map
	 * in (price, name) format.
	 * @param map The given TreeMap<Integer, String> used to contain the name and price data.
	 * @param nameList The given name List<WebElement> used to put the name data into the map.
	 * @param priceList The given price List<WebElement> used to put the price data into the map.
	 */ 
	public static void fillTreeMap(TreeMap<Integer, String> map, List<WebElement> nameList, List<WebElement> priceList) {
		//create 2 iterators to go through the lists
		Iterator<WebElement> a1 = priceList.iterator();
		Iterator<WebElement> a2 = nameList.iterator();
		
		//while the lists both have more values
		while(a1.hasNext() && a2.hasNext()) {
			//put the the aloe moisturizers in the map in (price, name) format
			map.put(Integer.parseInt(a1.next().getText().replaceAll("[^\\d]", "")), a2.next().getText());
		}//while
	}//fillTreeMap
	
	/**
	 * This method takes a given TreeMap<Integer, String> and returns the lowest price, which is the first key
	 * @param map The given TreeMap<Integer, String> used to contain the name and price data.
	 * @return The first key in the TreeMap<Integer, String> in int format, which is the lowest price in the TreeMap.
	 */
	public static int getLowestPrice(TreeMap<Integer, String> map){
		return map.firstKey();
	}//getLowestPrice
	
	/**
	 * This method takes a given TreeMap<Integer, String> and returns the lowest name, which is the first entry
	 * @param map The given TreeMap<Integer, String> used to contain the name and price data.
	 * @return The first entry in the TreeMap<Integer, String> in String format, which is the lowest name in the TreeMap.
	 */
	public static String getLowestName(TreeMap<Integer, String> map){
		return map.firstEntry().getValue();
	}//getLowestName
	
	/**
	 * This method takes a given WebDriver and given String of a button name, and finds and returns the matching WebElement.
	 * @param driver The WebDriver being used for automation.
	 * @param buttonName The String link text of the button being searched for.
	 * @return The WebElement of the matching button.
	 */
	public static WebElement setButtonByText(WebDriver driver, String buttonName) {
		//save the button
		WebElement buttonElement = driver.findElement(By.linkText(buttonName));
		return buttonElement;
	}//setButtonByName
	
	/**
	 * This method takes a given WebDriver, given String of the lowest name in the list, given int of the lowest price in the list,
	 * and finds and returns the matching 'Add' button WebElement.
	 * @param driver The WebDriver being used for automation.
	 * @param lowestName The String of the lowest name in the list.
	 * @param lowestPrice The int of the lowest price in the list.
	 * @return The WebElement of the matching 'Add' button.
	 */
	public static WebElement setButtonByLeastPath(WebDriver driver, String lowestName, int lowestPrice) {
		//set the button to the "add" button for the least expensive item by name and price
		return driver.findElement(By.xpath("//p[contains(text(), '"+lowestName+"')]"
				+ "//following-sibling::p[contains(text(), '"+lowestPrice+"')]"
						+ "//following-sibling::button[contains(text(), 'Add')]"));
	}//setButtonByLeastPath
	
	/**
	 * This method takes a given WebDriver and given String of an element ID, and finds and returns the matching WebElement.
	 * @param driver The WebDriver being used for automation.
	 * @param elementId The String of the ID being searched for.
	 * @return The WebElement that matches the given ID.
	 */
	public static WebElement setElementById(WebDriver driver, String elementId) {
		return driver.findElement(By.id(elementId));
	}//setElementById
	
	/**
	 * This method takes a given WebDriver and given String of an element's XPath, and finds and returns the matching WebElement.
	 * @param driver  The WebDriver being used for automation.
	 * @param pathText The String of the XPath being searched for.
	 * @return The WebElement that matches the given XPath.
	 */
	public static WebElement setElementByXPath(WebDriver driver, String pathText) {
		return driver.findElement(By.xpath(pathText));
	}//setElementByXPath
	
	/**
	 * This method takes a given WebDriver and given String of an element's XPath, and finds and returns all matching WebElements
	 * in a List of WebElements.
	 * @param driver The WebDriver being used for automation.
	 * @param pathText The String of the XPath being used to find all matching elements.
	 * @return The List of WebElements that match the given XPath.
	 */
	public static List<WebElement> setListByXPath(WebDriver driver, String pathText){
		List<WebElement> foundList = driver.findElements(By.xpath(pathText));
		return foundList;
	}//setListByXPath
	
	/**
	 * This method takes a given WebElement and given String of an element's path, and finds and returns all matching WebElements
	 * in a List of WebElements.
	 * @param ele The WebElement being searched through.
	 * @param pathText The String of the XPath being used to find all matching elements.
	 * @return The List of WebElements that match the given XPath.
	 */
	public static List<WebElement> setListElementByXPath(WebElement ele, String pathText){
		return ele.findElements(By.xpath(pathText));
	}//setListElementByXPath
	
	/**
	 * This method takes a given WebElement and clicks on it.
	 * @param buttonElement The WebElement being clicked on.
	 */
	public static void clickButton(WebElement buttonElement) {
		//click the on page button
		buttonElement.click();
	}//clickButton
	
	/**
	 * This method takes a given WebDriver and gets the data of the shopping cart, returning the data in String format.
	 * @param driver The WebDriver being used for automation. 
	 * @return The shopping cart cells found in String format.
	 */
	public static String getCartCellsText(WebDriver driver) {
		//save cart as a List<WebElement> for easy parsing
		String elementPath = "//table";
		WebElement cartTable = setElementByXPath(driver, elementPath);
		elementPath = "./*";
		List<WebElement> cartCells = setListElementByXPath(cartTable, elementPath);
		
		//get the cart data
		return cartCells.get(1).getText();
	}//getCartCellsText
	
	/**
	 * This method takes a given String that contains the current shopping cart's contents and parses it. It looks for the lowest
	 * name and price of the first item type, and the lowest name and price of the second item type. If all are found in the cart,
	 * the method returns true. Else, the method returns false.
	 * @param cartCellsText The String that contains the current contents of the shopping cart.
	 * @param lowestFirstName The first item type's name to search for in the shopping cart.
	 * @param lowestFirstPrice The first item type's price to search for in the shopping cart.
	 * @param lowestSecondName The second item type's name to search for in the shopping cart.
	 * @param lowestAlmoPrice The second item type's price to search for in the shopping cart.
	 * @return The boolean that reflects whether all names and prices were found in the shopping cart. Returns true if all were 
	 * found, and false if they were not all found.
	 */
	public static boolean confirmCart(String cartCellsText, String lowestFirstName, int lowestFirstPrice, 
			String lowestSecondName, int lowestSecondPrice) {
		if(cartCellsText.contains(lowestFirstName) && cartCellsText.contains(String.valueOf(lowestFirstPrice)) &&
				cartCellsText.contains(lowestSecondName) && cartCellsText.contains(String.valueOf(lowestSecondPrice))){
			return true;
		}//if
		else {
			return false;
		}//else
	}//confirmCart
	
	/**
	 * This method takes a given WebDriver and goes through a test checkout screen, using real test credit card information.
	 * @param driver The WebDriver being used for automation. 
	 * @throws InterruptedException If interrupted, throws InterruptedException error. 
	 */
	public static void checkoutCart(WebDriver driver) throws InterruptedException {
		//save the path of the submit button
		String elementPath = "//button[@type='submit']";
		WebElement buttonSubmit = setElementByXPath(driver, elementPath);
		//click on the submit button
		clickButton(buttonSubmit);
		//wait
		Thread.sleep(2000);
		
		//switch to payment pop-up
		driver.switchTo().frame("stripe_checkout_app");
		
		//input sample email into form
		elementPath = "email";
		WebElement emailField = setElementById(driver, elementPath);
		clickButton(emailField);
		emailField.sendKeys("sample@example.com");
		Thread.sleep(300);
		
		//input sample card number into form
		elementPath = "card_number";
		WebElement cardField = setElementById(driver, elementPath);
		clickButton(cardField);
		cardField.sendKeys("4242");
		cardField.sendKeys("4242");
		cardField.sendKeys("4242");
		cardField.sendKeys("4242");
		Thread.sleep(300);
		
		//input sample card exp into form
		elementPath = "cc-exp";
		WebElement expField = setElementById(driver, elementPath);
		clickButton(expField);
		expField.sendKeys("01");
		expField.sendKeys("2030");
		Thread.sleep(300);
		
		//input sample card cvc into form
		elementPath = "cc-csc";
		WebElement cvcField = setElementById(driver, elementPath);
		clickButton(cvcField);
		cvcField.sendKeys("123");
		Thread.sleep(2000);
		
		//input sample zip code into form
		elementPath = "billing-zip";
		WebElement zipField = setElementById(driver, elementPath);
		clickButton(zipField);
		zipField.sendKeys("12345");
		Thread.sleep(300);
		
		//wait
		Thread.sleep(2000);
		
		//get submit button
		elementPath = "//button[@type='submit']";
		buttonSubmit = setElementByXPath(driver, elementPath);
		clickButton(buttonSubmit);
		
		//wait
		Thread.sleep(2000);
		
		//change back to main screen
		driver.switchTo().defaultContent();
		
		//wait
		Thread.sleep(2000);
	}//checkoutCart
	
	/**
	 * This method takes a given WebDriver and returns the status of the payment made in WebElement format.
	 * @param driver The WebDriver being used for automation.
	 * @return The WebElement that holds the status of the payment made.
	 */
	public static WebElement getPaymentStatus(WebDriver driver) {
		//check if payment is successful or not
		String elementPath = "/html/body/div/div[1]/h2";
		WebElement status = setElementByXPath(driver, elementPath);
		return status;
	}//getPaymentStatus
	
	public static void main(String[] args) throws InterruptedException {
		
		//create options for firefox
		FirefoxOptions options = new FirefoxOptions();
		//set up a new driver to open firefox
		WebDriver driver = new FirefoxDriver(options);
		//wait
		Thread.sleep(2000);
		
		//open a specific web page using firefox
		String page = "https://weathershopper.pythonanywhere.com";
		//call the openWebPage method
		openWebPage(driver, page);
		//wait
		Thread.sleep(2000);
		
		//get the title of the page using getPageTitle method
		String title = getPageTitle(driver);
		//print the title
		System.out.println("The title of this page is: " + title + ".");
		//check if the page title is correct
		if(title.contains("Current Temperature")){
			//the title is correct
			System.out.println("Correct Website.");
			
			//shop for moisturizers if weather is below 19 degrees
			//shop for sunscreens if weather is above 34
			//get the entire temp string using getEntireTemp method
			String entireTemp = getEntireTemp(driver);
			
			//parse only temperature from string using getParseTemp method
			int temp = getParseTemp(entireTemp);
			
			//print out what the current temp is
			System.out.println("The current temperature is: " + entireTemp + ".");
			//wait
			Thread.sleep(2000);
			
			if(temp < 19) {
				//if weather is below 19 degrees,
				System.out.println("The weather is below 19 degrees.");
				
				//click the moisturizers page button
				String elementPath = "Buy moisturizers";
				WebElement buttonMoisturizers = setButtonByText(driver, elementPath);
				clickButton(buttonMoisturizers);
				
				//wait
				Thread.sleep(2000);
				
				//"Aloe"
				//create treemap to hold all aloe moisturizers
				TreeMap<Integer, String> aloeMoi = new TreeMap<>();
				
				//create 2 lists to hold the aloe and their prices
				elementPath = "//*[text()[contains(.,'Aloe')]]";
				List<WebElement> aloeList = setListByXPath(driver, elementPath);
				elementPath = "//*[text()[contains(.,'Aloe')]]//following-sibling::p[1]";
				List<WebElement> aloePriceList = setListByXPath(driver, elementPath);
				
				//fill the TreeMap with data from name List<WebElement> and price List<WebElement> in (price, name) format
				fillTreeMap(aloeMoi, aloeList, aloePriceList);
				
				//print out all the aloe moisturizers stored in the map
				System.out.println("map: " + aloeMoi);
				
				//save the least expensive aloe moisturizer price and name
				int lowestAloePrice = getLowestPrice(aloeMoi);
				String lowestAloeName = getLowestName(aloeMoi);
				
				//print out the least expensive aloe moisturizer
				System.out.println(lowestAloeName + ", " + lowestAloePrice);
				
				//set the button to the "add" button for the least expensive aloe moisturizer
				buttonMoisturizers = setButtonByLeastPath(driver, lowestAloeName, lowestAloePrice);
				
				//add the least expensive aloe moisturizer to the cart
				clickButton(buttonMoisturizers);
				//wait
				Thread.sleep(2000);
				
				//"Almond"
				//create treemap to hold all almond moisturizers
				TreeMap<Integer, String> almoMoi = new TreeMap<>();
				
				//create 2 lists to hold the almond and their prices
				elementPath = "//*[text()[contains(.,'Almond')]]";
				List<WebElement> almoList = setListByXPath(driver, elementPath);
				elementPath = "//*[text()[contains(.,'Almond')]]//following-sibling::p[1]";
				List<WebElement> almoPriceList = setListByXPath(driver, elementPath);
				
				//fill the TreeMap with data from name List<WebElement> and price List<WebElement> in (price, name) format
				fillTreeMap(almoMoi, almoList, almoPriceList);
				
				//print out all the almond moisturizers stored in the map
				System.out.println("map: " + almoMoi);
				
				//save the least expensive almond moisturizer price and name
				int lowestAlmoPrice = getLowestPrice(almoMoi);
				String lowestAlmoName = getLowestName(almoMoi);
				
				//print out the least expensive almond moisturizer
				System.out.println(lowestAlmoName + ", " + lowestAlmoPrice);
				
				//set the button to the "add" button for the least expensive almond moisturizer
				buttonMoisturizers = setButtonByLeastPath(driver, lowestAlmoName, lowestAlmoPrice);
				
				//add the least expensive almond moisturizer to the cart
				clickButton(buttonMoisturizers);
				//wait
				Thread.sleep(2000);
				
				//save the id of the button for the shopping cart
				elementPath = "cart";
				WebElement buttonCart = setElementById(driver, elementPath);
				//click on the cart
				clickButton(buttonCart);
				//wait
				Thread.sleep(2000);
				
				//check cart is correct
				String cartCellsText = getCartCellsText(driver);
				
				//print the cart data
				System.out.println(cartCellsText);
				
				//call confirmCart to determine if shopping cart contains all correct items
				if(confirmCart(cartCellsText, lowestAloeName, lowestAloePrice, lowestAlmoName, lowestAlmoPrice)){
					System.out.println("found all");
					
					//call checkoutCart to proceed through shopping cart checkout process
					checkoutCart(driver);
					
					//call getPaymentStatus to check the current status of the payment
					WebElement status = getPaymentStatus(driver);
					
					//print if the payment was successful or not
					if(status.getText().contains("SUCCESS")) {
						System.out.println("payment success.");
					}//if
					else {
						System.out.println("payment failure.");
					}//else
					
					//wait
					Thread.sleep(2000);
				}//if
				else {
					System.out.println("ERROR- didn't find");
				}//else
			}//if
			else if(temp > 34) {
				//else if the weather is above 34 degrees
				System.out.println("The temperature is above 34 degrees.");
				
				//click the sunscreen page button
				String elementPath = "Buy sunscreens";
				WebElement buttonSunscreens = driver.findElement(By.linkText(elementPath));
				buttonSunscreens.click();
				
				//wait
				Thread.sleep(2000);
				
				//"SPF-30"
				//create treemap to hold all SPF30 sunscreens
				TreeMap<Integer, String> spf30Sun = new TreeMap<>();
				
				//create 2 lists to hold the SPF30 and their prices
				List<WebElement> spf30List = driver.findElements(By.xpath("//*[text()[contains(.,'SPF-30')]]"));
				List<WebElement> spf30PriceList = driver.findElements(By.xpath("//*[text()[contains(.,'SPF-30')]]//following-sibling::p[1]"));
			
				//fill the TreeMap with data from name List<WebElement> and price List<WebElement> in (price, name) format
				fillTreeMap(spf30Sun, spf30List, spf30PriceList);
				
				//print out all the SPF30 sunscreens stored in the map
				System.out.println("map: " + spf30Sun);
				
				//save the least expensive SPF30 sunscreen price and name
				int lowestSPF30Price = spf30Sun.firstKey();
				String lowestSPF30Name = spf30Sun.firstEntry().getValue();
				
				//print out the least expensive SPF30 sunscreen
				System.out.println(lowestSPF30Name + ", " + lowestSPF30Price);
				
				//set the button to the "add" button for the least expensive SPF30 sunscreen
				buttonSunscreens = setButtonByLeastPath(driver, lowestSPF30Name, lowestSPF30Price);
				
				//add the least expensive SPF30 sunscreen to the cart
				buttonSunscreens.click();
				//wait
				Thread.sleep(2000);

				//"SPF-50"
				//create treemap to hold all SPF50 sunscreens
				TreeMap<Integer, String> spf50Sun = new TreeMap<>();
				
				//create 2 lists to hold the SPF50 and their prices
				List<WebElement> spf50List = driver.findElements(By.xpath("//*[text()[contains(.,'SPF-50')]]"));
				List<WebElement> spf50PriceList = driver.findElements(By.xpath("//*[text()[contains(.,'SPF-50')]]//following-sibling::p[1]"));
			
				//fill the TreeMap with data from name List<WebElement> and price List<WebElement> in (price, name) format
				fillTreeMap(spf50Sun, spf50List, spf50PriceList);
				
				//print out all the SPF50 sunscreens stored in the map
				System.out.println("map: " + spf50Sun);
				
				//save the least expensive SPF50 sunscreen price and name
				int lowestSPF50Price = spf50Sun.firstKey();
				String lowestSPF50Name = spf50Sun.firstEntry().getValue();
				
				//print out the least expensive SPF50 sunscreen
				System.out.println(lowestSPF50Name + ", " + lowestSPF50Price);
				
				//set the button to the "add" button for the least expensive SPF50 sunscreen
				buttonSunscreens = setButtonByLeastPath(driver, lowestSPF50Name, lowestSPF50Price);
				
				//add the least expensive SPF50 sunscreen to the cart
				buttonSunscreens.click();
				//wait
				Thread.sleep(2000);
				
				//save the button of the shopping cart
				WebElement buttonCart = driver.findElement(By.id("cart"));
				//click on the cart
				buttonCart.click();
				//wait
				Thread.sleep(2000);
				
				//check cart is correct
				String cartCellsText = getCartCellsText(driver);
				
				//print the cart data
				System.out.println(cartCellsText);
				
				//call confirmCart to determine if shopping cart contains all correct items
				if(confirmCart(cartCellsText, lowestSPF30Name, lowestSPF30Price, lowestSPF50Name, lowestSPF50Price)){
					System.out.println("found all");
					
					//call checkoutCart to proceed through shopping cart checkout process
					checkoutCart(driver);
					
					//call getPaymentStatus to check the current status of the payment
					WebElement status = getPaymentStatus(driver);
					
					//print if the payment was successful or not
					if(status.getText().contains("SUCCESS")) {
						System.out.println("payment success.");
					}//if
					else {
						System.out.println("payment failure.");
					}//else
					
					//wait
					Thread.sleep(2000);
				}//if
				else {
					System.out.println("ERROR- didn't find");
				}//else
			}//else if
			else {
				//else the weather is between 19 degrees and 34 degrees
				System.out.println("ERROR- incorrect temperature");
				//wait
				Thread.sleep(2000);
			}//else
		}//if
		else {
			//the title is incorrect
			System.out.println("ERROR- Wrong Website.");
		}//else
		
		//end the session ALWAYS NEEDED
		driver.quit();
		
	}//main

}//Demo
