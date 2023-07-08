import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pages.RefreshPage.*;


public class RefreshPageScript {
    private WebDriver driver;
    private final static String EXPECTED_PERCENT_TEXT = "50";

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
    public void testRefreshPage() {
        driver.get(REFRESH_URL);
        driver.findElement(DOWNLOAD_BUTTON).click();
        waitForVisibleText();
        driver.navigate().refresh();
    }

    private void waitForVisibleText() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.pollingEvery(Duration.ofSeconds(0, 1));
        wait.until((ExpectedConditions.textToBePresentInElement(driver.findElement(PERCENT_TEXT), EXPECTED_PERCENT_TEXT)));
    }
}