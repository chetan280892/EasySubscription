package pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerDashboard {
	  @FindBy(xpath="//a[@class='header__icon header__icon--account link focus-inset small-hide']") private WebElement account;
	  @FindBy(xpath="//input[@id='CustomerEmail']") private WebElement email;
	  @FindBy(xpath="//input[@id='CustomerPassword']") private WebElement password;
	  @FindBy(xpath="//button[contains(text(),'Sign')]") private WebElement signIn;
	  @FindBy(xpath="//a[contains(text(),'Manage Subscriptions')]") private WebElement manageSubscription;
	  @FindBy(xpath="//h1[text()='Subscription L1']") private WebElement language;
	  @FindBy(xpath="//button[text()='Update Payment Method Details  L34']") private WebElement updatePayment;
	  @FindBy(xpath="//button[text()='Send Email   L38']") private WebElement sendEmail;
	  @FindBy(xpath="//input[@value='choose']") private WebElement updateEmail;
	  @FindBy(xpath="(//div[@class='productImgStatusView'])[1]") private WebElement contract;
	  @FindBy(xpath="//h3[text()='Subscription   L2']") private WebElement language1;
	  @FindBy(xpath="//button[text()='Skip  L20']") private WebElement skip;
	  @FindBy(xpath="//button[@class='confirm']") private WebElement confirm;
	  @FindBy(xpath="//div[text()='Contract Skipped.']") private WebElement skipMsg;
	  @FindBy(xpath="//div[text()='Product Swapped.']") private WebElement swapMsg;
	  @FindBy(xpath="//button[text()='Swap  L24']") private WebElement swapButton;
	  @FindBy(xpath="//p[text()='50.00']") private WebElement swapPrice;
	  @FindBy(xpath="//span[text()='$45.0 USD']") private WebElement afterSwapPrice;
	  @FindBy(xpath="//button[@class='primary_btn']") private WebElement cancel;
	  @FindBy(xpath="//span[text()='Canceled  L9']") private WebElement canceled;
	  @FindBy(xpath="//button[text()='Active L3']") private WebElement active;
	  @FindBy(xpath="(//div[contains(@class, 'react-datepicker__day')])[30]") private WebElement date;
	  @FindBy(xpath="//button[text()='Apply']") private WebElement apply;
	  @FindBy(xpath="//p[contains(text(),'2025')]") private WebElement nextOrderDate;
	  @FindBy(xpath="//div[@class='subscription_product_list_container']") private WebElement customCSS;
	  @FindBy(xpath="(//div[contains(@class, 'react-datepicker__day')])[30]") private WebElement getdate;
		public CustomerDashboard(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		public WebElement waitForElementVisibility(WebDriver driver, By locator, int timeoutInSeconds) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}

		public void clickAccount() {
			account.click();
		}

		public void enterEmail(String emailInput) {
			email.sendKeys(emailInput);
		}

		public void enterPassword(String passwordInput) {
			password.sendKeys(passwordInput);
		}

		public void clickSign() {
			signIn.click();
		}

		public void clickManageButton() {
			manageSubscription.click();
		}

		public String checkLanguage() {
			return language.getText();
		}

		public void clickUpdatePaymentMethod() {
			updatePayment.click();
		}

		public void clickSendEmail() {
			sendEmail.click();
		}

		public void clickUpdateEmail() {
			updateEmail.click();
		}

		public void clickContract(WebDriver driver) {
			WebElement a = waitForElementVisibility(driver, By.xpath("(//div[@class='productImgStatusView'])[1]"), 5);
			a.click();
		}

		public String checkLanguage1() {
			return language1.getText();
		}

		public void clickSkip(WebDriver driver) {
			WebElement a = waitForElementVisibility(driver, By.xpath("//button[text()='Skip  L20']"), 5);
			a.click();
		}

		public String skipButtonText(WebDriver driver) {
			WebElement a = waitForElementVisibility(driver, By.xpath("//button[text()='Skip  L20']"), 5);
			return a.getText();
		}

		public void clickConfirm() {
			confirm.click();
		}

		public String skipMsg(WebDriver driver) {
			WebElement a = waitForElementVisibility(driver, By.xpath("//div[text()='Contract Skipped.']"), 5);
			return a.getText();
		}

		public String waitContract(WebDriver driver) {
			WebElement a = waitForElementVisibility(driver, By.xpath("//h1[text()='Subscription L1']"), 5);
			return a.getText();
		}

		public void clickSwap(WebDriver driver) {
			WebElement a = waitForElementVisibility(driver, By.xpath("//button[text()='Swap  L24']"), 5);
			a.click();
		}

		public String swapMsg(WebDriver driver) {
			WebElement a = waitForElementVisibility(driver, By.xpath("//div[text()='Product Swapped.']"), 10);
			return a.getText();
		}

		public String productAfterSwapping(WebDriver driver) {
			WebElement a = waitForElementVisibility(driver, By.xpath("//h2[text()='Automation Product-Bronze']"), 10);
			return a.getText();
		}

		public String swapPriceMsg() {
			return swapPrice.getText().replace("$", "");
		}

		public String afterSwapPriceMsg(WebDriver driver) {
			WebElement a = waitForElementVisibility(driver, By.xpath("//span[text()='$45.0 USD']"), 5);
			return a.getText().replace("$", "").replace(" USD", "").trim();
		}

		public void clickCancel(WebDriver driver) {
			WebElement a = waitForElementVisibility(driver, By.xpath("//button[@class='primary_btn']"), 5);
			a.click();
		}

		public String cancelledStatus(WebDriver driver) {
			WebElement a = waitForElementVisibility(driver, By.xpath("//span[text()='Canceled  L9']"), 5);
			return a.getText();
		}

		public void clickActive() {
			active.click();
		}

		public String beforeSkipOrderDate(WebDriver driver) {
			WebElement a = waitForElementVisibility(driver, By.xpath("(//div[@class='interval_lines'])[1]"), 5);
			return a.getText().substring(24, 34);
		}

		public String afterSkipOrderDate(WebDriver driver) {
			WebElement a = waitForElementVisibility(driver, By.xpath("(//div[@class='interval_lines'])[1]"), 5);
			return a.getText().substring(24, 34);
		}

		public void clickRescheduleButton(WebDriver driver) {
			WebElement a = waitForElementVisibility(driver, By.xpath("//button[text()='Reschedule L42']"), 5);
			a.click();
		}

		public void selectDate() {
			date.click();
		}

		public void clickApply() {
			apply.click();
		}

		public String orderRescheduleText(WebDriver driver) {
			WebElement a = waitForElementVisibility(driver, By.xpath("//div[text()='Order Rescheduled.']"), 5);
			return a.getText();
		}
		
		public String getColor() {
			return customCSS.getCssValue("color");
		}
		public String getSelectDate() {
			return getdate.getText();
		}
		
		public String getNextOrderDate() {
			return nextOrderDate.getText();
		}
	}