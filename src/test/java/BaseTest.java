import configuration.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MailPage;

public class BaseTest {
    private WebDriver driver;
    private final static String MAIL_URL = "https://mail.yandex.com";

    protected LoginPage loginPage;
    protected MailPage mailPage;

    @BeforeEach
    void setup() {
        driver = DriverManager.getInstance();
        loginPage = new LoginPage();
        driver.get(MAIL_URL);
    }

    @AfterEach
    void cleanup() {
        DriverManager.quit();
    }
}