package org.cart;
import java.time.LocalDateTime;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Cart {
	static WebDriver driver;
	@BeforeMethod
	public static void launchbrowser() {
		System.setProperty("webdriver.edge.driver", ".//Drivers//msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
			LocalDateTime d= LocalDateTime.now();
			System.out.println(d);
	}

	@Test
	public void tc1001() {
		driver.get("https://www.amazon.in/");
		WebElement cartIcon = driver.findElement(By.xpath("(//span[@class='nav-cart-icon nav-sprite'])[1]"));
		cartIcon.click();
		System.out.println(driver.getTitle());
	}

	@Test
	public void tc1002() throws InterruptedException {
		driver.get("https://www.amazon.in/");
		WebElement cartIcon = driver.findElement(By.xpath("(//a[@id='nav-cart'])[1]"));
		cartIcon.click();
		
		WebElement cartEmptymsg = driver.findElement(By.xpath("(//h2[normalize-space()='Your Amazon Cart is empty'])[1]"));
		System.out.println(cartEmptymsg.getText());
	}

	@Test
	public void tc1003() throws InterruptedException {
		driver.get("https://www.amazon.in/");
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("iphone 14");
		
		WebElement searchbutton = driver.findElement(By.id("nav-search-submit-button"));
		searchbutton.click();
		Thread.sleep(10000);
		
		WebElement iPhone = driver.findElement(By.partialLinkText("Apple iPhone 14 (128 GB) - Blue"));
		iPhone.click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String winId : allWindow) {
			if (winId != parentWindow) {
				driver.switchTo().window(winId);
			}
		}
		Thread.sleep(5000);
		
		WebElement addTocart = driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[1]"));
		addTocart.click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(10000);

		WebElement cartIcon = driver.findElement(By.xpath("(//span[normalize-space()='Cart'])[1]"));
		cartIcon.click();
		WebElement subTotal = driver.findElement(By.id("sc-subtotal-label-buybox"));
		System.out.println(subTotal.getText());

	}

	@Test
	public void tc1004() throws InterruptedException {
		driver.get("https://www.amazon.in/");
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("iphone 14");
		WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
		searchButton.click();
		Thread.sleep(8000);
		WebElement iPhone = driver.findElement(By.partialLinkText("Apple iPhone 14 (128 GB) - Blue"));
		iPhone.click();

		String parentWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String winId : allWindow) {
			if (winId != parentWindow) {
				driver.switchTo().window(winId);
			}
		}
		Thread.sleep(5000);
		WebElement addTocart = driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[1]"));
		addTocart.click();
		WebElement productTitle = driver.findElement(By.id("productTitle"));
		String proName = productTitle.getText();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(10000);

		WebElement cartIcon = driver.findElement(By.xpath("(//span[normalize-space()='Cart'])[1]"));
		cartIcon.click();

		WebElement setCartprouctname = driver.findElement(By.partialLinkText("Apple iPhone 14 (128 GB) - Blue"));

		String setcartname = setCartprouctname.getText();
		if (proName.equals(setcartname)) {
			System.out.println("Product DETAILS Are DISPLAYED CORRECTLY" + proName);
		}

	}

	@Test
	public void tc1005() throws InterruptedException {
		driver.get("https://www.amazon.in/");
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("iphone 14");
		WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
		searchButton.click();
		Thread.sleep(8000);
		
		WebElement iPhone = driver.findElement(By.partialLinkText("Apple iPhone 14 (128 GB) - Blue"));
		iPhone.click();

		String parentWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String winId : allWindow) {
			if (winId != parentWindow) {
				driver.switchTo().window(winId);
			}
		}
		Thread.sleep(5000);
		WebElement addTocart = driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[1]"));
		addTocart.click();

		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(10000);

		WebElement cartIcon = driver.findElement(By.xpath("(//span[normalize-space()='Cart'])[1]"));
		cartIcon.click();

		WebElement QtyDropdown = driver.findElement(By.id("a-autoid-0"));
		QtyDropdown.click();

		if(QtyDropdown.isDisplayed()) {
			System.out.println("drop down will be displayed correctly");
		}

	}

	@Test
	public void tc1006() throws InterruptedException {
		driver.get("https://www.amazon.in/");
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("iphone 14");
		WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
		searchButton.click();
		Thread.sleep(8000);
		WebElement iPhone = driver.findElement(By.partialLinkText("Apple iPhone 14 (128 GB) - Blue"));
		iPhone.click();

		String parentWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String winId : allWindow) {
			if (winId != parentWindow) {
				driver.switchTo().window(winId);
			}
		}
		Thread.sleep(5000);
		WebElement addTocart = driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[1]"));
		addTocart.click();

		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(10000);

		WebElement cartIcon = driver.findElement(By.xpath("(//span[normalize-space()='Cart'])[1]"));
		cartIcon.click();

		WebElement emiDropdown = driver.findElement(By.xpath("(//i[@class='a-icon a-icon-section-expand'])[1]"));
		emiDropdown.click();
		if(emiDropdown.isDisplayed()) {
			System.out.println("emi drop down will be displayed correctly");
		}

	}

	@Test
	public void tc1009() throws InterruptedException{
		driver.get("https://www.amazon.in/");
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("iphone 14");
		WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
		searchButton.click();
		Thread.sleep(8000);
		WebElement iPhone = driver.findElement(By.partialLinkText("Apple iPhone 14 (128 GB) - Blue"));
		iPhone.click();

		String parentWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String winId : allWindow) {
			if (winId != parentWindow) {
				driver.switchTo().window(winId);
			}
		}
		Thread.sleep(5000);
		WebElement addTocart = driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[1]"));
		addTocart.click();

		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(10000);

		WebElement cartIcon = driver.findElement(By.xpath("(//span[normalize-space()='Cart'])[1]"));
		cartIcon.click();

		Thread.sleep(5000);
		WebElement shareLink = driver.findElement(By.partialLinkText("Share"));
		shareLink.click();
		Thread.sleep(2000);
		WebElement sharePopupmessage = driver.findElement(By.xpath("(//h3[normalize-space()='Share this product with friends'])[1]"));
		System.out.println(sharePopupmessage.getText());
	}




	@AfterMethod
	public static void closebrowser() {
		LocalDateTime d= LocalDateTime.now();
		System.out.println(d);
		driver.quit();
	}



}
