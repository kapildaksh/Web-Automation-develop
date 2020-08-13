package com.prenetics.common.utility.browser;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LocalStorage {

    private static final Logger logger = Logger.getLogger(LocalStorage.class);

    private JavascriptExecutor js;

    public LocalStorage(WebDriver webDriver) {
        this.js = (JavascriptExecutor) webDriver;
    }

    public void clearLocalStorage() {
        logger.info("clearLocalStorage :: ");
        js.executeScript(String.format("window.localStorage.clear();"));
    }

    public String getItemFromLocalStorage(String key) {
        return (String) js.executeScript(String.format(
                "return window.localStorage.getItem('%s');", key));
    }

    public String getKeyFromLocalStorage(int key) {
        return (String) js.executeScript(String.format(
                "return window.localStorage.key('%s');", key));
    }

    public Long getLocalStorageLength() {
        return (Long) js.executeScript("return window.localStorage.length;");
    }

    public boolean isItemPresentInLocalStorage(String item) {
        return !(js.executeScript(String.format(
                "return window.localStorage.getItem('%s');", item)) == null);
    }

    public void removeItemFromLocalStorage(String item) {
        js.executeScript(String.format(
                "window.localStorage.removeItem('%s');", item));
    }

    public void setItemInLocalStorage(String item, String value) {
        js.executeScript(String.format(
                "window.localStorage.setItem('%s','%s');", item, value));
    }
}

