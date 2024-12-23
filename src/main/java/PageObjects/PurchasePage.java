package PageObjects;

import java.time.Duration;
//import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchasePage {

	private WebDriverWait wait;
	private WebDriver driver;
	

	public PurchasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(80));
	}



	// Locator methods

	private WebElement getApplyNowBtn() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Apply now'])[1]")));
	}
	
	private WebElement getYesBtn() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Yes'])[1]")));
	}
	
	private WebElement getNoBtn() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='No'])[1]")));
	}
	
	private WebElement paymentRadioBtn() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='qty'])[1]")));
	}
	
	private WebElement addToCartBtn() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Add to cart']")));
	}
	
	private WebElement proceedToCheckoutBtn() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://werpnmembers.108.tips/checkout/']")));
	}
	
	private WebElement firstNameField() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("first_name")));
	}
	
	public void enterFirstName(String firstName) {
		WebElement firstNameField = firstNameField();
		firstNameField.sendKeys(firstName);
	}
	
	
	private WebElement lastNameField() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("last_name")));
	}
	
	public void enterLastName(String lastName) {
		WebElement lastNameField = lastNameField();
		lastNameField.sendKeys(lastName);
	}
	
	
	private WebElement personalEmailField() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("account_email")));
	}
	
	public void enterEmailId(String email) {
		WebElement personalEmailField = personalEmailField();
		personalEmailField.sendKeys(email);
	}
	
	private WebElement homePhoneField() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("account_home_phone")));
	}
	
	public void enterHomePhoneNumber(String hPhone) {
		WebElement homePhoneField = homePhoneField();
		homePhoneField.sendKeys(hPhone);
	}
	
	private WebElement mobilePhoneField() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("account_mobile_phone")));
	}
	
	public void enterMobilePhoneNumber(String mPhone) {
		WebElement mobilePhoneField = mobilePhoneField();
		mobilePhoneField.sendKeys(mPhone);
	}
	
	private WebElement dobField() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("account_dob")));
	}
	
	public void enterDOB(String dob) {
		WebElement dobField = dobField();
		dobField.sendKeys(dob);
	}
	
	private WebElement selectNoRadioBtn() {
return wait.until(ExpectedConditions.
elementToBeClickable(By.xpath("//*[text()=\"NO, I do not agree to receive email messages from WeRPN\"]")));
	}
	
	public void clickNoRadioBtn() {
		WebElement noRadioBtn = selectNoRadioBtn();
		noRadioBtn.click();
	}

	
	public void clickApplyNowBtn() {
		WebElement applyBtn = getApplyNowBtn();
		applyBtn.click();
	}
	
	public void clickYesBtn() {
		WebElement yesBtn = getYesBtn();
		yesBtn.click();
	}
	
	public void clickNoBtn() {
		WebElement noBtn = getNoBtn();
		noBtn.click();
	}
	
	public void clickPaymentRadioBtn() {
		WebElement paymentRadioBtn = paymentRadioBtn();
		paymentRadioBtn.click();
	}
	
	public void clickAddToCartBtn() {
		WebElement addToCartBtn = addToCartBtn();
		addToCartBtn.click();
	}
	
	public void clickProceedToCheckOutBtn() {
		WebElement pcdBtn = proceedToCheckoutBtn();
		pcdBtn.click();
	}

	private WebElement streetAddressField() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("mailing_address_1")));
	}
	
	public void enterStreetAdressField(String streetAddress) {
		WebElement streetAddressField = streetAddressField();
		streetAddressField.sendKeys(streetAddress);
	}
	
	private WebElement apartmentField() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("mailing_address_2")));
	}
	
	public void enterApartment(String streetAddress) {
		WebElement streetAddressField = apartmentField();
		streetAddressField.sendKeys(streetAddress);
	}
	
	private WebElement cityField() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("mailing_city")));
	}
	
	public void enterCity(String city) {
		WebElement streetAddressField = cityField();
		streetAddressField.sendKeys(city);
	}
	
	private WebElement stateField() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("mailing_state")));
	}
	
	public void selectState(String state) {
		WebElement streetAddressField = stateField();
		streetAddressField.sendKeys(state);
	}
	
	private WebElement countryField() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("mailing_country")));
	}
	
	public void selectCountry(String country) {
		WebElement streetAddressField = countryField();
		streetAddressField.sendKeys(country);
	}
	
	private WebElement postalCodeField() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("mailing_postcode")));
	}
	
	public void enterPostalCode(String postalCode) {
		WebElement streetAddressField = postalCodeField();
		streetAddressField.sendKeys(postalCode);
	}
	
    private WebElement accountWorkingCodeDropdown() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("account_working_code")));
    }
    
    public void selectAccountWorking(String workType) {
        WebElement dropdown = accountWorkingCodeDropdown(); 
        Select select = new Select(dropdown); 
        select.selectByVisibleText(workType); 
    }
    
	private WebElement graduationDateField() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("account_graduation_date")));
	}
	
	public void selectGraduationDate(String graduationDate) {
		WebElement streetAddressField = graduationDateField();
		streetAddressField.sendKeys(graduationDate);
	}
	
	private WebElement cnoNumberField() {
		return wait.until(ExpectedConditions.elementToBeClickable(By.id("account_cno_number")));
	}
	
	public void enterCNONumber(String cnoNumber) {
		WebElement streetAddressField = cnoNumberField();
		streetAddressField.sendKeys(cnoNumber);
	}
	
    private WebElement unionDropDown() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("account_union_affliation")));
    }
    
    public void selectUnionDD(String unionValue) {
        WebElement dropdown = unionDropDown(); 
        Select select = new Select(dropdown); 
        select.selectByVisibleText(unionValue); 
    }	
	
    private WebElement sectorDropDown() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("account_sector_field")));
    }
    
    public void selectSectorDD(String sector) {
        WebElement dropdown = sectorDropDown(); 
        Select select = new Select(dropdown); 
        select.selectByVisibleText(sector); 
    }	
		
    private WebElement sameCheckbox() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("billing_mailing")));
    }
    
    public void checkSameAsMailingAddress() {
    	WebElement pcdBtn = sameCheckbox();
		pcdBtn.click();
    }
    
    private WebElement placeOrderBtn() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("place_order")));
    }
    
    public void clickPlaceOrderBtn() {
    	WebElement pcdBtn = placeOrderBtn();
		pcdBtn.click();
    }
    
    
	
	
	
	

	
}


