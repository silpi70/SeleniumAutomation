package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriver initiatedriver() throws IOException {
	    prop=new Properties();
		FileInputStream fs=new FileInputStream("C:\\Users\\SILPI\\eclipse-workspace\\pwcInterview\\src\\main\\java\\resources\\data.properties");
		prop.load(fs);
		
		String browser=prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SILPI\\OneDrive\\Desktop\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
			
			driver=new ChromeDriver();
			System.out.println("Chrome");
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			System.out.println("firefox");
			
		}
		else if (browser.equalsIgnoreCase("IE")) {
			System.out.println("IE");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		return driver;
		
	}
	
	

}
