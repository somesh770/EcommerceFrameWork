package Utility_PACK;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenshotClass {

	public static void takeScreenshot(String Filename, WebDriver driver) throws IOException {
		TakesScreenshot TSS = (TakesScreenshot) driver;
		File filesource = TSS.getScreenshotAs(OutputType.FILE);

		File destination = new File(System.getProperty("user.dir") + "/screenshotFolder/" + Filename + ".png");

		FileHandler.copy(filesource, destination);

	}

}
