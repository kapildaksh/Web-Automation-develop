package com.prenetics.common.utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

public class AShotScreenCapture {

	public File captureFullScreenShot(WebDriver driver) {

		File outputFile = null;
		File tempFolder = new File("temp");
		try {
			if (tempFolder.canWrite() == false) {
				tempFolder.mkdir();
			}

		} catch (SecurityException e) {

		}

		final Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(500))
				.takeScreenshot(driver);
		final BufferedImage image = screenshot.getImage();
		try {
			
			String time = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date().getTime());
			outputFile = new File("temp/" + time + ".png");
			ImageIO.write(image, "png", outputFile);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return outputFile;

	}

}