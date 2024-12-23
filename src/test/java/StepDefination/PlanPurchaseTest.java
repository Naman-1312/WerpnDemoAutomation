package StepDefination;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import Messages.LoginPageMessages;
import PageObjects.BaseClass;
import PageObjects.PurchasePage;
//import PageObjects.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlanPurchaseTest {

	private BaseClass baseClass;
	private PurchasePage pp;
	private LoginPageMessages lpg;
//	private RegistrationPage rpg;
	
	@Given("User is on Membership Plan Page")
	public void user_is_on_membership_plan_page() {
		baseClass = new BaseClass();
		baseClass.setupBrowser("Chrome");
		baseClass.openUrl();
		pp = new PurchasePage(baseClass.getDriver());
	}

	@When("User select a plan and click on ApplyNow button")
	public void user_select_a_plan_and_click_on_apply_now_button() {
	 pp.clickApplyNowBtn();
	 pp.clickYesBtn();
	
	}

	@When("User select a payment option and click on Add to cart button")
	public void user_select_a_payment_option_and_click_on_add_to_cart_button() {
	//    pp.clickPaymentRadioBtn();
	    pp.clickAddToCartBtn();
	}

	@When("User click on Proceed to checkout button")
	public void user_click_on_proceed_to_checkout_button() {
	    pp.clickProceedToCheckOutBtn();
	}

	@When("User fill all the personal informations {string},{string},{string},{string},{string} and {string}")
	public void user_fill_all_the_personal_informations_and(String firstName, String lastName, String personalEmail, String homePhone, String mobilePhone, String DOB) {
	    pp.enterFirstName(firstName);
	    pp.enterLastName(lastName);
	    pp.enterEmailId(personalEmail);
	    pp.enterHomePhoneNumber(homePhone);
	    pp.enterMobilePhoneNumber(mobilePhone);
	    pp.enterDOB(DOB);
	   
	}

	@When("User fill all the mailing details {string},{string},{string},{string},{string} and {string}")
	public void user_fill_all_the_mailing_details_and(String streetAddress, String apartment, String city, String state, String country, String postalCode) {
	    pp.enterStreetAdressField(streetAddress);
	    pp.enterApartment(apartment);
	    pp.enterCity(city);
	    pp.selectState(state);
	    pp.selectCountry(country);
	    pp.enterPostalCode(postalCode);
	
	}

	@When("User fill all the Employement Information {string}, {string}, {string}, {string} and {string}")
	public void user_fill_all_the_employement_information_and(String graduationDate, String cnoNumber, String work, String union, String sector) {
	   pp.selectGraduationDate(graduationDate);
	   pp.enterCNONumber(cnoNumber);
	   pp.selectAccountWorking(work);
	   pp.selectUnionDD(union);
	   pp.selectSectorDD(sector);
	   pp.checkSameAsMailingAddress();
	   
	}

	@When("User click on Placeorder button")
	public void user_click_on_placeorder_button() {
	   pp.clickPlaceOrderBtn();
	}


	/*@Then("I verify the alert message for the invalid credentials")
	public void i_verify_the_alert_message_for_the_invalid_credentials() {
		String actualMessage = login.checkInvalidUserNameErrorMsg();
	    String expectedMessage = lpg.blankPasswordErrorMessage();
	    assertEquals(expectedMessage , actualMessage);
	    baseClass.tearDown();
	}
	*/
	
}
