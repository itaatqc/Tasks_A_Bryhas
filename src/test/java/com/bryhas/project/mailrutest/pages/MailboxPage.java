package com.bryhas.project.mailrutest.pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bryhas.project.mailrutest.tools.ContextVisible;
import com.bryhas.project.mailrutest.tools.WebDriverUtils;

/**
 * @author Andrew
 *
 */

public class MailboxPage {
	
	private WebElement mailRuLink;
	private WebElement mailTitle;
	private WebElement mailDate;
	private WebElement logout;
	
	public MailboxPage() {
		
		this.mailRuLink = ContextVisible.get().getVisibleWebElement(
				By.xpath("//tbody/tr/td[1]/a[1]"));
		this.mailTitle = ContextVisible.get().getVisibleWebElement(
				By.xpath(".//*[@id='b-letters']/div[2]/div[1]/div/div[2]/div[1]/div/a/div[4]/div[3]/div[1]"));
		this.mailDate = ContextVisible.get().getVisibleWebElement(
				By.xpath(".//*[@id='b-letters']/div[2]/div[1]/div/div[2]/div[1]/div/a/div[4]/div[1]/span"));
		this.logout = ContextVisible.get().getVisibleWebElement(
				By.id("PH_logoutLink"));
				
	}
	
	public LoggedInHomePage clickMailRuLink() {
		mailRuLink.click();
		return new LoggedInHomePage();
	}
	
	public MailRuHome logout() {
		this.logout.click();
		return new MailRuHome();
	}
	
	public WebElement getMailTitle() {
		return mailTitle;
	}
	
	public WebElement getMailDate() {
		return mailDate;
	}
	
	// resets table with e-mails
	public void resetTable() {
		
		boolean check = new WebDriverWait(
				WebDriverUtils.get().getWebDriver(),
				WebDriverUtils.get().getImplicitlyWaitTimeout())
			.until(ExpectedConditions
				.stalenessOf(this.mailTitle));
		
		System.out.println("++++++++++Start find, check = "+check);

		this.mailRuLink = ContextVisible.get().getVisibleWebElement(
				By.xpath("//tbody/tr/td[1]/a[1]"));
		this.mailTitle = ContextVisible.get().getVisibleWebElement(
				By.xpath(".//*[@id='b-letters']/div[2]/div[1]/div/div[2]/div[1]/div/a/div[4]/div[3]/div[1]"));
		this.mailDate = ContextVisible.get().getVisibleWebElement(
				By.xpath(".//*[@id='b-letters']/div[2]/div[1]/div/div[2]/div[1]/div/a/div[4]/div[1]/span"));
		this.logout = ContextVisible.get().getVisibleWebElement(
				By.id("PH_logoutLink"));
						
		} 
	
	public String getCurrentTime(){
		
		Date today = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("HH:mm");
		String currentTime = sdf.format(today);
		return currentTime;
		
	}
		
}
