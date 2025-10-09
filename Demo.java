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
			TreeMap<Integer, String> aloeMoi = new TreeMap<>();
			
			List<WebElement> aloeList = driver.findElements(By.xpath("//*[text()[contains(.,'Aloe')]]"));
			List<WebElement> aloePriceList = driver.findElements(By.xpath("//*[text()[contains(.,'Aloe')]]//following-sibling::p[1]"));
		
			Iterator<WebElement> a1 = aloePriceList.iterator();
			Iterator<WebElement> a2 = aloeList.iterator();
			
			while(a1.hasNext() && a2.hasNext()) {
				aloeMoi.put(Integer.parseInt(a1.next().getText().replaceAll("[^\\d]", "")), a2.next().getText());
			}//while
			
			System.out.println("map: " + aloeMoi);
			
			//"Almond"
			
			//parse aloe list
			
			
			//find min in aloe list
			
			//add least expensive moi with aloe
			
			//click least expensive moi with almond
			
			//add 2 moisturizers to the cart
			//1- select the least expensive moisturizer that has aloe
			//2- select the least expensive moisturizer that has almond
			//click on the cart
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
			TreeMap<Integer, String> spf30Sun = new TreeMap<>();
			
			List<WebElement> spf30List = driver.findElements(By.xpath("//*[text()[contains(.,'SPF-30')]]"));
			List<WebElement> spf30PriceList = driver.findElements(By.xpath("//*[text()[contains(.,'SPF-30')]]//following-sibling::p[1]"));
		
			Iterator<WebElement> s1 = spf30PriceList.iterator();
			Iterator<WebElement> s2 = spf30List.iterator();
			
			while(s1.hasNext() && s2.hasNext()) {
				spf30Sun.put(Integer.parseInt(s1.next().getText().replaceAll("[^\\d]", "")), s2.next().getText());
			}//while
			
			System.out.println("map: " + spf30Sun);

			//"SPF-50"
			
			//add 2 sunscreens to the cart
			//1- select the least expensive sunscreen that is SPF-50
			//2- select the least expensive sunscreen that is SPF-30
			//click on the cart
			
			//check cart is correct
			//fill out payment details and submit the form
			//use 'stripe test card numbers' for valid cards
			//payment screen error 5% of the time
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
