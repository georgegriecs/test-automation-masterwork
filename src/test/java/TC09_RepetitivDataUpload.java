import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Felhasznalok kezelese a Your Store webaruhazban")
@Feature("Cimlista kezelese")
@Story("Cimlistahoz hozzadunk egy csv fileban levo cimlistat")
public class TC09_RepetitivDataUpload  extends  BaseTest {

  @ParameterizedTest
  @CsvFileSource(resources = "/AddressList.csv")
  public void repetitivDataUploadTest(String firstName, String lastName, String company, String address, String city, String postCode, String country, String region) throws InterruptedException {
    homepage.open();
    LOG.info("A folap betoltodott");
    homepage.openAccountLoginPage();
    LOG.info("A login page betoltodott");
    accountLoginPage.loginReturningCustomer( REGISTRATED_EMAIL, REGISTRATED_PASSWORD, true);
    assertThat( driver.getTitle()).isEqualTo("My Account");
    personalAccountPage.getMenuAddressBook().click();
    assertThat(ExpectedConditions.elementToBeClickable(addressBookEntriesPage.getNewAddressButton()));
    makeScreenshot();
    LOG.info("Kepernyokep keszites");
    int dataRowCount = addAddressPage.getBookAddressItemCount();
    LOG.info("Cimjegyzek szamossaga feltoltes elott: " + dataRowCount);
    addressBookEntriesPage.getNewAddressButton().click();
    assertThat(ExpectedConditions.elementToBeClickable(addAddressPage.getSubmitButton()));
    makeScreenshot();
    LOG.info("Kepernyokep keszites");
    addAddressPage.uploadBookData( firstName, lastName, company, address, "", city, postCode, country, region);
    makeScreenshot();
    LOG.info("Kepernyokep keszites");
    addAddressPage.getSubmitButton().click();
    wait.until(ExpectedConditions.elementToBeClickable(addressBookEntriesPage.getNewAddressButton()));
    LOG.info("Cimjegyzek szamossaga feltoltes utan: " + addAddressPage.getBookAddressItemCount());
    assertThat(addAddressPage.getBookAddressItemCount()).isEqualTo(dataRowCount + 1);
    addAddressPage.getLogoutMenu().click();
    wait.until(ExpectedConditions.visibilityOf(logoutPage.getContinueButton()));
    logoutPage.getContinueButton().click();
  }
}
