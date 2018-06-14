package com.order;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/emin/Documents/selenium dependencies/drivers/chromedriver" );
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
//		driver.switchTo().window(driver.getWindowHandle());
		driver.manage().window().fullscreen();
		
		String UserId = "ctl00_MainContent_username";
		driver.findElement(By.id(UserId )).sendKeys("Tester");
		
		String pass = "ctl00$MainContent$password";
		driver.findElement(By.name(pass)).sendKeys("test");
		
//      Thread.sleep(2000)
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // This will wait 10 second, different than Thread.sleep(), if the page is open in
		// 2 second, we do not have to 10 second but for thread we have to wait 10 second
		
		String button = "ctl00$MainContent$login_button";
		driver.findElement(By.name(button)).click();
		
		String path = "//*[@id=\"ctl00_menu\"]/li[3]/a";
		driver.findElement(By.xpath(path)).click();
		
		String quantity = "ctl00$MainContent$fmwOrder$txtQuantity";

		int order = (int) ((Math.random() * 100) +1);
		driver.findElement(By.name(quantity)).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.name(quantity)).sendKeys(String.valueOf(order));
		
//		String name = "";
//		name = name.concat("Mike ");
//		
//		String letters = "abcdefghijklmnopqrstuvwxyz";
//		String middle = "";
//		
//		for (int i = 0; i < 5; i++) {
//			char c = letters.charAt((int) (Math.random() * 27));
//			middle += c;
//		}
//		String middle1 = middle.substring(0, 1).toUpperCase() + middle.substring(1);
//		System.out.println(middle1);
//		
//		name = name.concat(middle1);
//		name = name.concat(" Tyson");
//		
//		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtName\"]")).sendKeys(name);
			
		
		String[] middleNames = {"Smith", "John", "Dave", "Duke", "Sam"};
		
		String middle = middleNames[(int) (Math.random() * 5)];
		
		String name = "Mike " +middle+ " Tyson";
		
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtName\"]")).sendKeys(name);
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any st");
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Anytown");
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Virginia");
		
		String zipcode = "";
		zipcode = String.valueOf(((int) (Math.random() * 100000)));
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(zipcode);
		
		
		
		int num = (int)(Math.random() * 3);
		
		switch(num) {
		case 0:
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
			break;
		case 1:
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
			break;
		case 2:
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();
			break;
		default:
			System.out.println("Invalid Entry");
			break;
		
		}
		
		String cardNum = "";
		for (int i = 0; i < 3; i++) {
			cardNum += String.valueOf((int)(Math.random() * 100000));
		}
		
		switch(num) {
		case 0:
			cardNum = "4" + cardNum;
			break;
		case 1:
			cardNum = "5" + cardNum;
			break;
		case 2:
			cardNum = "3" + cardNum.substring(1);
			break;
		default:
			System.out.println("Invalid Entry");
			break;
		}
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(cardNum);
		
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("11/22");
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
		
		String expected = "New order has been successfully added.";
		String actual = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong")).getText();
		System.out.println(actual);
		if(expected.contains(actual)) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
	}

}
