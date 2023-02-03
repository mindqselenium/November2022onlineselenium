package commonLibs.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.utils.FileUtil;

public class ScreenshotUtils {
	private TakesScreenshot camera;

	public ScreenshotUtils(WebDriver driver) {
		camera = (TakesScreenshot) driver;

	}

	public void captureandsavescreenshot(String filename) throws Exception {
		filename = filename.trim();
		File imgfile, tmpfile;
		imgfile = new File(filename);
		if (imgfile.exists()) {
			throw new Exception("File Already Exists");
		}
		tmpfile = camera.getScreenshotAs(OutputType.FILE);
		FileUtils.moveFile(tmpfile, imgfile);
	}

}
