package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalAccountPage extends BasePage {
  public PersonalAccountPage(WebDriver driver) {
    super(driver, PersonalAccountPage.class);
  }

  @FindBy ( xpath = "//*[@id=\"column-right\"]/div/a[4]")
  WebElement menuAddressBook;

  public WebElement getMenuAddressBook(){
    return menuAddressBook;
  }
}



