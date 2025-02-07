package stepdefinitions;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.factory.DriverFactory;
import com.pages.FirstPage;
import com.pages.SecondPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SecondPageSteps {
	private FirstPage firstPage = new FirstPage(DriverFactory.getDriver());
	private SecondPage secondPage;
	
	@Given("User landson to the user details form page")
	public void user_landson_to_the_user_details_form_page(DataTable credTable) {
		List<Map<String, String>> credList = credTable.asMaps();
		String rtm = credList.get(0).get("retirement");
		String inc = credList.get(0).get("income");

		DriverFactory.getDriver()
				.get("https://income.activequote.com/Cover");
		firstPage.handleCookiePopup();
		secondPage = firstPage.doQuote(rtm, inc);
	    
	}

	@When("user enter valid details in the user details form:")
	public void i_enter_valid_details_in_the_user_details_form(io.cucumber.datatable.DataTable dataTable) {
		secondPage.selectTitle();
		
		
		List<Map<String, String>> credList = dataTable.asMaps();
		String FirstName = credList.get(0).get("First Name");
		String LastName = credList.get(0).get("Last Name");
		String Day = credList.get(0).get("Day");
		String Month = credList.get(0).get("Month");
		String Year = credList.get(0).get("Year");
		String Email = credList.get(0).get("Email");
		String PhoneNumber = credList.get(0).get("PhoneNumber");
		String Postcode = credList.get(0).get("Postcode");
		
		secondPage.enterFirstName(FirstName);
		secondPage.enterLastName(LastName);
		secondPage.enterDobDay(Day);
		secondPage.enterDobMonth(Month);
		secondPage.enterDobYear(Year);
		secondPage.clickOnTobaccoNo();
		secondPage.enterEmail(Email);
		System.out.println("Extracted Phone Number: " + PhoneNumber);  // Debugging

	    if (PhoneNumber == null || PhoneNumber.trim().isEmpty()) {
	        System.out.println("Phone number is missing in test data!");
	    } else {
	        secondPage.enterPhoneNumber(PhoneNumber);
	    }
		secondPage.enterPostcode(Postcode);
		
	    
	}

	@When("user check the terms and conditions checkbox")
	public void i_check_the_terms_and_conditions_checkbox() {
	    secondPage.clickOnterms();
	    secondPage.clickOnOptinEmail();
	    
	}

	@When("user click on the Continue button")
	public void i_click_on_the_continue_button() {
	    secondPage.clickOnContinue();
	}

	@Then("User should be navigated to the quote results page")
	public void i_should_be_navigated_to_the_quote_results_page() {
	    // Write code here that turns the phrase above into concrete actions
	}
	@Then("user should see error messages")
    public void the_user_should_see_error_messages() {
		WebElement driver = null;
		// Locate the error message element
	    WebElement errorMessageElement = driver.findElement(By.id("EmailAddress-error"));

	    // Extract the text from the error message
	    String actualErrorMessage = errorMessageElement.getText();
	    String expectedErrorMessage = "Please enter a valid email address.";  

	    // Print the error message for debugging
	    System.out.println("Error message displayed: " + actualErrorMessage);

	    // Assert that the actual error message matches the expected message
	    Assert.assertEquals("Error message validation failed!", expectedErrorMessage, actualErrorMessage);
}
}
