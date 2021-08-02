package Library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunch {
	static WebDriver driver;
	public static WebDriver startBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\srinath\\Muhil Workspace\\browserdriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get( "http://Amazon.in");
		return driver;
		
	}

}
