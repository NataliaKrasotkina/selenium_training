import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static pages.YandexLoginPage.*;


public class YandexTest {
    private WebDriver driver;
    private final static String PASSWORD_1 = "NK852456";
    private final static String LOGIN_1 = "NatalliaKrasotkina";
    private final static String PASSWORD_2 = "NK8524567";
    private final static String LOGIN_2 = "NatalliaKrasotkina2";
    private final static String MAIL_URL = "https://mail.yandex.com";

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void yandexTest(String login, String password) throws InterruptedException {
        driver.get(MAIL_URL);
        Thread.sleep(1000);//Thread.sleep is explicit waiter

        driver.findElement(ENTER_BUTTON).click();
        driver.findElement(LOGIN_INPUT).sendKeys(login);
        driver.findElement(LOGIN_BUTTON).click();
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        waitForVisibleElement(driver.findElement(ACCOUNT_NAME));


    }

    public void waitForVisibleElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.pollingEvery(Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(LOGIN_1, PASSWORD_1),
                Arguments.of(LOGIN_2, PASSWORD_2)
        );
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}
