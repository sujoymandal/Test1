package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 extends TestBase{
	
	@Test
	public void getTitle(){
		try{
			launchGoogle();

		Assert.assertTrue(driver.getTitle().equals("Google"));
		
		}
		catch(Exception e){
			
		}
		finally {
			driver.quit();
		}
		
	}

}
