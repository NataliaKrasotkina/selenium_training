import com.google.common.collect.ImmutableMap;
import configuration.DriverManager;
import configuration.MyTestWatcher;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;


@ExtendWith(MyTestWatcher.class)
public class BaseTest {
    private WebDriver driver;
    private final static String MAIL_URL = "https://mail.yandex.com";

    @BeforeAll
    public static void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", DriverManager.getInfo())
                        .put("URL", MAIL_URL)
                        .build(), System.getProperty("user.dir")
                        + "\\allure-results\\");
    }

    @BeforeEach
    public void setup() {
        driver = DriverManager.getInstance();
        driver.get(MAIL_URL);
    }

    @AfterAll
    public static void cleanup() {
        DriverManager.quit();
    }
}