package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressBookPage extends BasePage {

  @FindBy( xpath = "//*[@id=\"content\"]/form/div/div[2]/input")
  WebElement countinueButton;

  @FindBy(id = "firstname")
  WebElement firstName;

  @FindBy(id = "lastname")
  WebElement lastName;

  @FindBy(id = "company")
  WebElement company;

  @FindBy(id = "address_1")
  WebElement addressOne;

  @FindBy(id = "address_2")
  WebElement addressTwo;

  @FindBy(id = "city")
  WebElement city;

  @FindBy(id = "postcode")
  WebElement postcode;

  @FindBy(id = "input-country")
  WebElement countrySelect;

  @FindBy(id = "input-zone")
  WebElement ZoneSelect;



  public AddressBookPage( WebDriver driver) {
    super(driver, AddressBookPage.class);
  }

  public WebElement getCountinueButton() {
    return countinueButton;
  }

  
}
