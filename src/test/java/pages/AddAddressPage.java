package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class AddAddressPage extends BasePage {
  public AddAddressPage(WebDriver driver) {
    super(driver, AddressBookPage.class);
  }

  @FindBy(id = "input-firstname")
  WebElement firstName;

  @FindBy(id = "input-lastname")
  WebElement lastName;

  @FindBy(id = "input-company")
  WebElement company;

  @FindBy(id = "input-address-1")
  WebElement addressOne;

  @FindBy(id = "input-address-2")
  WebElement addressTwo;

  @FindBy(id = "input-city")
  WebElement city;

  @FindBy(id = "input-postcode")
  WebElement postcode;

  @FindBy(id = "input-country")
  WebElement countrySelect;

  @FindBy(id = "input-zone")
  WebElement zoneSelect;

  @FindBy( xpath = "//*[@id=\"content\"]/form/div/div[2]/input")
  WebElement submitButton;

  @FindBy( tagName = "tr" )
  List<WebElement> addressItems;

  @FindBy( xpath = "//*[@id=\"column-right\"]/div/a[13]")
  WebElement logoutMenu;

  public void  uploadBookData(
    String firstName, String lastName,  String company, String addressOne,
    String addressTwo, String city, String postcode, String country, String region) {
    this.firstName.sendKeys(firstName);
    this.lastName.sendKeys(lastName);
    this.company.sendKeys(company);
    this.addressOne.sendKeys(addressOne);
    this.addressTwo.sendKeys(addressTwo);
    this.city.sendKeys(city);
    this.postcode.sendKeys(postcode);
    Select selectCountry = new Select(this.countrySelect);
    selectCountry.selectByVisibleText(country);

    Select selectZone = new Select(this.zoneSelect);
    wait.until(ExpectedConditions.textToBePresentInElement(this.zoneSelect, region));
    selectZone.selectByVisibleText(region);
  }

  public WebElement getSubmitButton() {
    return submitButton;
  }

  public int getBookAddressItemCount() {
    return addressItems.size();
  }

  public WebElement getLogoutMenu() {
    return logoutMenu;
  }
}
