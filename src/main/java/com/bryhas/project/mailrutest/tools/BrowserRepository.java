package com.bryhas.project.mailrutest.tools;

/**
 * @author Andrew
 *
 */

public class BrowserRepository {

	public static IBrowser getFirefoxByTemporaryProfile() {
		return new FirefoxBrowser();
	}
	
	public static IBrowser getChromeByTemporaryProfile() {
		return new ChromeBrowser();
	}
}
