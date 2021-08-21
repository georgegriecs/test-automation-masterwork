import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Felhasznalok kezelese a Your Store webaruhazban")
@Feature("Felhasznaloi belepes")
@Story("Sikerestelen belepes")
public class TC04_LoginUnsuccessful extends BaseTest {

  @Test
  @Description("Sikertelen bejelentkezes, hibas jelszo miatt")
  public void loginUnsuccessful() {
    homepage.open();
    LOG.info("A folap betoltodott");
    homepage.openAccountLoginPage();
    LOG.info("A login page betoltodott");
    accountLoginPage.loginReturningCustomer( REGISTRATED_EMAIL, REGISTRATED_PASSWORD + "_", false);
    assertThat( accountLoginPage.getWarningMessageNoMatchEmailOrPassword().getText()).isEqualTo(WARNING_MESSAGE_NO_MATCH_EMAIL_PASSWORD);
  }

}
