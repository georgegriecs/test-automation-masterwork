import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.comparable;

public class TC09_RepetitivDataUpload  extends  BaseTest {

  private HomePage homepage = null;
  private AccountLoginPage accountLoginPage = null;
  private RegisterAccountPage registerAccountPage = null;
  private DesktopPage desktopPage = null;
  private AddressBookEntriesPage addressBookEntriesPage = null;
  private AddressBookPage addressBookPage = null;
  private PersonalAccountPage personalAccountPage = null;
  private AddAddressPage addAddressPage = null;
  private LogoutPage logoutPage = null;

  @ParameterizedTest
  @CsvFileSource(resources = "/AddressList.csv")
  public void repetitivDataUploadTest(String firstName, String lastName, String company, String address, String city, String postCode, String country, String region) throws InterruptedException {

    homepage = new HomePage(driver);
    accountLoginPage = new AccountLoginPage(driver);
    registerAccountPage = new RegisterAccountPage(driver);
    addressBookPage = new AddressBookPage(driver);
    addressBookEntriesPage  = new AddressBookEntriesPage(driver);
    personalAccountPage = new PersonalAccountPage(driver);
    addAddressPage = new AddAddressPage(driver);
    logoutPage = new LogoutPage(driver);

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
    addAddressPage.uploadBookData( firstName, lastName, company, address, "", city, postCode, country, region);
    makeScreenshot();
    LOG.info("Take a screenshot");
    addAddressPage.getSubmitButton().click();
    assertThat(ExpectedConditions.elementToBeClickable(addressBookEntriesPage.getNewAddressButton()));
    assertThat(ExpectedConditions.visibilityOf(addressBookEntriesPage.getSuccessAddedNewAddressMessage() ) );
    LOG.info("Data row count after upload: " + addAddressPage.getBookAddressItemCount());
    assertThat(addAddressPage.getBookAddressItemCount()).isEqualTo(dataRowCount + 1);
    addAddressPage.getLogoutMenu().click();
    wait.until(ExpectedConditions.visibilityOf(logoutPage.getContinueButton()));
    logoutPage.getContinueButton().click();
  }
}
