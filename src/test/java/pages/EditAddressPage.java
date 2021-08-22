package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAddressPage extends BasePage {
  public EditAddressPage(WebDriver driver) {super(driver, HomePage.class);}

  @FindBy (xpath = "//*[@id=\"content\"]/form/div/div[2]/input")
  WebElement continueButton;

  @FindBy ( id="input-firstname")
  WebElement firstName;

  @FindBy ( id = "input-lastname")
  WebElement lastName;

  @FindBy ( xpath = "//*[@id=\"account-address\"]/div[1]")
  WebElement updateMessage;

  public void saveEditedItem() {
    continueButton.click();
  }

  public WebElement getContinueButton(){
    return continueButton;
  }

  public void updateFirstName( String text ) {
    LOG.info("FirstName mezo update: " + text );
    firstName.clear();
    firstName.sendKeys( text );
    makeScreenshot();
    LOG.info("Kepernyokep keszites");
    continueButton.click();
  }

  public String getFirstNameText() {
    String value = firstName.getAttribute("value");
    LOG.info("First Name mezo tartalma: " + value);
    return value;
  }

}
