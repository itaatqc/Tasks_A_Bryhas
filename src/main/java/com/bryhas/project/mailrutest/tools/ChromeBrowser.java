package com.bryhas.project.mailrutest.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Andrew
 *
 */

public class ChromeBrowser implements IBrowser {

	public WebDriver getWebDriver() {
		return new ChromeDriver();
	}

	public String getWebDriverName() {
		return this.getClass().getName();
	}

	public void quit() {
	}

}
