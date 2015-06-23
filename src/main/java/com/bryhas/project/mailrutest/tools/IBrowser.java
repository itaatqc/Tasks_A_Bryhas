package com.bryhas.project.mailrutest.tools;

import org.openqa.selenium.WebDriver;

/**
 * @author Andrew
 *
 */

public interface IBrowser {

	WebDriver getWebDriver();

	String getWebDriverName();

	void quit();

}
