import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.comparable;

public class TC09_RepetitivDataUpload  extends  BaseTest {

  @ParameterizedTest
  @CsvFileSource(resources = "/AddressList.csv")
  public void repetitivDataUploadTest(String firstName, String lastName, String company, String address, String city, String postCode, String country, String region) throws InterruptedException {

    homepage.open();
    LOG.info("A weboldal főoldala megnyitódott!");
    homepage.openAccountLoginPage();
    LOG.info("A login page betöltődött");
    accountLoginPage.loginReturningCustomer( REGISTRATED_EMAIL, REGISTRATED_PASSWORD);
    assertThat( driver.getTitle()).isEqualTo("My Account");
    personalAccountPage.getMenuAddressBook().click();
    assertThat(ExpectedConditions.elementToBeClickable(addressBookEntriesPage.getNewAddressButton()));
    makeScreenshot();
    LOG.info("Képernyőkép készítés");
    int dataRowCount = addAddressPage.getBookAddressItemCount();
    LOG.info("Címjegyzék számossága feltöltés előtt: " + dataRowCount);
    addressBookEntriesPage.getNewAddressButton().click();
    assertThat(ExpectedConditions.elementToBeClickable(addAddressPage.getSubmitButton()));
    makeScreenshot();
    LOG.info("Képernyőkép készítés");
    addAddressPage.uploadBookData( firstName, lastName, company, address, "", city, postCode, country, region);
    makeScreenshot();
    LOG.info("Képernyőkép készítés");
    addAddressPage.getSubmitButton().click();
    wait.until(ExpectedConditions.elementToBeClickable(addressBookEntriesPage.getNewAddressButton()));
    LOG.info("Címjegyzék számossága feltöltés után: " + addAddressPage.getBookAddressItemCount());
    assertThat(addAddressPage.getBookAddressItemCount()).isEqualTo(dataRowCount + 1);
    addAddressPage.getLogoutMenu().click();
    wait.until(ExpectedConditions.visibilityOf(logoutPage.getContinueButton()));
    logoutPage.getContinueButton().click();
  }


}
