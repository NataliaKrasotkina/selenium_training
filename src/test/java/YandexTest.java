import configuration.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.YandexLoginPage;

public class YandexTest {
    private WebDriver driver;
    private final static String PASSWORD = "NK852456";
    private final static String LOGIN = "NatalliaKrasotkina";
    private final static String MAIL_URL = "https://mail.yandex.com";
    private YandexLoginPage yandexLoginPage;

    @BeforeEach
    void setup() {
        driver = DriverManager.getInstance();
        yandexLoginPage = new YandexLoginPage();
    }

    @Test
    void yandexTest() {
        driver.get(MAIL_URL);
        yandexLoginPage.clickEnterButton();
        yandexLoginPage.enterTextToLoginField(LOGIN);
        yandexLoginPage.clickLoginButton();
        yandexLoginPage.enterTextToPasswordField(PASSWORD);
        yandexLoginPage.clickLoginButton();

        Assertions.assertEquals(LOGIN, yandexLoginPage.getAccountName(), "Login failed");

        yandexLoginPage.clickAccountIcon();
        yandexLoginPage.clickLogOutButton();

        Assertions.assertTrue(yandexLoginPage.isEnterButtonPresent(), "Log Out failed");
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
