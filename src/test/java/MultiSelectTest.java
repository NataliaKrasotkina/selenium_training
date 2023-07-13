import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static pages.MultiSelectPage.MULTI_SELECT_LIST;
import static pages.MultiSelectPage.SELECT_DROPDOWN_DEMO_URL;


public class MultiSelectTest {
    private WebDriver driver;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(SELECT_DROPDOWN_DEMO_URL);
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }

    @Test
    public void multipleSelectListTest() {
        Select dropdown = new Select(driver.findElement(MULTI_SELECT_LIST));
        List<String> states = dropdown.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
        Collections.shuffle(states);
        List<String> expectedStates = states.subList(0, 3);
        expectedStates.forEach(dropdown::selectByValue);
        List<String> actualStates = dropdown.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());

        Assertions.assertTrue(expectedStates.containsAll(actualStates), "Options are not selected");
    }
}

