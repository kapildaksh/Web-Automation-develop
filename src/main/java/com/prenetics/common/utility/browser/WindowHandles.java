package com.prenetics.common.utility.browser;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowHandles {

    WebDriver driver;

    public WindowHandles(WebDriver driver) {

        this.driver = driver;
    }

    public void closeWindow() {
        driver.close();
    }

    public String getCurrentWindowSession() {

        String currentWindowSession;
        currentWindowSession = driver.getWindowHandle();
        return currentWindowSession;

    }

    public int getTotalWindowCount() {

        int windowsCount = 0;
        Set<String> totalWindows = driver.getWindowHandles();
        windowsCount = totalWindows.size();
        return windowsCount;
    }

    public void switchToLastWindow() {

        Set<String> totalWindows = driver.getWindowHandles();
        for (String window : totalWindows) {
            driver.switchTo().window(window);

        }
    }

    public void switchToWindow(String windowSession) {

        driver.switchTo().window(windowSession);
    }

}
