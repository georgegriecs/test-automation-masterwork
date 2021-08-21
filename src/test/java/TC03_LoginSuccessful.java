import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Felhasznalok kezelese a Your Store webaruhazban")
@Feature("Felhasznaloi belepes")
@Story("Sikeres belepes")
public class TC03_LoginSuccessful extends BaseTest {

  @Test
  @DisplayName("Sikeres belepes szabalyos parameterekkel")
  public void loginSuccessful() {
    homepage.open();
    LOG.info("A folap betoltodott");
    homepage.openAccountLoginPage();
    LOG.info("A login page betoltodott");
    accountLoginPage.loginReturningCustomer( REGISTRATED_EMAIL, REGISTRATED_PASSWORD, true );
    assertThat( driver.getTitle()).isEqualTo("My Account");
  }
}
