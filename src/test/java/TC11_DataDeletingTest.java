import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("A Your Store web applikacio felhasznalo adminisztracio")
@Feature("Cimjegyzek adminisztracio")
@Story("Egy cim torlese")
public class TC11_DataDeletingTest  extends BaseTest {

  private int dataRowCountBefore;
  private int dataRowCountAfter;

  final String AT_LEAST_ONE_MESSAGE = "Warning: You must have at least one address!";
  final String SUCCESSFUL_MESSAGE = "Your address has been successfully deleted";

  @Test
  @DisplayName("")
  public void deleteItemsFromAddressBook() throws InterruptedException {

    homepage.open();
    LOG.info("A homepage betoltodott");
    homepage.openAccountLoginPage();
    LOG.info("A login page betoltodott");
    accountLoginPage.loginReturningCustomer( REGISTRATED_EMAIL, REGISTRATED_PASSWORD);
    LOG.info("A My Account page betoltodott");
    personalAccountPage.getMenuAddressBook().click();
    wait.until(ExpectedConditions.elementToBeClickable(addressBookEntriesPage.getNewAddressButton()));
    LOG.info("A Address Book Entries page betoltodott");
    makeScreenshot();
    LOG.info("Kepernyokep keszites");
    do {
      dataRowCountBefore = addAddressPage.getBookAddressItemCount();
      LOG.info("Cimjegyzek szamossaga torles elott: " + dataRowCountBefore);
      if (dataRowCountBefore == 0) {
        return;
      }
      addressBookEntriesPage.deleteFirstAddress();
      wait.until(ExpectedConditions.elementToBeClickable(addressBookEntriesPage.getNewAddressButton()));
      makeScreenshot();
      LOG.info("Kepernyokep keszites");
      dataRowCountAfter = addAddressPage.getBookAddressItemCount();
      LOG.info("Cimjegyzek szamossaga torles utan: " + addAddressPage.getBookAddressItemCount());
      if (dataRowCountBefore == 1) {
        assertThat(dataRowCountBefore).isEqualTo(dataRowCountAfter);
        assertThat(addressBookEntriesPage.getSuccessAddedNewAddressMessage().getText()).isEqualTo(AT_LEAST_ONE_MESSAGE);
      } else if (dataRowCountAfter > 1) {
        assertThat(dataRowCountBefore).isEqualTo(dataRowCountAfter + 1);
        assertThat(addressBookEntriesPage.getSuccessAddedNewAddressMessage().getText()).isEqualTo(SUCCESSFUL_MESSAGE);
      }
    } while( dataRowCountBefore > 1 );
  }
}
