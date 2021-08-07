package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLoginPage  extends BasePage {

  @FindBy( xpath = "//a[text()=\"Continue\"]"  )
  WebElement newCustomerButton;

  @FindBy( xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input"  )
  WebElement returnCustomerLoginButton;

  @FindBy( xpath = ""  )
  WebElement emailField;

  @FindBy( xpath = ""  )
  WebElement passwordField;

  @FindBy( xpath = ""  )
  WebElement warningMessageNoMatch;

  public AccountLoginPage(WebDriver driver ) {
    super(driver, AccountLoginPage.class  );
  }

  public void clickToNewCustomerButton() {
    newCustomerButton.click();
  }
}
