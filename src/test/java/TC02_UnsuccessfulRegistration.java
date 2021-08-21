import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Felhasznalok kezelese a Your Store webaruhazban")
@Feature("Felhasznaloi regisztracio")
@Story("Sikertelen regisztracio")
public class TC02_UnsuccessfulRegistration  extends BaseTest {

  @Test
  @DisplayName("Sikertelen regisztracio, mar regisztralt felhasznalo adataival")
  public void successfulRegistration() {
    homepage.open();
    LOG.info("A folap betoltodott");
    homepage.openAccountLoginPage();
    LOG.info("A login page betoltodott");
    accountLoginPage.clickToNewCustomerButton();
    LOG.info("Az uj felhasznalo folytatas gombra kattintunk");
    makeScreenshot();
    LOG.info("Kepernyokep keszites");
    registerAccountPage.registerNewCustomer("test_fname", "test_lname", REGISTRATED_EMAIL, "+361234566", REGISTRATED_PASSWORD);
    makeScreenshot();
    LOG.info("Kepernyokep keszites");
    assertThat(registerAccountPage.getWarningMessage()).isEqualTo(UNSUCCESSFUL_REGISTRATION_MESSAGE);
    LOG.info("Email already registered uezenet!");
  }


}