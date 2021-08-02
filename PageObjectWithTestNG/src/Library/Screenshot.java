package Library;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	public static String takeScreenshot(WebDriver driver,String ScreenShot)
	{
		String destination="";
		try
		{
			File shot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			destination = System.getProperty("C:/Users/srinath/Muhil Workspace/PageObjectWithTestNG") + "/FailedTestsScreenshots/"+ScreenShot+".png";

			FileUtils.copyFile(shot,new File(destination));
		}
		catch(Exception e)
		{
			System.out.println("Cannot taken ScreenShot "+e.getMessage());
			e.printStackTrace();
		}
		return destination;
	}

}
