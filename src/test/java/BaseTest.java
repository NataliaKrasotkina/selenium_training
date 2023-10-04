import configuration.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    private WebDriver driver;
    private final static String MAIL_URL = "https://mail.yandex.com";

    @BeforeEach
    void setup() {
        driver = DriverManager.getInstance();
        driver.get(MAIL_URL);
    }

    @AfterEach
    void cleanup() {
        DriverManager.quit();
    }
}