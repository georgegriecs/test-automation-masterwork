package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LogoutPage extends BasePage {
  public LogoutPage(WebDriver driver) {
    super(driver, LogoutPage.class);
  }

  @FindBy (xpath = "//*[@id=\"content\"]/div/div/a")
  WebElement continueButton;

  public WebElement getContinueButton(){
    return continueButton;
  }

}
