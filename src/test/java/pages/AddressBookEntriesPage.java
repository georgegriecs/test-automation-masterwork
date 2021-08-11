package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressBookEntriesPage extends BasePage {

  @FindBy( xpath = "//*[@id=\"content\"]/div/div[2]/a")
  WebElement newAddressButton;

  @FindBy (xpath = "//*[@id=\"account-address\"]/div[1]/text()")
  WebElement successAddedNewAddressMessage;

  public AddressBookEntriesPage( WebDriver driver) {
    super(driver, AddressBookPage.class);
  }

  public WebElement getNewAddressButton() {
    return newAddressButton;
  }

  public WebElement getSuccessAddedNewAddressMessage() {
    return successAddedNewAddressMessage;
  }
}
