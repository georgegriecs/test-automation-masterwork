import static org.assertj.core.api.Assertions.assertThat;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import java.util.Collections;
import java.util.List;

@Epic("Felhasznalok kezelese a Your Store webaruhazban")
@Feature("Termekek listazasa")
@Story("Termekek ar szerint listazva")
public class TC06_DataListingTest extends BaseTest {

  @Test
  @DisplayName("Termekek ar szerint csokkeno sorrendben listazva")
  public void dataListingTest() {
    homepage.open();
    LOG.info("A folap betoltodott");
    homepage.showAllDesktop();
    LOG.info("Mutass az osszes termeket");
    desktopPage.setSortByCategory("Price (Low > High)");
    LOG.info("Ar szerint rendezve");
    desktopPage.setShowProductQuantity("100");
    LOG.info("Mutass az osszes termeket");
    List<WebElement> productList = desktopPage.getProductList();
    LOG.info( "Termek mennyiseg: " + productList.size() );
    List<Float> originList = desktopPage.getFloatPriceList();
    LOG.info("Vegyuk az eredeti termek listat");
    List<Float> sortedList = desktopPage.getFloatPriceList();
    Collections.sort(sortedList);
    LOG.info("Vegyuk az ar szerint rendezett termek listat");
    assertThat(originList).containsExactlyElementsOf(sortedList);
    LOG.info("Egyezzik a ket lista?");
  }
}
