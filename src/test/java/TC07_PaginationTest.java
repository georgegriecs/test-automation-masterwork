import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Felhasznalok kezelese a Your Store webaruhazban")
@Feature("Termekek listazasa")
@Story("Navigalas elore es vissza a lapokon")
public class TC07_PaginationTest extends BaseTest {

  @Test
  @Description("Elore navigalunk a lapokon")
  public void paginationTest () {

    homepage.open();
    makeScreenshot();
    LOG.info("Kepernyokep keszites");
    homepage.showAllDesktop();
    desktopPage.waitForAllProductVisibility();
    LOG.info("Mutasd az osszes termeket");
    LOG.info("Activ page: " + desktopPage.getActivePageNumber());
    assertThat(desktopPage.getActivePageNumber()).isEqualTo("1");
    desktopPage.stepToNextPage();
    LOG.info("Activ page: " + desktopPage.getActivePageNumber());
    assertThat(desktopPage.getActivePageNumber()).isEqualTo("2");
    desktopPage.stepPreviousPage();
    LOG.info("Activ page: " + desktopPage.getActivePageNumber());
    assertThat(desktopPage.getActivePageNumber()).isEqualTo("1");
  }
}
