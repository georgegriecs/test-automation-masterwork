import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("")
@Feature("")
@Story("")
public class TC10_DataEditingTest extends BaseTest {

  final String MODIFIER_TEXT = "plus_text";

  @Test
  @DisplayName("delete teszt")
  public void dataEditing() throws InterruptedException {
    String modifiedFieldText = "";

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
    addressBookEntriesPage.editFirstAddress();
    wait.until(ExpectedConditions.elementToBeClickable(editAddressPage.getContinueButton()));
    LOG.info("Edit Address page betoltodott!");
    modifiedFieldText = editAddressPage.getFirstNameText();
    editAddressPage.updateFirstName( editAddressPage.getFirstNameText() + MODIFIER_TEXT );
    wait.until(ExpectedConditions.elementToBeClickable(addressBookEntriesPage.getNewAddressButton()));
    assertThat(addressBookEntriesPage.getSuccessAddedNewAddressMessage().getText())
            .isEqualTo("Your address has been successfully updated");
    addressBookEntriesPage.editFirstAddress();

    wait.until(ExpectedConditions.elementToBeClickable(editAddressPage.getContinueButton()));
    assertThat(modifiedFieldText + MODIFIER_TEXT)
            .isEqualTo(editAddressPage.getFirstNameText());
  }
}
