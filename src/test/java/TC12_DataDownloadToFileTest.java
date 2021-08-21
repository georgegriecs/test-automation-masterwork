import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("")
@Feature("")
@Story("")
public class TC12_DataDownloadToFileTest extends BaseTest  {

  private final String FILE_PATH = "src/test/resources/price_list.txt";
  private List<String> loadedFileLines = new ArrayList<>();
  @Test
  @DisplayName("-")
  public void dataDownloadTest() {
    homepage.open();
    makeScreenshot();
    LOG.info("Kepernyokep keszitese");
    homepage.showAllDesktop();
    LOG.info("Mutasd az osszes termeket");
    desktopPage.setSortByCategory("Price (Low > High)");
    LOG.info("Ar szerinti rendezes");
    desktopPage.setShowProductQuantity("100");
    LOG.info("Mutasd az osszes termeket");
    List<String> productList = desktopPage.getDataLines();
    for (String str : productList) {
      LOG.info(str);
    }
    saveToFile( productList );
    LOG.info("Adatok mentese fileba");
    loadedFileLines = loadFromFile();
    LOG.info("Adatok betoltese filebol");
    assertThat(productList).containsExactlyElementsOf(loadedFileLines);
    LOG.info("Adatok osszehasonlitasa");
  }

  public void saveToFile( List<String> lineList ) {
    Path filePath = Paths.get(FILE_PATH);
    try {
      Files.write(filePath, lineList);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public List<String> loadFromFile() {
    List<String> resultList = new ArrayList<>();
    try {
      resultList = Files.readAllLines( Paths.get(FILE_PATH));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return resultList;
  }
}
