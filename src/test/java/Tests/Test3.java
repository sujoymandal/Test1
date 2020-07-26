package Tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class Test3 {

	public static WebDriver  driver;
	
	public static void main(String[] args) throws Exception {

		String driverPath = System.getProperty("user.dir") + "\\resources\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", driverPath);
		driver = new InternetExplorerDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://dev-login.molace-pcc.net/Membership/Login");
		// List<WebElement> elements=driver.findElements(By.xpath("//label"));
		// for(WebElement e:elements){
		// System.out.println(e.getText());
		// }

		driver.findElement(By.xpath("(//label[text()='User Name']/following::input)[1]")).sendKeys("dharas");
		driver.findElement(By.xpath("(//label[text()='Password']/following::input)[1]")).sendKeys("may01@2020");
		driver.findElement(By.xpath("(//label[text()='Password']/following::input)[2]")).click();
		WebElement e1 = driver
				.findElement(By.xpath("(//span[@class='k-link k-menu-link' and text()='Operational'])[1]"));
		WebElement e2 = driver.findElement(By.xpath("//span[text()='Documentation']"));
		
		//driver.findElement(By.xpath("//li/a[text()='B/L Search']")).click();

		Actions act = new Actions(driver);
		act.moveToElement(e1);
		act.build().perform();

		Thread.sleep(5000);
		act.moveToElement(e2);
		act.build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li/a[text()='B/L Search']")).click();
		Set<String> handles=driver.getWindowHandles();
		for(String s:handles){
			
			String s1=driver.switchTo().window(s).getTitle();
			if(s1.contains("MOLJTY - Bill of Lading - Search (OPBLW01)")){
				driver.switchTo().window(s);
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());
				break;
			}
		}
		
		
		driver.findElement(By.xpath("//input[@id='radBlNo']")).click();
		driver.findElement(By.xpath("//textarea[@id='txtBlSlNo']")).sendKeys("18000047390");
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='gridAction']")).click();
		driver.findElement(By.xpath("(//div[text()='Edit B/L'])[2]")).click();
		
		Set<String> handles2=driver.getWindowHandles();
		for(String s:handles2){
			
			String s1=driver.switchTo().window(s).getTitle();
			if(s1.contains("MOLJTY - Create/Modify Bill of Lading(OPBLW03)")){
				driver.switchTo().window(s);
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());
				break;
			}
		}
		Thread.sleep(5000);

		driver.findElement(By.xpath("//textarea[@id='txtMksNos']")).sendKeys("test data");
	}

}
