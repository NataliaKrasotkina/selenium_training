import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pages.WaitForUserPage.*;

public class WaitForUserTest {
    private WebDriver driver;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(DATA_LOADING_URL);
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }

    @Test
    public void waitForUserTest() {
        driver.findElement(GET_NEW_USER).click();
        waitForVisibleElement();

        Assertions.assertTrue(driver.findElement(USER_IMAGE).isDisplayed(), "User image is not displayed");
    }

    private void waitForVisibleElement() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.pollingEvery(Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(USER_IMAGE));
    }
}


