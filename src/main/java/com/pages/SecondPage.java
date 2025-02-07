package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SecondPage {
	private WebDriver driver;
	// 1. By Locators:
	        private By txt_Title_loc = By.xpath("//h1[@class='C' and text()='Income Protection']");
	        private By txt_ErrorSummary_loc= By.xpath("//span[@class='field-validation error summary']");
			private By dd_Title_loc = By.id("Title");
			private By txt_FirstName_loc = By.id("FirstName");
			private By txt_LastName_loc = By.id("LastName");
			private By txt_Day_loc = By.id("DateOfBirth_Day");
			private By txt_Month_loc = By.id("DateOfBirth_Month");
			private By txt_Year_loc = By.id("DateOfBirth_Year");
			private By btn_TobaccoYes_loc = By.xpath("(//label[@for='smoker-yes'])[2]");
			private By btn_TobaccoNo_loc = By.xpath("(//label[@for='smoker-no'])");
			private By txt_Email_loc = By.id("EmailAddress");
			private By txt_Phone_loc = By.id("PhoneNumber");
			private By txt_Postcode_loc = By.id("Postcode");
			private By btn_Terms_loc = By.id("TermsAndConditions");
			private By btn_ReceiveEmail_Yes_loc = By.id("optin");
			private By btn_ReceiveEmail_No_loc = By.id("optout");
			private By btn_Continue_loc = By.xpath("//span[@class='button-loader']");
			
		    public SecondPage(WebDriver driver) {
				this.driver = driver;
			}
		 

			public String getFristPageTitle() {
				return driver.getTitle();
			}
			
			public void selectTitle() {
				WebElement ddown = driver.findElement(dd_Title_loc);
				Select select = new Select(ddown);
				select.selectByVisibleText("Mr");
			}
			public void enterFirstName(String First) {
				driver.findElement(txt_FirstName_loc).sendKeys(First);
			}
			public void enterLastName(String Last) {
				driver.findElement(txt_LastName_loc).sendKeys(Last);
		
			}
			public void enterDobDay(String Day) {
				driver.findElement(txt_Day_loc).sendKeys(Day);
		
			}
			public void enterDobMonth(String Month) {
				driver.findElement(txt_Month_loc).sendKeys(Month);
		
			}
			public void enterDobYear(String year) {
				driver.findElement(txt_Year_loc).sendKeys(year);
		
			}
			public void clickOnTobaccoYes() {
				driver.findElement(btn_TobaccoYes_loc).click();
			}
			public void clickOnTobaccoNo() {
				driver.findElement(btn_TobaccoNo_loc).click();
			}
			public void enterEmail(String email) {
				driver.findElement(txt_Email_loc).sendKeys(email);
		
			}
			public void enterPhoneNumber(String phone) {
				driver.findElement(txt_Phone_loc).sendKeys(phone);
		
			}
			public void enterPostcode(String postcode) {
				driver.findElement(txt_Postcode_loc).sendKeys(postcode);
		
			}
			public void clickOnterms() {
				driver.findElement(btn_Terms_loc).click();
			}
			public void clickOnOptinEmail() {
				driver.findElement(btn_ReceiveEmail_Yes_loc).click();
			}
			public void clickOnOptoutEmail() {
				driver.findElement(btn_ReceiveEmail_No_loc).click();
			}
			public void clickOnContinue() {
				driver.findElement(btn_Continue_loc).click();
			}
			
				
			

}
