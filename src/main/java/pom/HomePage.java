package pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	@FindBy(xpath="//a[@class='header__icon header__icon--account link focus-inset small-hide']") private WebElement account;
	  @FindBy(xpath="//input[@id='CustomerEmail']") private WebElement email;
	  @FindBy(xpath="//input[@id='CustomerPassword']") private WebElement password;
	  @FindBy(xpath="//button[contains(text(),'Sign')]") private WebElement signIn;
	  @FindBy(xpath="//a[@id='HeaderMenu-home']") private WebElement home;
	  @FindBy(xpath="(//a[contains(text(),'Automation Product')])[1]") private WebElement product;
	  @FindBy(xpath="//div[@id='41775048228930_subscribe_purchase']") private WebElement widgetLanguage;
	  @FindBy(xpath="//input[@id='8929509442']") private WebElement frequency;
	  @FindBy(xpath="//span[@id='41775048228930_discount']") private WebElement discount;
	  @FindBy(xpath="//p[text()=' $36.00 USD']") private WebElement widgetPrice;
	  @FindBy(xpath="//span[@class='price-item price-item--sale price-item--last']") private WebElement productPrice;
	  @FindBy(xpath="//button[@class='search-modal__close-button modal__close-button link link--text focus-inset']") private WebElement buyNow;
	  @FindBy(xpath="//span[@class='_19gi7yt0 _19gi7yt10 _19gi7ytz _1fragemnw']") private WebElement payNow;
	
	  
	  public HomePage(WebDriver driver) { 
	  PageFactory.initElements(driver, this); } 
	  
	  public void clickAccount() {
	  account.click(); }
	  
	  public void enterEmail(String emailInput) { 
      email.sendKeys(emailInput); 
		  }
	  public void enterPassword(String passwordInput) {
	  password.sendKeys(passwordInput); 
	  }
	  public void clickSign() { 
		  signIn.click();
	   }
	  public void clickHome() { 
		  home.click();
	   }
	  public void clickProduct() { 
		  product.click();
	   }
	  public String checkLanguage(WebDriver driver) {
		  WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
			WebElement a=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[text()='Subscription Test'])[2]")));
			return  widgetLanguage.getText();
		  }
	  public void clickFrequency() { 
		  frequency.click();
	   }
	  public void clickSubscription() { 
		  widgetLanguage.click();
	   }
	  public String checkDiscount() {
		  return  discount.getText();
		  }
	  public String getWidgetPrice() {
		  return  widgetPrice.getText();
		  }
	  public String getProudctPrice() {
		  return  productPrice.getText();
		  }
	  public void scrollPage(WebDriver driver) { 
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  WebElement element = driver.findElement(By.xpath("//button[text()='Buy it now']"));
		  js.executeScript("arguments[0].scrollIntoView(true);", element);
	   }
	  
	  public void clickBuyNow(WebDriver driver) {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement buyNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Buy it now']")));
		  buyNowButton.click();
		}
	  public String getPayNowText(WebDriver driver) {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement buyNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Pay now']")));
		  return  buyNowButton.getText();
		  }
}