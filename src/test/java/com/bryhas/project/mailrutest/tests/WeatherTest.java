package com.bryhas.project.mailrutest.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bryhas.project.mailrutest.data.ILetter;
import com.bryhas.project.mailrutest.data.IUser;
import com.bryhas.project.mailrutest.data.LetterRepository;
import com.bryhas.project.mailrutest.data.UrlRepository.Urls;
import com.bryhas.project.mailrutest.data.UserRepository;
import com.bryhas.project.mailrutest.pages.LoggedInHomePage;
import com.bryhas.project.mailrutest.pages.MailboxPage;
import com.bryhas.project.mailrutest.pages.StartMailRuHome;
import com.bryhas.project.mailrutest.tools.BrowserRepository;
import com.bryhas.project.mailrutest.tools.IBrowser;
import com.bryhas.project.mailrutest.tools.SendMail;
import com.bryhas.project.mailrutest.tools.WebDriverUtils;

/**
 * @author Andrew
 *
 */
public class WeatherTest {
	
	public static final Logger LOG = Logger.getLogger(WeatherTest.class);

	@DataProvider
	public Object[][] testDataProvider() {
		return new Object[][] { {
				BrowserRepository.getFirefoxByTemporaryProfile(),
				//BrowserRepository.getChromeByTemporaryProfile(),
				Urls.GLOBAL_HOST.toString(),
				UserRepository.getTestUser(),
				LetterRepository.getTestLetter()}
		};
	}

	@Test(dataProvider = "testDataProvider")

	public void checkWeather(IBrowser browser, String url, IUser testUser, ILetter testLetter) {
		// Steps
		
		//load firefox, go to mail.ru and login
		MailboxPage mailboxPage = StartMailRuHome.load(browser, url)
				.successTestUserLogin(testUser);
		LOG.info("Mail.ru loaded, test user logged in.");
		
		//click Mail.Ru
		LoggedInHomePage loggedInHomePage = mailboxPage.clickMailRuLink();
		
		//get weather data and sent them to email
		SendMail.sendMailToInbox("Weather", (loggedInHomePage.getWeatherNowTemp().getText()+
				loggedInHomePage.getWeatherNearTemp().getText()+", "+
				loggedInHomePage.getWeatherTomorrowTemp().getText()));
		LOG.info("E-mail sent.");
		
		//click inbox
		loggedInHomePage.clickInbox();
		
		//reset e-mail table
		mailboxPage.resetTable();
		
		//check the letter title
		Assert.assertEquals(mailboxPage.getMailTitle().getText().substring(0, 7), 
				testLetter.getLetterTitle());
		
		// check if the letter time is in H:mm or HH:mm format
		if ((mailboxPage.getMailDate().getText().substring(1, 2))
				.equals(mailboxPage.getCurrentTime().substring(2, 3))){
					
			//check the letter time (Time is H:mm)
			Assert.assertEquals(mailboxPage.getMailDate().getText().substring(0, 3), 
					mailboxPage.getCurrentTime().substring(1, 4));
			LOG.info("E-mail checked.");
		} else {
						
			//check the letter time (Time is HH:mm)
			Assert.assertEquals(mailboxPage.getMailDate().getText().substring(0, 4), 
					mailboxPage.getCurrentTime().substring(0, 4));
			LOG.info("E-mail checked.");
		}	
				
		// Return to previous state
		mailboxPage.logout();
	}
		
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		WebDriverUtils.get().stop();
	}

}
