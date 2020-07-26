package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2 extends TestBase {

	@Test
	public void clickGmail() {
		try {
			launchGoogle();
			Assert.assertTrue(driver.getTitle().equals("Google1"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

}
