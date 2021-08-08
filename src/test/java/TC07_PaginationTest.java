import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import pages.AccountLoginPage;
import pages.DesktopPage;
import pages.HomePage;
import pages.RegisterAccountPage;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Customer administration processes in YourStore web app")
@Feature("Product data listing")
@Story("Navigate to between next and previous page ")

public class TC07_PaginationTest extends BaseTest {
  private HomePage homepage = null;
  private AccountLoginPage accountLoginPage = null;
  private RegisterAccountPage registerAccountPage = null;
  private DesktopPage desktopPage = null;

  @Test
  public void paginationTest (){
    homepage = new HomePage(driver);
    accountLoginPage = new AccountLoginPage(driver);
    registerAccountPage = new RegisterAccountPage(driver);
    desktopPage = new DesktopPage(driver);

    homepage.open();
    makeScreenshot();
    LOG.info("Taken a screenshot");
    homepage.showAllDesktop();
    LOG.info("Show all desktop");
    LOG.info("Active page: " + desktopPage.getActivePageNumber());
    assertThat(desktopPage.getActivePageNumber()).isEqualTo("1");
    desktopPage.stepToNextPage();
    LOG.info("Active page: " + desktopPage.getActivePageNumber());
    assertThat(desktopPage.getActivePageNumber()).isEqualTo("2");
    desktopPage.stepPreviousPage();
    LOG.info("Active page: " + desktopPage.getActivePageNumber());
    assertThat(desktopPage.getActivePageNumber()).isEqualTo("1");
  }
}
