package com.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstPage {
	private WebDriver driver;
	// 1. By Locators:
		private By btn_AccidentAndSickness_loc = By.xpath("//span[text()='Accident and Sickness']");
		private By btn_cookiesAccept_loc = By.id("CybotCookiebotDialogBodyButtonAccept");
		private By btn_YourIncome_loc = By.xpath("//span[text()='Your Income']");
		private By btn_UtilRetirementAge_loc = By.xpath("//span[text()='Until Retirement Age']");
		private By txt_ExpectedRetire_loc = By.id("RetirementAge");
		private By txt_AnnualIncome_loc = By.id("salary");
		private By btn_Continue_loc = By.xpath("//span[@class='button-loader']");
		
		
		public FirstPage(WebDriver driver) {
			this.driver = driver;
		}


		public String getFristPageTitle() {
			return driver.getTitle();
		}
		public void handleCookiePopup() {
		    try {
		        WebElement cookiePopup = driver.findElement(By.id("CybotCookiebotDialogBodyButtonAccept"));
		        WebElement acceptButton = driver.findElement(By.id("CybotCookiebotDialogBodyButtonAccept"));
		        if (cookiePopup.isDisplayed()) {
		            acceptButton.click();
		            System.out.println("Cookie popup accepted.");
		        }
		    } catch (NoSuchElementException e) {
		        System.out.println("No cookie popup displayed.");
		    }
		}
		public void clickOnAccidentAndSickness() {
			driver.findElement(btn_AccidentAndSickness_loc).click();
		}
		public void clickOnYourIncome() {
			driver.findElement(btn_YourIncome_loc).click();
		}
		public void clickOnUtilRetirementAge() {
			driver.findElement(btn_UtilRetirementAge_loc).click();
		}
		public void enterExpectedRetirement(String retirement) {
			driver.findElement(txt_ExpectedRetire_loc).sendKeys(retirement);
		}
		public void enterAnnualIncome(String income) {
			driver.findElement(txt_AnnualIncome_loc).sendKeys(income);
		}
		public void clickOnContinue() {
			driver.findElement(btn_Continue_loc).click();
		}
		
		public SecondPage doQuote(String rtm, String inc) {
			System.out.println("quote with: " + rtm + " and " + inc);
			driver.findElement(btn_AccidentAndSickness_loc).click();
			driver.findElement(btn_YourIncome_loc).click();
			driver.findElement(btn_UtilRetirementAge_loc).click();
			driver.findElement(txt_ExpectedRetire_loc).sendKeys(rtm);
			driver.findElement(txt_AnnualIncome_loc).sendKeys(inc);
			driver.findElement(btn_Continue_loc).click();
			return new SecondPage(driver);
		
		
		

}
}
