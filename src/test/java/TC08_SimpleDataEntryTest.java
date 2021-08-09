import com.sun.javaws.jnl.ExtDownloadDesc;
import org.openqa.selenium.WebDriver;
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

  public TC08_SimpleDataEntryTest() {

    homepage = new HomePage(driver);
    accountLoginPage = new AccountLoginPage(driver);
    registerAccountPage = new RegisterAccountPage(driver);
    addressBookPage = new AddressBookPage(driver);
    addressBookEntriesPage  = new AddressBookEntriesPage(driver);

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

    addressBookEntriesPage.getNewAddressButton().click();
    assertThat(ExpectedConditions.elementToBeClickable(addressBookPage.getCountinueButton()));
    LOG.info("Take a screenshot");



  }
}
