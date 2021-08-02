
package TestCases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Library.BrowserLaunch;
import Library.Screenshot;
import Pages.HomePage;
import Pages.LoginPage;

public class LogintestCase{
	WebDriver driver;
	static ExtentReports extent;
	static ExtentTest test;
	HomePage hp;
	LoginPage lp;
	int i=0;
	
	@BeforeTest
	public void browserlaunch()
	{
		
		driver=BrowserLaunch.startBrowser();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        lp = new LoginPage(driver);
        hp = new HomePage(driver);
        extent=new ExtentReports(System.getProperty("C:\\Users\\srinath\\Muhil Workspace\\PageObjectWithTestNG\\test-output")+"\\Loginextentreport.html");
        extent.addSystemInfo("UserName","Muhil");
        extent.loadConfig(new File(System.getProperty("C:\\Users\\srinath\\Muhil Workspace\\PageObjectWithTestNG\\null")+"\\extent-config.xml"));
	}
	@Test(priority=1)
	public void login()
	{
		test=extent.startTest("login");
		lp.Logintosite("sri.com.com@gmail.com", "Srinath03");
		test.log(LogStatus.PASS, "LOGIN Test case Passed");
	}
	@Test(priority=2)
	public void logout()
	{
		test=extent.startTest("logout");
		hp.logout();
		test.log(LogStatus.PASS, "LOGOUT Test case Passed");
	}
	
	@AfterMethod
	public void screenshot(ITestResult result)
	{
		i=i+1;
		String name="ScreenShot";
		String x=name+String.valueOf(i)+result.getName();
        if(ITestResult.FAILURE == result.getStatus())
        {
                       String screenshotpath=Screenshot.takeScreenshot(driver, x);
                       test.log(LogStatus.FAIL, test.addScreenCapture(screenshotpath));
         }
	}
	@AfterTest
	public void closeBrowser()
	{
	driver.close();
	extent.flush();
	extent.close();
	}

}