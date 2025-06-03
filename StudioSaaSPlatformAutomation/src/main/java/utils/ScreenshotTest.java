package utils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ScreenshotTest {
	public static boolean compareScreenshot(WebDriver driver, WebElement element, String expectedImagePath, String diffImagePath) throws IOException {
	        // Load expected image
	        BufferedImage expectedImage = ImageIO.read(new File(expectedImagePath));
	        

	        // Capture actual screenshot of the element
	        Screenshot ImageScreenshot = new AShot().coordsProvider(new WebDriverCoordsProvider())
	                .shootingStrategy(ShootingStrategies.viewportPasting(1000)) // Full-page screenshot
	                .takeScreenshot(driver, element);

	        BufferedImage actualImage = ImageScreenshot.getImage();

	        // Compare images
	        ImageDiffer imgDiff = new ImageDiffer();
	        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);

	        // If images are different, save the difference image
	        if (diff.hasDiff()) {
	            ImageIO.write(diff.getMarkedImage(), "PNG", new File(diffImagePath));
	            System.out.println("Images are different! Check " + diffImagePath);
	            return false;
	        } else {
	            System.out.println("Images match!");
	            return true;
	        }
	    }
	}

