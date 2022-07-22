package objRepository;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	
	//nav-searchbar nav-progressive-attribute
	WebDriver driver;
	public  LandingPage (WebDriver driver) {
		this.driver=driver;
	}

	
	By search=By.id("twotabsearchtextbox");
	By searchEnter=By.id("nav-search-submit-button");
	By phoneList=By.xpath("//*[@class=\"a-price-whole\"]");
	
	public WebElement searchIphone() {
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(search)));
		return driver.findElement(search);
		
	}
	
	public WebElement searchEnter() {

		return driver.findElement(searchEnter);
		
	}
	
	public List<WebElement> phoneList() {

		return driver.findElements(phoneList);
		
	}
//public WebElement searchEnter() {
//		
//		return driver.findElement(searchEnter);
//		
//	}
//	
	
}
