import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pages.RefreshPage.*;


public class RefreshPageScript {
    private WebDriver driver;
    private final static String EXPECTED_PERCENT_TEXT = "50";

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(DOWNLOAD_PROGRESS_URL);
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }

    @Test
    public void refreshPageTest() {
        driver.findElement(DOWNLOAD_BUTTON).click();
        waitForVisibleText();
        driver.navigate().refresh();
    }

    private void waitForVisibleText() {
        new WebDriverWait(driver, 50, 200)
                .until(ExpectedConditions.textToBePresentInElement(driver.findElement(PROGRESS_CIRCLE), EXPECTED_PERCENT_TEXT));
    }
}