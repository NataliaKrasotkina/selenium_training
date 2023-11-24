import com.google.common.collect.ImmutableMap;
import configuration.DriverManager;
import configuration.MyTestWatcher;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;


@ExtendWith(MyTestWatcher.class)
public class BaseTest {
    private WebDriver driver;
    private final static String MAIL_URL = "https://mail.yandex.com";
    public static final String SCREENSHOTS_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\";

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

    protected void takeScreenshot(String fileName) {
        TakesScreenshot screen = (TakesScreenshot) driver;
        File srcFile = screen.getScreenshotAs(OutputType.FILE);
        File destFile = new File(SCREENSHOTS_PATH + fileName);
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @AfterAll
    public static void cleanup() {
        DriverManager.quit();
    }
}