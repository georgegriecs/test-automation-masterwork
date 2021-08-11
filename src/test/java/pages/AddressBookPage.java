package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressBookPage extends BasePage {

  @FindBy( xpath = "//*[@id=\"content\"]/form/div/div[2]/input")
  WebElement countinueButton;

  public AddressBookPage( WebDriver driver) {
    super(driver, AddressBookPage.class);
  }

  public WebElement getCountinueButton() {
    return countinueButton;
  }

  public  void uploadBookData() {


  }
}
