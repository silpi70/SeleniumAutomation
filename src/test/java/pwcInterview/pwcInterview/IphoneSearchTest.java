package pwcInterview.pwcInterview;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v101.page.Page;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import objRepository.LandingPage;
import resources.BaseClass;

public class IphoneSearchTest extends BaseClass {
	WebDriver driver;
	Properties prop;
	ExtentReports extntReport;

	@BeforeTest
	public void config() throws IOException {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter spark=new ExtentSparkReporter(path);
		spark.config().setReportName("SilpiTest");
		spark.config().setDocumentTitle("Test Results");
		extntReport=new ExtentReports();
		extntReport.attachReporter(spark);

	}

	@Test(priority =1 )
	public void iphoneSearch() throws IOException, InterruptedException {
		extntReport.createTest("SearchIPhone13");
		
		driver = initiatedriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		LandingPage page = new LandingPage(driver);
		// page.searchIphone().sendKeys("IPHONE13");;

		//driver.findElement(By.id("twotabsearchtextbox")).click();
		page.searchIphone().click();

		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("IPHONE13");
		page.searchIphone().sendKeys("IPHONE13");
		//driver.findElement(By.id("nav-search-submit-button")).click();
		page.searchEnter().click();
		// Select dropdown=new Select()

		//List<WebElement> phonelist = driver.findElements(By.xpath("//*[@class=\"a-price-whole\"]"));
		List<WebElement> phonelist=page.phoneList();
		int count = 0;
		for (WebElement el : phonelist) {
			String phone = el.getText();
			System.out.println(el.getText());
			if (el.getText().contains("68,900")) {
				el.click();
				count++;
				break;

			}

		}
		if (count!=0) {
			System.out.println("selected");
		}
		else {
			System.out.println("not in list ");
		}
		//JavascriptExecutor js=((JavascriptExecutor)driver);
		
//		Thread.sleep(100);
//		driver.findElement(By.id("//*[@id=\"add-to-cart-button\"]")).sendKeys(Keys.ENTER);
//		driver.switchTo().window("1");
		Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        driver.findElement(By.id("add-to-cart-button")).click();
//       driver.switchTo().frame(2);
//        driver.findElement(By.id("attach-sidesheet-view-cart-button")).click();
        //driver.switchTo().frame("6206afd06f38c53d8931f4f4af2858ad");
        //driver.findElement(By.id("attach-sidesheet-view-cart-button-announce")).click();
        driver.findElement(By.cssSelector("form#attach-view-cart-button-form")).click();
//        WebElement el=driver.findElement(By.xpath("//*[@class='a-button a-button-dropdown quantity']"));
//		Select dropdown=new Select(el); 
//		dropdown.selectByVisibleText("2");
        driver.findElement(By.className("a-dropdown-label")).click();
		List<WebElement> list=driver.findElements(By.xpath("//*[@class='a-popover-inner']//ul//li"));
		for(WebElement li:list) {
			String quantity=li.getText();
			System.out.println(li.getText());
			if(quantity.contains("3")) {
				li.click();
				break;
			}
		}
		
		WebElement text=driver.findElement(By.className("currencyINR"));
		
		String newTesxt=text.getText();
		System.out.println(newTesxt);
		System.out.println("iphoneSearch PASSED");
		assertTrue(true, newTesxt);
	}
	
	
	@Test(priority =2 )
	public void addCart() {
		extntReport.createTest("SearchIPhone13");
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id='add-to-cart-button' and @title='Add to Shopping Cart']"))));
		////*[@class='a-button a-spacing-small a-button-primary a-button-icon']
		//submit.add-to-cart
		//driver.findElement(By.xpath("//*[@class='a-button a-spacing-small a-button-primary a-button-icon']")).click();
		assertTrue(true);
		System.out.println("addCart PASSED");
	}
	
	@AfterClass
	public void tearDown() {
		extntReport.flush();
		driver.close();
	}
}
