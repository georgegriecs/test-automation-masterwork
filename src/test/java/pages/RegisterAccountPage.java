package pages;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterAccountPage extends BasePage{

  @FindBy(id = "input-firstname")
  WebElement firstNameField;

  @FindBy(id = "input-lastname")
  WebElement lastNameField;

  @FindBy(id = "input-email")
  WebElement emailField;

  @FindBy(id = "input-telephone")
  WebElement telephoneField;

  @FindBy(id = "input-password")
  WebElement passwordField;

  @FindBy(id = "input-confirm")
  WebElement passwordConfirmField;

  @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")
  WebElement subscribeNoRadioButton;

  @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")
  WebElement subscribeYesRadioButton;

  @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[1]")
  WebElement privacyPolicyCheckBox;

  @FindBy( xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
  WebElement countinueButton;

  public RegisterAccountPage(WebDriver driver) {
    super(driver, RegisterAccountPage.class);
  }

  public void registerNewCustomer( String firstName, String lastName, String email, String telephone, String password) {
    firstNameField.sendKeys(firstName);
    LOG.info("First name: " + firstName);
    lastNameField.sendKeys(lastName);
    LOG.info("Last name: " + lastName);
    emailField.sendKeys(email);
    LOG.info("Email: " + email);
    telephoneField.sendKeys(telephone);
    LOG.info("Telephone: " + telephone);
    passwordField.sendKeys(password);
    LOG.info("Password: " + password);
    passwordConfirmField.sendKeys(password);
    LOG.info("Confirm password: " + password);
    makeScreenshot();
    LOG.info("Take screenshot");
    privacyPolicyCheckBox.click();
    LOG.info("Set to privacy policy checkbox");
    countinueButton.click();
    LOG.info("Click to continue button");
  }


}



