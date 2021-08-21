package pages;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

  @FindBy( xpath = "//*[@id=\"content\"]/form/div/div/a" )
  WebElement privacyPolicyLink;

  @FindBy( xpath = "//button[@class=\"close\"]" )
  WebElement privacyPolicyCloseButton;

  @FindBy(xpath = "//*[@id=\"modal-agree\"]/div/div/div[2]")
  WebElement privacyPolicyModalWindow;

  @FindBy( xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
  WebElement countinueButton;

  @FindBy ( xpath = "//*[@id=\"account-register\"]/div[1]")
  WebElement WarningMessageEmailIsAlreadyIsRegistered;

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
    LOG.info("Kepernyokep keszites");
    privacyPolicyCheckBox.click();
    LOG.info("Az adatvedelmi iranyelvek jelolonegyzetre kattintunk");
    countinueButton.click();
    LOG.info("A folytatas gombra kattintva");
  }

  public String getWarningMessage() {
    return WarningMessageEmailIsAlreadyIsRegistered.getText();
  }

  public void clickToPrivacyPolicyCheckBox() {
    privacyPolicyCheckBox.click();
    wait.until(ExpectedConditions.elementToBeSelected(privacyPolicyCheckBox));
    LOG.info("Varakozas az adatvedelmi irányelvek jelolonegyzet kattinthatosagara");
  }

  public boolean getPrivacyPolicyState() {
    LOG.info("Privacy Policy CheckBox: " + privacyPolicyCheckBox.getAttribute("checked").equals("true"));
    return privacyPolicyCheckBox.getAttribute("checked").equals("true");
  }

  public void closePrivacyPolicyModalForm() {
    privacyPolicyCloseButton.click();
  }

  public void openPrivacyPolicy() {
    privacyPolicyLink.click();
    wait.until(ExpectedConditions.visibilityOf(privacyPolicyCloseButton));
    LOG.info("Privacy policy model window opened");
  }

  public String getPrivacyPolicyModalText() {
    return privacyPolicyModalWindow.getText();
  }

}



