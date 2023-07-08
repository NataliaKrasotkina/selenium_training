import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static pages.MultiSelectPage.DEMO_URL;
import static pages.MultiSelectPage.MULTI_SELECT_LIST;


public class MultiSelectTest {
    private WebDriver driver;
    private final static List<String> OPTIONS = List.of("California", "Florida", "Texas");

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }

    @Test
    public void testMultipleSelectList() {
        driver.get(DEMO_URL);
        Select dropdown = new Select(driver.findElement(MULTI_SELECT_LIST));
        OPTIONS.forEach(dropdown::selectByValue);
        List<WebElement> selectedOptions = dropdown.getAllSelectedOptions();
        List<String> selectedOptionsNames = new ArrayList<>();
        for (WebElement option : selectedOptions) {
            selectedOptionsNames.add(option.getText());
        }

        Assertions.assertEquals(OPTIONS, selectedOptionsNames, "Options are not selected");
    }
}

