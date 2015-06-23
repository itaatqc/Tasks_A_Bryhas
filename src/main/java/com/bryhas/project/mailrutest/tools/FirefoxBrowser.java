package com.bryhas.project.mailrutest.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Andrew
 *
 */

public class FirefoxBrowser implements IBrowser {

	public WebDriver getWebDriver() {
		return new FirefoxDriver();
	}

	public String getWebDriverName() {
		return this.getClass().getName();
	}

	public void quit() {
	}

}
