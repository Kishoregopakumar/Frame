package stepdefinitions;

import com.factory.DriverFactory;
import com.pages.FirstPage;
import com.pages.SecondPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstPageSteps {
	private static String title;
	private FirstPage firstPage = new FirstPage(DriverFactory.getDriver());
	private SecondPage secondPage;
	

@Given("user filled all required fields")
public void user_filled_all_required_fields() {
		DriverFactory.getDriver()
		.get("https://income.activequote.com/Cover");
	firstPage.handleCookiePopup();
    firstPage.clickOnAccidentAndSickness();
    firstPage.clickOnYourIncome();
    firstPage.clickOnUtilRetirementAge();
}

@When("user enters retirement age {string}")
public void user_enters_retirement_age(String retirement) {
    
	firstPage.enterExpectedRetirement(retirement);  
}

@When("user enters income {string}")
public void user_enters_income(String income) {
 
	firstPage.enterAnnualIncome(income);
}

@When("user clicks on continue button")
public void user_clicks_on_continue_button() {
	firstPage.clickOnContinue();
}

@Then("user navigates to next Page")
public void user_navigates_to_next_page() {
	title = firstPage.getFristPageTitle();
	System.out.println("Page title is: " + title);
}

}