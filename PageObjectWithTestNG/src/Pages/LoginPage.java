package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LoginPage {
 WebDriver driver;
 JavascriptExecutor js=(JavascriptExecutor)driver;
 By Login=By.cssSelector("span[id='nav-link-accountList-nav-line-1']");
 By user=By.id("ap_email");
 By next=By.className("a-button-input");
 By pass=By.id("ap_password");
 By submit=By.id("signInSubmit");
 
 public LoginPage(WebDriver driver)
 {
	 this.driver=driver;
 }
 public void Logintosite(String username,String password)
 {
	 driver.findElement(Login).click();
	 this.enterName(username);
	 this.enterNext();
	 this.enterPass(password);
	 this.enterSubmit();
 }
 public void enterName(String username)
 {
	 driver.findElement(user).sendKeys(username);
 }
 public void enterNext()
 {
	 driver.findElement(next).click();
 }
 public void enterPass(String password)
 {
	// js.executeScript("arguments[0].value='password';", pass);
	 driver.findElement(pass).sendKeys(password);
 }
 public void enterSubmit()
 {
	 driver.findElement(submit).click();
 }
}
