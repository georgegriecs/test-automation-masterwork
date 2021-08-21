package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressBookEntriesPage extends BasePage {

  @FindBy( xpath = "//*[@id=\"content\"]/div/div[2]/a")
  WebElement newAddressButton;

  @FindBy (xpath = "//*[@id=\"account-address\"]/div[1]")
  WebElement successAddedNewAddressMessage;

  @FindBy ( xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr[1]/td[2]/a[2]")
  WebElement firstItemDeleteButton;

  @FindBy ( xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr[1]/td[2]/a[1]")
  WebElement firstItemEditButton;

  public AddressBookEntriesPage( WebDriver driver) {
    super(driver, AddressBookPage.class);
  }

  public WebElement getNewAddressButton() {
    return newAddressButton;
  }

  public WebElement getSuccessAddedNewAddressMessage() {
    return successAddedNewAddressMessage;
  }

  public void deleteFirstAddress(){
    firstItemDeleteButton.click();
  }

  public void editFirstAddress(){
    firstItemEditButton.click();
  }
}
