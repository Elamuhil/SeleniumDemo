
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage{
	WebDriver driver;
	By list=By.xpath("//a[@id='nav-link-accountList']");
	By logout=By.xpath("//a[@id='nav-item-signout']");
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void logout()
	{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(list)).build().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(logout).click();
	}
}