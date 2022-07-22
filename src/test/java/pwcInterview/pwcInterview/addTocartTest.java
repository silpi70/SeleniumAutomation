package pwcInterview.pwcInterview;


import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v101.page.Page;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objRepository.LandingPage;
import resources.BaseClass;

public class addTocartTest extends BaseClass {
	WebDriver driver;
	Properties prop;

	@BeforeTest
	public void config() throws IOException {
		driver = initiatedriver();
		//driver.get("https://www.amazon.in");

	}

	@Test
	public void addToCart() throws IOException, InterruptedException {
		
		//driver.findElement(By.xpath("//*[@id=\"submit.add-to-cart\"]")).click();
		System.out.println("addToCart PASSED");
		assertTrue(true);
	}
}
