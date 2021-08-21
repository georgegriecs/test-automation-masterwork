import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Felhasznalok kezelese a Your Store webaruhazban")
@Feature("Felhasznaloi regisztracio")
@Story("Adatvedelmi iranyelvek jelolonegyzet es nyilatkozat kezelese")
public class TC05_PrivacyStatementTest extends BaseTest {

  @Test
  @DisplayName("Az adatvedelmi nyilatkozat megnyitasa es a jelolonegyzet kipipalasa")
  public void privacyStatementTest() {
    navigateToRegisterAccountPage();
    makeScreenshot();
    LOG.info("Kepernyokep keszites");
    registerAccountPage.openPrivacyPolicy();
    makeScreenshot();
    LOG.info("Kepernyokep keszites");
    assertThat(registerAccountPage.getPrivacyPolicyModalText()).isEqualTo("Privacy Policy");
    registerAccountPage.closePrivacyPolicyModalForm();
    makeScreenshot();
    LOG.info("Kepernyokep keszites");
    registerAccountPage.clickToPrivacyPolicyCheckBox();
    makeScreenshot();
    LOG.info("Kepernyokep keszites");
    assertThat( registerAccountPage.getPrivacyPolicyState() ).isTrue();
  }

  private void navigateToRegisterAccountPage() {
    homepage.open();
    LOG.info("A folap betoltodott");
    homepage.openAccountLoginPage();
    LOG.info("A login page betoltodott");
    accountLoginPage.clickToNewCustomerButton();
    LOG.info("Az uj felhasznalo folytatas gombra kattintunk");
  }
}
