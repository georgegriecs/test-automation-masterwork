package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountLoginPage  extends BasePage {

  @FindBy( xpath = "//a[text()=\"Continue\"]"  )
  WebElement newCustomerButton;

  @FindBy( xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input" )
  WebElement returnCustomerLoginButton;

  @FindBy( id = "input-email"  )
  WebElement emailField;

  @FindBy( id = "input-password"  )
  WebElement passwordField;

  @FindBy( xpath = "//input[@type=\"submit\"]" )
  WebElement loginButton;

  @FindBy( xpath = "//*[@id=\"account-login\"]/div[1]"  )
  WebElement warningMessageNoMatch;

  public AccountLoginPage(WebDriver driver ) {
    super(driver, AccountLoginPage.class  );
  }

  public boolean isLoaded() {
    return isLoaded(loginButton);
  }

  public void clickToNewCustomerButton() {
    newCustomerButton.click();
  }

  public void loginReturningCustomer( String email, String password ) {
    emailField.sendKeys(email);
    LOG.info("email: " + email);
    passwordField.sendKeys(password);
    LOG.info("password: " + password);
    makeScreenshot();
    LOG.info("Képernyőkép készítés");
    loginButton.click();
    assertThat( driver.getTitle()).isEqualTo("My Account");
    makeScreenshot();
    LOG.info("Képernyőkép készítés");
  }

  public WebElement getWarningMessageNoMatchEmailOrPassword() {
    return warningMessageNoMatch;
  }

}
