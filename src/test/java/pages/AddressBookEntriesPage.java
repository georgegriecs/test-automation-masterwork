package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressBookEntriesPage extends BasePage {

  @FindBy (xpath = "//*[@id=\"content\"]/div/div[2]/a")
  WebElement newAddressButton;

  public AddressBookEntriesPage( WebDriver driver) {
    super(driver, AddressBookPage.class);
  }

  public WebElement getNewAddressButton() {
    return newAddressButton;
  }
}
