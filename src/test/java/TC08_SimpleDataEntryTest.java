
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TC08_SimpleDataEntryTest  extends  BaseTest {

  private HomePage homepage = null;
  private AccountLoginPage accountLoginPage = null;
  private RegisterAccountPage registerAccountPage = null;
  private DesktopPage desktopPage = null;
  private AddressBookEntriesPage addressBookEntriesPage = null;
  private AddressBookPage addressBookPage = null;
  private PersonalAccountPage personalAccountPage = null;
  private AddAddressPage addAddressPage = null;

  @Test
  public void SimpleDataEntryTest() throws InterruptedException {

    homepage = new HomePage(driver);
    accountLoginPage = new AccountLoginPage(driver);
    registerAccountPage = new RegisterAccountPage(driver);
    addressBookPage = new AddressBookPage(driver);
    addressBookEntriesPage  = new AddressBookEntriesPage(driver);
    personalAccountPage = new PersonalAccountPage(driver);
    addAddressPage = new AddAddressPage(driver);

    homepage.open();
    makeScreenshot();
    LOG.info("Taken a screenshot");
    homepage.clickToMyAccountLink();
    LOG.info("Load account login page");
    makeScreenshot();
    LOG.info("Take a screenshot");
    accountLoginPage.loginReturningCustomer( REGISTRATED_EMAIL, REGISTRATED_PASSWORD);
    makeScreenshot();
    LOG.info("Take a screenshot");
    assertThat( driver.getTitle()).isEqualTo("My Account");
    personalAccountPage.getMenuAddressBook().click();
    assertThat(ExpectedConditions.elementToBeClickable(addressBookEntriesPage.getNewAddressButton()));
    int dataRowCount = addAddressPage.getBookAddressItemCount();
    makeScreenshot();
    LOG.info("Take a screenshot");
    addressBookEntriesPage.getNewAddressButton().click();
    assertThat(ExpectedConditions.elementToBeClickable(addAddressPage.getSubmitButton()));
    makeScreenshot();
    LOG.info("Take a screenshot");
    LOG.info("Data row count before upload: " + dataRowCount) ;
    addAddressPage.uploadBookData(
            "Peter", "Fekete", "Kerekgyar", "Loter 12.",
            "", "Karakoszorcsog", "1212", "Uganda", "Apac");
    addAddressPage.getSubmitButton().click();
    makeScreenshot();
    LOG.info("Take a screenshot");
    assertThat(ExpectedConditions.elementToBeClickable(addressBookEntriesPage.getNewAddressButton()));
    LOG.info("Data row count after upload: " + addAddressPage.getBookAddressItemCount()) ;
    assertThat(addAddressPage.getBookAddressItemCount()).isEqualTo(dataRowCount + 1);

  }
}
