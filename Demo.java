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
	public static void main(String[] args) throws InterruptedException {
		//create options for firefox
		FirefoxOptions options = new FirefoxOptions();
		//set up a new driver to open firefox
		WebDriver driver = new FirefoxDriver(options);
		//wait
		Thread.sleep(2000);
		
		//wait driver
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//open a specific web page using firefox
		//driver.navigate().to("https://weathershopper.pythonanywhere.com");
		driver.get("https://weathershopper.pythonanywhere.com");
		//wait
		Thread.sleep(2000);
		
		//get the title of the page
		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("Current Temperature")){
			System.out.println("Correct Website");
		}//if
		else {
			System.out.println("Wrong Website");
		}//else
		
		//shop for moisturizers if weather is below 19 degrees
		//shop for sunscreens if weather is above 34
		//save element for temperature
		WebElement tempElement = driver.findElement(By.id("temperature"));
		//save entire string, #degreeC
		String entireTemp = tempElement.getText();
		//parse only temperature from string
		int temp = Integer.parseInt(entireTemp.replaceAll("[^\\d]", ""));
		
		System.out.println("web element: " + tempElement);
		System.out.println("value: " + entireTemp);
		System.out.println("casted value: " + temp);
		//wait
		Thread.sleep(2000);
		
		if(temp < 19) {
			//if weather is below 19 degrees
			System.out.println("below 19");
			//save moisturizers page button
			WebElement buttonMoisturizers = driver.findElement(By.linkText("Buy moisturizers"));
			//click the moisturizers page button
			buttonMoisturizers.click();
			//wait
			Thread.sleep(2000);
			
			//"Aloe"
			//create treemap to hold all aloe moisturizers
			TreeMap<Integer, String> aloeMoi = new TreeMap<>();
			
			//create 2 lists to hold the aloe and their prices
			List<WebElement> aloeList = driver.findElements(By.xpath("//*[text()[contains(.,'Aloe')]]"));
			List<WebElement> aloePriceList = driver.findElements(By.xpath("//*[text()[contains(.,'Aloe')]]//following-sibling::p[1]"));
		
			//create 2 iterators to go through the lists
			Iterator<WebElement> a1 = aloePriceList.iterator();
			Iterator<WebElement> a2 = aloeList.iterator();
			
			//while the lists both have more values
			while(a1.hasNext() && a2.hasNext()) {
				//put the the aloe moisturizers in the map in (price, name) format
				aloeMoi.put(Integer.parseInt(a1.next().getText().replaceAll("[^\\d]", "")), a2.next().getText());
			}//while
			
			//print out all the aloe moisturizers stored in the map
			System.out.println("map: " + aloeMoi);
			
			//save the least expensive aloe moisturizer price and name
			int lowestAloePrice = aloeMoi.firstKey();
			String lowestAloeName = aloeMoi.firstEntry().getValue();
			
			//print out the least expensive aloe moisturizer
			System.out.println(lowestAloeName + ", " + lowestAloePrice);
			
			//set the button to the "add" button for the least expensive aloe moisturizer
			buttonMoisturizers = driver.findElement(By.xpath("//p[contains(text(), '"+lowestAloeName+"')]"
					+ "//following-sibling::p[contains(text(), '"+lowestAloePrice+"')]"
							+ "//following-sibling::button[contains(text(), 'Add')]"));
			
			//add the least expensive aloe moisturizer to the cart
			buttonMoisturizers.click();
			//wait
			Thread.sleep(2000);
			
			//"Almond"
			//create treemap to hold all almond moisturizers
			TreeMap<Integer, String> almoMoi = new TreeMap<>();
			
			//create 2 lists to hold the almond and their prices
			List<WebElement> almoList = driver.findElements(By.xpath("//*[text()[contains(.,'Almond')]]"));
			List<WebElement> almoPriceList = driver.findElements(By.xpath("//*[text()[contains(.,'Almond')]]//following-sibling::p[1]"));
		
			//create 2 iterators to go through the lists
			Iterator<WebElement> a3 = almoPriceList.iterator();
			Iterator<WebElement> a4 = almoList.iterator();
			
			//while the lists both have more values
			while(a3.hasNext() && a4.hasNext()) {
				//put the the aloe moisturizers in the map in (price, name) format
				almoMoi.put(Integer.parseInt(a3.next().getText().replaceAll("[^\\d]", "")), a4.next().getText());
			}//while
			
			//print out all the almond moisturizers stored in the map
			System.out.println("map: " + almoMoi);
			
			//save the least expensive almond moisturizer price and name
			int lowestAlmoPrice = almoMoi.firstKey();
			String lowestAlmoName = almoMoi.firstEntry().getValue();
			
			//print out the least expensive almond moisturizer
			System.out.println(lowestAlmoName + ", " + lowestAlmoPrice);
			
			//set the button to the "add" button for the least expensive almond moisturizer
			buttonMoisturizers = driver.findElement(By.xpath("//p[contains(text(), '"+lowestAlmoName+"')]"
					+ "//following-sibling::p[contains(text(), '"+lowestAlmoPrice+"')]"
							+ "//following-sibling::button[contains(text(), 'Add')]"));
			
			//add the least expensive almond moisturizer to the cart
			buttonMoisturizers.click();
			//wait
			Thread.sleep(2000);
			
			//save the button of the shopping cart
			WebElement buttonCart = driver.findElement(By.id("cart"));
			//click on the cart
			buttonCart.click();
			//wait
			Thread.sleep(2000);
			
			//check cart is correct
			
			WebElement cartTable = driver.findElement(By.xpath("//table"));
			List<WebElement> cartCells = cartTable.findElements(By.xpath("./*"));
			
			String cartCellsText = cartCells.get(1).getText();
			System.out.println(cartCellsText);
			if(cartCellsText.contains(lowestAloeName) && cartCellsText.contains(String.valueOf(lowestAloePrice)) &&
					cartCellsText.contains(lowestAlmoName) && cartCellsText.contains(String.valueOf(lowestAlmoPrice))){
				System.out.println("found all");
			}//if
			else {
				System.out.println("didn't find");
			}//else
			
			//save the button of the submit
			WebElement buttonSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
			//click on the submit button
			buttonSubmit.click();
			//wait
			Thread.sleep(2000);
			
			//switch to payment pop-up
			driver.switchTo().frame("stripe_checkout_app");
			//input sample email into form
			WebElement emailField = driver.findElement(By.id("email"));
			emailField.click();
			emailField.sendKeys("sample@example.com");
			Thread.sleep(300);
			//input sample card number into form
			WebElement cardField = driver.findElement(By.id("card_number"));
			cardField.click();
			cardField.sendKeys("4242");
			cardField.sendKeys("4242");
			cardField.sendKeys("4242");
			cardField.sendKeys("4242");
			Thread.sleep(300);
			//input sample card exp into form
			WebElement expField = driver.findElement(By.id("cc-exp"));
			expField.click();
			expField.sendKeys("01");
			expField.sendKeys("2030");
			Thread.sleep(300);
			//input sample card cvc into form
			WebElement cvcField = driver.findElement(By.id("cc-csc"));
			cvcField.click();
			cvcField.sendKeys("123");
			Thread.sleep(2000);
			//input sample zip code into form
			WebElement zipField = driver.findElement(By.id("billing-zip"));
			zipField.click();
			zipField.sendKeys("12345");
			Thread.sleep(300);
			//wait
			Thread.sleep(2000);
			
			//get submit button
			buttonSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
			//click on the submit button
			buttonSubmit.click();
			//wait
			Thread.sleep(2000);
			
			//change back to main screen
			driver.switchTo().defaultContent();
			
			//wait
			Thread.sleep(2000);
			
			//check if payment is successful or not
			WebElement status = driver.findElement(By.xpath("/html/body/div/div[1]/h2"));
			System.out.println(status);
			System.out.println(status.getText());
			if(status.getText().contains("SUCCESS")) {
				System.out.println("payment success.");
			}//if
			else {
				System.out.println("payment failure.");
			}//else
			
			//wait
			Thread.sleep(2000);
			
		}//if
		else if(temp > 34) {
			//else if the weather is above 34 degrees
			System.out.println("above 34");
			//save sunscreen page button
			WebElement buttonSunscreens = driver.findElement(By.linkText("Buy sunscreens"));
			//click the sunscreen page button
			buttonSunscreens.click();
			//wait
			Thread.sleep(2000);
			
			//"SPF-30"
			//create treemap to hold all SPF30 sunscreens
			TreeMap<Integer, String> spf30Sun = new TreeMap<>();
			
			//create 2 lists to hold the SPF30 and their prices
			List<WebElement> spf30List = driver.findElements(By.xpath("//*[text()[contains(.,'SPF-30')]]"));
			List<WebElement> spf30PriceList = driver.findElements(By.xpath("//*[text()[contains(.,'SPF-30')]]//following-sibling::p[1]"));
		
			//create 2 iterators to go through the lists
			Iterator<WebElement> s1 = spf30PriceList.iterator();
			Iterator<WebElement> s2 = spf30List.iterator();
			
			//while the lists both have more values
			while(s1.hasNext() && s2.hasNext()) {
				//put the the SPF30 sunscreens in the map in (price, name) format
				spf30Sun.put(Integer.parseInt(s1.next().getText().replaceAll("[^\\d]", "")), s2.next().getText());
			}//while
			
			//print out all the SPF30 sunscreens stored in the map
			System.out.println("map: " + spf30Sun);
			
			//save the least expensive SPF30 sunscreen price and name
			int lowestSPF30Price = spf30Sun.firstKey();
			String lowestSPF30Name = spf30Sun.firstEntry().getValue();
			
			//print out the least expensive SPF30 sunscreen
			System.out.println(lowestSPF30Name + ", " + lowestSPF30Price);
			
			//set the button to the "add" button for the least expensive SPF30 sunscreen
			buttonSunscreens = driver.findElement(By.xpath("//p[contains(text(), '"+lowestSPF30Name+"')]"
					+ "//following-sibling::p[contains(text(), '"+lowestSPF30Price+"')]"
							+ "//following-sibling::button[contains(text(), 'Add')]"));
			
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
		
			//create 2 iterators to go through the lists
			Iterator<WebElement> s3 = spf50PriceList.iterator();
			Iterator<WebElement> s4 = spf50List.iterator();
			
			//while the lists both have more values
			while(s3.hasNext() && s4.hasNext()) {
				//put the the SPF50 sunscreens in the map in (price, name) format
				spf50Sun.put(Integer.parseInt(s3.next().getText().replaceAll("[^\\d]", "")), s4.next().getText());
			}//while
			
			//print out all the SPF50 sunscreens stored in the map
			System.out.println("map: " + spf50Sun);
			
			//save the least expensive SPF50 sunscreen price and name
			int lowestSPF50Price = spf50Sun.firstKey();
			String lowestSPF50Name = spf50Sun.firstEntry().getValue();
			
			//print out the least expensive SPF50 sunscreen
			System.out.println(lowestSPF50Name + ", " + lowestSPF50Price);
			
			//set the button to the "add" button for the least expensive SPF50 sunscreen
			buttonSunscreens = driver.findElement(By.xpath("//p[contains(text(), '"+lowestSPF50Name+"')]"
					+ "//following-sibling::p[contains(text(), '"+lowestSPF50Price+"')]"
							+ "//following-sibling::button[contains(text(), 'Add')]"));
			
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
			WebElement cartTable = driver.findElement(By.xpath("//table"));
			List<WebElement> cartCells = cartTable.findElements(By.xpath("./*"));
			
			String cartCellsText = cartCells.get(1).getText();
			System.out.println(cartCellsText);
			if(cartCellsText.contains(lowestSPF30Name) && cartCellsText.contains(String.valueOf(lowestSPF30Price)) &&
					cartCellsText.contains(lowestSPF50Name) && cartCellsText.contains(String.valueOf(lowestSPF50Price))){
				System.out.println("found all");
			}//if
			else {
				System.out.println("didn't find");
			}//else
			
			//save the button of the submit
			//WebElement buttonSubmit = driver.findElement(By.linkText("Pay with Card"));
			WebElement buttonSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
			//click on the submit button
			buttonSubmit.click();
			//wait
			Thread.sleep(2000);
			
			//switch to payment pop-up
			driver.switchTo().frame("stripe_checkout_app");
			//input sample email into form
			WebElement emailField = driver.findElement(By.id("email"));
			emailField.click();
			emailField.sendKeys("sample@example.com");
			Thread.sleep(300);
			//input sample card number into form
			WebElement cardField = driver.findElement(By.id("card_number"));
			cardField.click();
			//cardField.sendKeys("4242 4242 4242 4242");
			cardField.sendKeys("4242");
			cardField.sendKeys("4242");
			cardField.sendKeys("4242");
			cardField.sendKeys("4242");
			Thread.sleep(300);
			//input sample card exp into form
			WebElement expField = driver.findElement(By.id("cc-exp"));
			expField.click();
			expField.sendKeys("01");
			expField.sendKeys("2030");
			Thread.sleep(300);
			//input sample card cvc into form
			WebElement cvcField = driver.findElement(By.id("cc-csc"));
			cvcField.click();
			cvcField.sendKeys("123");
			Thread.sleep(2000);
			//input sample zip code into form
			WebElement zipField = driver.findElement(By.id("billing-zip"));
			zipField.click();
			zipField.sendKeys("12345");
			Thread.sleep(300);
			//wait
			Thread.sleep(2000);
			
			//get submit button
			buttonSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
			//click on the submit button
			buttonSubmit.click();
			//wait
			Thread.sleep(2000);
			

			//change back to main screen
			driver.switchTo().defaultContent();
			
			//wait
			Thread.sleep(2000);
			
			//check if payment is successful or not
			WebElement status = driver.findElement(By.xpath("//h2[contains(text(), 'PAYMENT']"));
			System.out.println(status);
			System.out.println(status.getText());
			if(status.getText().contains("SUCCESS")) {
				System.out.println("payment success.");
			}//if
			else {
				System.out.println("payment failure.");
			}//else
			
			//wait
			Thread.sleep(2000);
			
		}//else if
		else {
			//else the weather is between 19 degrees and 34 degrees
			driver.navigate().refresh();
			System.out.println("refreshed page");
			//wait
			Thread.sleep(2000);
		}//else
		
		
		//end the session ALWAYS NEEDED
		driver.quit();
		
	}//main

}//Demo
