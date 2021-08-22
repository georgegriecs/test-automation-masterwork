import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Felhasznalok kezelese a Your Store webaruhazban")
@Feature("Cimlista kezelese")
@Story("Cimlistahoz hozzadunk egy tetelt")
public class TC08_SimpleDataEntryTest  extends  BaseTest {

  @Test
  @DisplayName("Egy uj cimadatokat adunk a meglevo listahoz")
  public void SimpleDataEntryTest() throws InterruptedException {
    homepage.open();
    LOG.info("A folap betoltodott");
    homepage.openAccountLoginPage();
    LOG.info("A login page betoltodott");
    accountLoginPage.loginReturningCustomer( REGISTRATED_EMAIL, REGISTRATED_PASSWORD, true );
    assertThat( driver.getTitle()).isEqualTo("My Account");
    personalAccountPage.getMenuAddressBook().click();
    assertThat(ExpectedConditions.elementToBeClickable(addressBookEntriesPage.getNewAddressButton()));
    int dataRowCount = addAddressPage.getBookAddressItemCount();
    makeScreenshot();
    LOG.info("Kepernyokep keszites");
    addressBookEntriesPage.getNewAddressButton().click();
    assertThat(ExpectedConditions.elementToBeClickable(addAddressPage.getSubmitButton()));
    makeScreenshot();
    LOG.info("Kepernyokep keszites");
    LOG.info("Cimlista szamossaga feltoltes elott: " + dataRowCount) ;
    addAddressPage.uploadBookData(
            "Peter", "Fekete", "Kerekgyar", "Loter 12.",
            "", "Karakoszorcsog", "1212", "Uganda", "Apac");
    addAddressPage.getSubmitButton().click();
    makeScreenshot();
    LOG.info("Kepernyokep keszites");
    assertThat(ExpectedConditions.elementToBeClickable(addressBookEntriesPage.getNewAddressButton()));
    LOG.info("Cimlista szamossaga feltoltes utan: " + addAddressPage.getBookAddressItemCount()) ;
    assertThat(addAddressPage.getBookAddressItemCount()).isEqualTo(dataRowCount + 1);

  }
}
