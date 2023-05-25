import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static pages.YandexLoginPage.*;

public class YandexTest {
    private WebDriver driver;
    private final static String PASSWORD = "NK852456";
    private final static String LOGIN = "NatalliaKrasotkina";
    private final static String MAIL_URL = "https://mail.yandex.com";

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    void yandexTest() {
        driver.get(MAIL_URL);
        driver.findElement(ENTER_BUTTON).click();
        driver.findElement(LOGIN_INPUT).sendKeys(LOGIN);
        driver.findElement(LOGIN_BUTTON).click();
        driver.findElement(PASSWORD_INPUT).sendKeys(PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();

        Assertions.assertEquals(LOGIN, driver.findElement(ACCOUNT_NAME).getText(), "Login failed");
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
