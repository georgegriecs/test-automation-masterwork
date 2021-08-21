import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Felhasznalok kezelese a Your Store webaruhazban")
@Feature("Felhasznaloi regisztracio")
@Story("Sikeres regisztracio")
public class TC01_SuccessfulRegistration  extends BaseTest {

  private final String SUCCESSFUL_REGISTRATION_MESSAGE = "Your Account Has Been Created!";

  @Test
  @Description("Sikeres regisztracio allando nevvel de random email cimmel")
  public void successfulRegistration() {
    homepage.open();
    LOG.info("A folap betoltodott");
    homepage.openAccountLoginPage();
    LOG.info("A login page betoltodott");
    accountLoginPage.clickToNewCustomerButton();
    LOG.info("Az uj felhasznalo folytatas gombra kattintunk");
    makeScreenshot();
    LOG.info("Kepernyokep keszites");
    registerAccountPage.registerNewCustomer( "test_fname", "test_lname", generateEmail(), "+361234566", REGISTRATED_PASSWORD );
    makeScreenshot();
    LOG.info("Kepernyokep keszites");
    assertThat(driver.getTitle()).isEqualTo(SUCCESSFUL_REGISTRATION_MESSAGE);
    LOG.info("Sikeres belepes");
  }

  public String generateEmail() {
    return "test_" + ((int)( Math.random() * 100000000 )) + "@test.hu";
  }
}
