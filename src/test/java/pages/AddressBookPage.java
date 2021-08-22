package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressBookPage extends BasePage {
  public AddressBookPage( WebDriver driver) {
    super(driver, AddressBookPage.class);
  }

  @FindBy( xpath = "//*[@id=\"content\"]/form/div/div[2]/input")
  WebElement countinueButton;

  public WebElement getCountinueButton() {
    return countinueButton;
  }
}
